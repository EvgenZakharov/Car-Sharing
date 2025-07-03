import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        if (object == null || fieldName == null) {
            return null; // Handle null inputs gracefully
        }

        Class<?> itemClass = object.getClass();

        try {
            // Get the field by name
            Field field = itemClass.getField(fieldName);

            // Check if the field is public
            if (Modifier.isPublic(field.getModifiers())) {
                // Return the value of the field from the given object
                return field.get(object);
            }
        } catch (NoSuchFieldException e) {
            // If the field does not exist, return null
            return null;
        }

        return null; // Return null if the field is not public or accessible

    }

}