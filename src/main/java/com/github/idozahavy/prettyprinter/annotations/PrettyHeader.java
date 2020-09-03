package com.github.idozahavy.prettyprinter.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrettyHeader {
	public String value();
	//TODO Check implementation needs to be in class name
}
