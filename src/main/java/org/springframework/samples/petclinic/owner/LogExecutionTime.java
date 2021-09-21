package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 해당 애노테이션을 어디에 적용할 것인지 => 메소드에 적용할 것이다
@Retention(RetentionPolicy.RUNTIME) // 해당 애노테이션을 언제까지 유지할 것인지 => 런타임까지 유지
public @interface LogExecutionTime {
}
