package com.github.idozahavy.prettyprinter.core;

import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.beans.ViString;
import com.github.idozahavy.prettyprinter.convertors.ObjectViConvertor;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;
import com.github.idozahavy.prettyprinter.printers.ViPrinter;
import com.github.idozahavy.prettyprinter.printers.ViPrinterConfig;

//TODO make final implementation
public class Visual extends ViPrinter{

	public Visual(ViPrinterConfig config) {
		super(config);
		// TODO Auto-generated constructor stub
	}
//
//	public static void println(Object object) {
//		printer.println(ObjectViConvertor.convert(object, ViConvertorConfig.defaultConfig),
//				ViPrinterConfig.defaultConfig);
//	}
//
//	public static void println(Object object, ViConvertorConfig convertorConfig) {
//		printer.println(ObjectViConvertor.convert(object, convertorConfig), ViPrinterConfig.defaultConfig);
//	}
//
//	public static void println(ViString prettyString) {
//		printer.println(prettyString, ViPrinterConfig.defaultConfig);
//	}
//
//	public static void println(String string) {
//		System.out.println(string);
//	}

	@Override
	public void println(ViObject prettyString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printfln(ViObject prettyString, ViPrinterConfig config) {
		// TODO Auto-generated method stub
		
	}

}
