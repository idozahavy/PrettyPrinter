package com.github.idozahavy.prettyprinter.printers;

public class PrettyPrinterUtils {

	public static String padCenter(String str, int length, char padChar) {
		StringBuilder builder = new StringBuilder(str);
		while (builder.length()<=length-2) {
			builder.insert(0, padChar);
			builder.append(padChar);
		}
		if (builder.length()<length) {
			builder.append(padChar);
		}
		return builder.toString();
	}
	
	public static String padRight(String str, int length, char padChar) {
		StringBuilder builder = new StringBuilder(str);
		while (builder.length()<length) {
			builder.append(padChar);
		}
		return builder.toString();
	}
	
	public static String repeat(char ch, int length) {
		return String.valueOf(ch).repeat(length);
	}
	
}
