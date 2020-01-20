package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureAccept {

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
                .thenAccept(data -> System.out.println("Data is:"+data))
                .thenRun(() -> System.out.println("First Run !!"))
                .thenRun(() -> System.out.println("Second Run !!"));
    }
}
