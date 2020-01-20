package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureCombine {

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(() -> n*2);
    }
    public static void main(String args[]){
        create(2)
                .thenCombine(create(3), (a,b) -> a+b)
                .thenAccept(System.out::println);
    }
}
