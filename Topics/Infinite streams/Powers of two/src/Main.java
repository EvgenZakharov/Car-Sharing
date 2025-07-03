import java.util.stream.Stream;


class StreamUtils {

    public static Stream<Integer> generateStreamWithPowersOfTwo(int n) {
        return Stream.iterate(1, x -> x * 2) // Начинаем с 1, каждый следующий элемент умножаем на 2
                .limit(n); // Ограничиваем количество элементов до n
    }
}