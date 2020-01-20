package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureByPassExceptionally {

    public static int handle(Throwable throwable){
        System.out.println(("Exception:"+throwable));
        return 100;
    }
    public static void process(CompletableFuture<Integer> future){
        future
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data -> data * 2)
                .thenApply(data -> data +1)
                .thenAccept(System.out::println);
    }

    public static void main(String args[]){
        System.out.println("Main:"+Thread.currentThread());
        CompletableFuture<Integer> future = new CompletableFuture<>();
        process(future);
        future.complete(2);
    }
}
