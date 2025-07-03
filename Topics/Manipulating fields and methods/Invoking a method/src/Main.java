import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodsDemo {

    public static void main(String[] args) {
        // write your code here
        try {
            Method[] methods = SomeClass.class.getDeclaredMethods();
            for (Method method : methods) {
                method.setAccessible(true);
                System.out.println(method.invoke(null));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}