import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 Get an array of fields the object declares that contain annotations (inherited fields should be skipped).
 */
class AnnotationsUtil {

    public static String[] getFieldsContainingAnnotations(Object object) {
        // Add implementation here
        Class itemClass = object.getClass();
        ArrayList<String> resultList = new ArrayList<>();

        for (Field field : itemClass.getDeclaredFields()) {
            if (field.getDeclaredAnnotations().length > 0) {
                resultList.add(field.getName());
            }
        }
        return resultList.toArray(new String[0]);
    }

}