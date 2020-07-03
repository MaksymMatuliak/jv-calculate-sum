package homework;

import java.util.concurrent.Callable;

public class ThreadCounter implements Callable<Integer> {
    private RandomNumberList randomNumberList;
    private int partOfList;
    private int amountOfThread;

    public ThreadCounter(RandomNumberList randomNumberList, int partOfList, int amountOfThread) {
        this.randomNumberList = randomNumberList;
        this.partOfList = partOfList;
        this.amountOfThread = amountOfThread;
    }

    @Override
    public Integer call() {
        Integer sum = randomNumberList.getNumbers()
                .stream()
                .skip((partOfList - 1) * ((randomNumberList.getNumbers().size() / amountOfThread) + 1))
                .limit(randomNumberList.getNumbers().size() / amountOfThread + 1)
                .reduce(0, Integer::sum);
        System.out.println("ThreadCounter finished work and result is: " + sum);
        return sum;
    }
}
