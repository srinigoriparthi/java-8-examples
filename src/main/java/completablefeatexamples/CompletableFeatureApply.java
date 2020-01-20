package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureApply {

    public static int compute(){
        System.out.println("Compute:"+Thread.currentThread());
        return 2;
    }
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static void main(String args[]){
        System.out.println("Main:"+Thread.currentThread());
        create()
                .thenApply(data -> data *2)
                .thenApply(data -> data +1)
                .thenAccept(data -> System.out.println("Data is:"+data));
    }
}
