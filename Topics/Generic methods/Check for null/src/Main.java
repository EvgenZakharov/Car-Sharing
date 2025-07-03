// do not remove imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    // define hasNull method here
//    public static <E> boolean hasNull(E[] array) {
//        for (E e : array) {
//            if (e == null) {
//                return true;
//            } else return false;
//        }
//        return false;
//    }

    public static <T> boolean hasNull(T[] array) {
        // Check for null elements in the array
        if (array == null) {
            return false; // If the array itself is null, we return false
        }
        for (T element : array) {
            if (element == null) {
                return true; // Return true if a null element is found
            }
        }
        return false; // Return false if no null elements are found
    }

}