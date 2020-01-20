package completablefeatexamples;

import java.util.concurrent.CompletableFuture;

public class CompletableFeatureCompose {

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(() -> n*2);
    }
    public static void main(String args[]){
        create(2)
                .thenCompose(data -> create(data))
                .thenAccept((System.out::println));
    }
}
