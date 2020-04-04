package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavouriteShot"),
                new Shop("BuyItAll"),

                new Shop("AA"),
                new Shop("AA"),
                new Shop("AA"),
                new Shop("AA"),

                new Shop("AA"),
                new Shop("AA"),
                new Shop("AA"),
                new Shop("AA"),

                new Shop("AA"),
                new Shop("AA"),
                new Shop("AA"),
                new Shop("AA")
        );


        //Shop shop = new Shop("BestShop");
        Executor executor = getExecutor(shops.size());

        long start = System.nanoTime();
        System.out.println(findPricesAsync(shops, "iphone", executor));
        //Future<Double> futurePrice = shop.getPriceAsync("my favourite product");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");

        /*doSomethingElse();

        try {
            Double price = futurePrice.get();
            System.out.printf("price is %.2f%n", price);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");*/

    }

    public static List<String> findPricesAsync(List<Shop> shops, String product, Executor executor) {
        List<CompletableFuture<String>> priceFutures = useAsync(shops, product, executor);
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        /*return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());*/
    }

    public static List<String> findPrices(List<Shop> shops, String product) {
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<CompletableFuture<String>> useAsync(List<Shop> shops, String product, Executor executor) {
        return shops.stream().map(
                shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), executor))
                .collect(Collectors.toList());
    }

    public static Executor getExecutor(int size) {
        return Executors.newFixedThreadPool(Math.min(size, 100), r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

    }

    private static void doSomethingElse() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
