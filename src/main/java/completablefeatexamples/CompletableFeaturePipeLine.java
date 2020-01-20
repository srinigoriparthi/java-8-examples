package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeaturePipeLine {

    public static void process(CompletableFuture<Integer> future){
        future
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
