import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface PrintArgs {
    boolean printReturn() default false;
}

class TestClass {
    @PrintArgs(printReturn = true)
    public void myMethod() {
        // some code

    }
}