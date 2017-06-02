package stu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMeta2 {
	String studentNumber() default "";  
	String name()  default "";
	String age() default ""; 
	String wage() default "";
	String sex() default "";
}

