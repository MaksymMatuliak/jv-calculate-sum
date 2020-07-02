package homework;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RandomNumberList numbers = new RandomNumberList();
        ThreadCounter threadCounter =
                new ThreadCounter(numbers, 1, 2);
        ThreadCounter secondThread =
                new ThreadCounter(numbers, 2, 2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futuresFromExecurotService =
                executorService.invokeAll(List.of(threadCounter, secondThread));
        System.out.println("Sum is " + (futuresFromExecurotService.get(0).get()
                + futuresFromExecurotService.get(1).get()));
        System.out.println("----------------------------------------------------------");
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        List<Future<Integer>> futuresFromForkJoin =
                forkJoinPool.invokeAll(List.of(threadCounter, secondThread));
        System.out.println("Sum is " + (futuresFromForkJoin.get(0).get()
                + futuresFromForkJoin.get(1).get()));
    }
}
