package com.github.idozahavy.prettyprinter.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrettyValue {
	public String value();
	//TODO Check implementation on value either class name or field value
}
