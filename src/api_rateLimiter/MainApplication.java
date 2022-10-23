package api_rateLimiter;

import api_rateLimiter.slidingWindow.UserBucketCreater;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApplication {
    public static void main(String[] args) {
        UserBucketCreater user1Bucket = new UserBucketCreater(1);
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for(int i = 0; i < 12; i++){
            executorService.execute(() -> user1Bucket.grantApplication(1));
        }
        executorService.shutdown();
    }
}
