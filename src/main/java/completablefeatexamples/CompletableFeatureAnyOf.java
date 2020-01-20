package completablefeatexamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFeatureAnyOf {

    static CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Feature One";
    });

    static CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Feature two";
    });

    static CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Feature Three";
    });

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1,future2,future3);
        System.out.println("Which Future Completed:"+anyOfFuture.get());
    }

}
