package com.github.idozahavy.prettyprinter.core;

import com.github.idozahavy.prettyprinter.convertors.PrettyConvertor;
import com.github.idozahavy.prettyprinter.config.PrettyAccessor;
import com.github.idozahavy.prettyprinter.config.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;
import com.github.idozahavy.prettyprinter.beans.PrettyString;

public class Pretty {

	public static void println(Object object) {
		PrettyConvertor convertor = new PrettyConvertor(PrettyConvertorConfig.defaultConfig); 
		PrettyPrinter printer = new PrettyPrinter(PrettyPrinterConfig.defaultConfig); 
		printer.println(convertor.convert(object));
	}
	
	public static void printlnPrivates(Object object) {
		PrettyConvertor convertor = new PrettyConvertor(new PrettyConvertorConfig(PrettyAccessor.Private, false, false)); 
		PrettyPrinter printer = new PrettyPrinter(PrettyPrinterConfig.defaultConfig); 
		printer.println(convertor.convert(object));
	}
	
	public static void println(Object object, PrettyAccessor accessor) {
		PrettyConvertor convertor = new PrettyConvertor(new PrettyConvertorConfig(accessor)); 
		PrettyPrinter printer = new PrettyPrinter(PrettyPrinterConfig.defaultConfig); 
		printer.println(convertor.convert(object));
	}
	
	public static void println(Object object, PrettyConvertorConfig convertorConfig) {
		PrettyConvertor convertor = new PrettyConvertor(convertorConfig);
		PrettyPrinter printer = new PrettyPrinter(PrettyPrinterConfig.defaultConfig); 
		printer.println(convertor.convert(object));
	}
	
	public static void println(PrettyString prettyString) {
		PrettyPrinter printer = new PrettyPrinter(PrettyPrinterConfig.defaultConfig); 
		printer.println(prettyString);
	}
	
	public static void println(String string) {
		System.out.println(string);
	}
	
}
