package homework;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    private static final int NUMBERS_OF_TREADS = 2;
    private static final int FIRST_PART = 1;
    private static final int SECOND_PART = 2;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RandomNumberList numbers = new RandomNumberList();
        ThreadCounter threadCounter =
                new ThreadCounter(numbers, FIRST_PART, NUMBERS_OF_TREADS);
        ThreadCounter secondThread =
                new ThreadCounter(numbers, SECOND_PART, NUMBERS_OF_TREADS);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBERS_OF_TREADS);
        List<Future<Integer>> futuresFromExecurotService =
                executorService.invokeAll(List.of(threadCounter, secondThread));
        System.out.println("Sum is " + (futuresFromExecurotService.get(0).get()
                + futuresFromExecurotService.get(1).get()));
        System.out.println("---------------------------------------------------------");
        ForkJoinPool forkJoinPool = new ForkJoinPool(NUMBERS_OF_TREADS);
        List<Future<Integer>> futuresFromForkJoin =
                forkJoinPool.invokeAll(List.of(threadCounter, secondThread));
        System.out.println("Sum is " + (futuresFromForkJoin.get(0).get()
                + futuresFromForkJoin.get(1).get()));
    }
}
