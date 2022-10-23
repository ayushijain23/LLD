package api_rateLimiter.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreater {
    private Map<Integer, SlidingWindow> bucket;

    public  UserBucketCreater(int id){
        bucket = new HashMap<>();
        bucket.put(id, new SlidingWindow(1, 10));
    }

    public void grantApplication(int id){
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+" : Accessed");
        }
        else{
            System.out.println(Thread.currentThread().getName()+": ignored");
        }
    }

}
