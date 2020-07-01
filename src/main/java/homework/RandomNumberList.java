package homework;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberList {
    private List<Integer> numbers;

    public RandomNumberList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000_000; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
