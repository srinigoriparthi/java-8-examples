package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureThrowExceptionally {

    public static int handle(Throwable throwable){
        System.out.println(("Exception:"+throwable));
        throw new RuntimeException("This is beyond Exception !!");
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
        future.completeExceptionally(new RuntimeException("Some thing went wrong !!"));
    }
}
