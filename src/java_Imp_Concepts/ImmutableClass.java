package java_Imp_Concepts;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final HashMap<Integer, String> map;

    public ImmutableClass(int id, String name, HashMap<Integer, String> map) {
        this.id = id;
        this.name = name;
        HashMap<Integer, String> temp = new HashMap<>();

        for(Map.Entry<Integer, String> itr : map.entrySet()){
            temp.put(itr.getKey(), itr.getValue());
        }

        this.map = temp;
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, String> getMap() {
        HashMap<Integer, String> temp = new HashMap<>();
        for(Map.Entry<Integer, String> itr : map.entrySet()){
            temp.put(itr.getKey(), itr.getValue());
        }

        return temp;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> inputMap = new HashMap<>();
        inputMap.put(1, "first");
        inputMap.put(2, "second");

        ImmutableClass obj = new ImmutableClass(1, "ayushi", inputMap);
        System.out.println(obj.getId());
        System.out.println(obj.getName());
        System.out.println("Calling first Time"+obj.getMap());

        inputMap.put(3, "third");
        System.out.println("Calling second Time"+obj.getMap());

        obj.getMap().put(4, "fourth");
        System.out.println("Calling third Time"+obj.getMap());
    }
}
