package completablefeatexamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class CompletableFeatureOwnPool {
    public static ForkJoinPool fjp = new ForkJoinPool(10);
    public static int compute(){
        System.out.println("Compute:"+Thread.currentThread());
        return 2;
    }
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(() -> compute(),fjp);
    }

    public static void main(String args[]){
        System.out.println("Main:"+Thread.currentThread());
        CompletableFuture<Integer> cf = create();
        cf.thenAccept(data -> System.out.println("Data is:"+data));
    }
}
