package stu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMeta {
	String studentNumber() default "";  
	String name()  default "";
	String password() default ""; 
	String profession() default "";
}
