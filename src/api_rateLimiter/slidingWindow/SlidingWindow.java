package api_rateLimiter.slidingWindow;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {
    private Queue<Long> slidingQueue;
    private long timeWindowInSec;
    private int capacity;

    public SlidingWindow(long timeWindowInSec, int capacity) {
        this.slidingQueue = new ConcurrentLinkedQueue<>();
        this.timeWindowInSec = timeWindowInSec;
        this.capacity = capacity;
    }

    @Override
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        checkCapacityInQueue(currentTime);
        if(slidingQueue.size() < capacity){
            slidingQueue.add(currentTime);
            return true;
        }
        return false;
    }

    private void checkCapacityInQueue(long currentTime){
        if(slidingQueue.isEmpty())
            return;

        long calculatedTime = (currentTime - slidingQueue.peek()) / 1000;

        while(calculatedTime >= timeWindowInSec){
            slidingQueue.poll();
            if(slidingQueue.isEmpty())break;
            calculatedTime = currentTime - slidingQueue.peek();
        }
    }
}
