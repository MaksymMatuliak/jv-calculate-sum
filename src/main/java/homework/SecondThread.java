package homework;

import java.util.concurrent.Callable;

public class SecondThread implements Callable<Integer> {
    private RandomNumberList randomNumberList;

    public SecondThread(RandomNumberList randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    @Override
    public Integer call() {
        Integer sum = randomNumberList.getNumbers()
                .stream()
                .skip(randomNumberList.getNumbers().size() / 2)
                .reduce(0, Integer::sum);
        System.out.println("SecondThread finished work and result is: " + sum);
        return sum;
    }
}
