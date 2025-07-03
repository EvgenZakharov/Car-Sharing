import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

class StreamOfPrimitives {

    public static LongStream getLongStream(int n) {
        // write your code here
        LongStream longs = LongStream
                .rangeClosed(-n, n)
//                .skip(1)
                .filter( i -> i !=0);
        return longs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String result = getLongStream(n).mapToObj(e -> e)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}