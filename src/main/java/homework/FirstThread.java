package homework;

import java.util.concurrent.Callable;

public class FirstThread implements Callable<Integer> {
    private RandomNumberList randomNumberList;

    public FirstThread(RandomNumberList randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    @Override
    public Integer call() {
        Integer sum = randomNumberList.getNumbers().stream().reduce(0, Integer::sum);
        System.out.println("FirstThread finished work and result is: " + sum);
        return sum;
    }
}
