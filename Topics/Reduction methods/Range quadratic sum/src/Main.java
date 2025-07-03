import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        // write your code with streams here

        return IntStream.range(fromIncl, toExcl) // создаем поток чисел в диапазоне
                .mapToLong(i -> (long) i * i) // возводим каждое число в квадрат
                .sum(); // суммируем квадраты

    }
}