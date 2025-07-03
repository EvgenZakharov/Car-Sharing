import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public String[] getPublicFields(Object object) {
        // Add implementation here
        Class<?> itemClass = object.getClass();
        List<String> list = new ArrayList<>();

        Field[] fields = itemClass.getDeclaredFields();

        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                list.add(field.getName());
            }
        }

        return list.toArray(new String[0]);
    }

}