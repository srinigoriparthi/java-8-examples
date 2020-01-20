package completablefeatexamples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFeatureAllOf {
    public static CompletableFuture<String> downLoadPage(String pageLink){
        return CompletableFuture.supplyAsync(() -> pageLink+"1");
    }
    public  static void main(String args[]){
        List<String> webLinks = Arrays.asList("srini","rao","goriparthi");

        List<CompletableFuture<String>> pageContentFeats = webLinks.stream()
                                    .map(webPageLink -> downLoadPage(webPageLink))
                                    .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                pageContentFeats.toArray(new CompletableFuture[pageContentFeats.size()])
            );

        CompletableFuture<List<String>> allPageContentFeature = allFutures.thenApply(v -> {
           return  pageContentFeats.stream()
                   .map(pageContentFeat -> pageContentFeat.join())
                   .collect(Collectors.toList());
        });

        CompletableFuture<Long> countFeature = allPageContentFeature.thenApply(pageContents -> {
            pageContents.stream().forEach(System.out::println);
            return pageContents.stream().count();
        });

        try {
            System.out.println("Total Pages:"+countFeature.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
