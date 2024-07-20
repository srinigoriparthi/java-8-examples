package completablefeatexamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleatableFeatureException {

    public static CompletableFuture<String> compute(int age){
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if(age > 18) {
                return "Adult";

            } else {
                return "Child";

            }
        }).handle((res, ex) -> {
            if(ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return res;
        });

        return maturityFuture;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = compute(-1);
        System.out.println("Final Result:"+cf.get());

    }

}
