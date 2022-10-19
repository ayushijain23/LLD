package lru_Cache;

import java.util.HashMap;

class Node{
    int key;
    Node next;
    Node prev;

    Node(int key){
        this.key = key;
    }

}
class LRU_Cache {
    HashMap<Integer, Node> map;
    int count, capacity;
    Node head, tail;

    public LRU_Cache(int cacheSize){
        capacity = cacheSize;
        count = 0;
        map = new HashMap<>(cacheSize);
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void set(int key){
        Node newNode = new Node(key);
        map.put(key, newNode);
        if(count < capacity){
            count++;
            addToHead(newNode);
        }
        else{
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
            addToHead(newNode);
        }
    }
    public int get(int key){
        if(map.containsKey(key)){
            Node keyNode = map.get(key);
            deleteNode(keyNode);
            addToHead(keyNode);
            return key;
        }

        else{
            set(key);
        }
       return -1;
    }
}

public class LRU_Cache_Implementation {
    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));

        int key = cache.head.next.key;
        System.out.println(key);

        System.out.println(cache.get(1));

        key = cache.head.next.key;
        System.out.println(key);
        System.out.println(cache.get(4));

        key = cache.head.next.key;
        System.out.println(key);

    }
}
