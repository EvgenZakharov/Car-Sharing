import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class AnnotationUtils {

    public static void printClassAnnotations(Class classObject) {
        // write your code here
        for (Annotation annotation : classObject.getDeclaredAnnotations()) {
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }
}