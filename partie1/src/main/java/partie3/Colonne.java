package partie3;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Colonne {
    String nom() default "";
    boolean nullable() default true;
}