package future;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //System.out.println(calculateAsync(executorService).get());
        //CFCombine(executorService);
        //executorService.shutdown();

        String amountFormat = "#0";

        amountFormat = constructDecimalPartPattern(amountFormat, 2);
        //String amountFormat1 = constructDecimalPartPattern(amountFormat, 2);
        System.out.println(amountFormat);

    }

    static Future<String> calculateAsync(ExecutorService executorService) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executorService.submit(() -> {
            Thread.sleep(5000);
            completableFuture.complete("Hello");
            System.out.println("Return null");
            return null;
        });

        return completableFuture;
    }

    static void CFCombine(ExecutorService executorService) throws ExecutionException, InterruptedException {
        int x = 5;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        CompletableFuture<Integer> b = new CompletableFuture<>();
        CompletableFuture<Integer> c = a.thenCombine(b, (y, z) -> {
            System.out.println("Start combine");
            return y + z;
        });
        executorService.submit(() -> a.complete(f(x)));
        executorService.submit(() -> b.complete(g(x)));
        System.out.println(c.get());
    }

    static int f(int v) throws InterruptedException {
        System.out.println("Start f");
        Thread.sleep(4000);
        System.out.println("End f");
        return v++;
    }

    public static int g(int v) throws InterruptedException {
        System.out.println("Start g");
        Thread.sleep(2000);
        System.out.println("End g");
        return v++;
    }


    public static String constructDecimalPartPattern(String currentPattern, int numberOfDecimals)
    {
        currentPattern = currentPattern.concat(".");
        char[] fractionPattern = new char[numberOfDecimals];
        Arrays.fill(fractionPattern, '0');
        return currentPattern.concat(new String(fractionPattern));
    }

}