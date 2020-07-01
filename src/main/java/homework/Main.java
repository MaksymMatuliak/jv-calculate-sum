package homework;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RandomNumberList numbers = new RandomNumberList();
        FirstThread firstThread = new FirstThread(numbers);
        SecondThread secondThread = new SecondThread(numbers);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.invokeAll(List.of(firstThread, secondThread));
        System.out.println("----------------------------------------------------------");
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.invokeAll(List.of(firstThread, secondThread));
    }
}
