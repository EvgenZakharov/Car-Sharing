import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        // Преобразуем поток в список
        List<? extends T> list = stream.collect(Collectors.toList());

        // Если список пустой, передаем null для min и max
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        // Находим минимальный и максимальный элементы с помощью компаратора
        T min = list.stream().min(order).orElse(null);
        T max = list.stream().max(order).orElse(null);

        // Передаем найденные значения в minMaxConsumer
        minMaxConsumer.accept(min, max);
    }
}