package com.github.idozahavy.prettyprinter.core;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;
import com.github.idozahavy.prettyprinter.beans.PrettyString;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrettyPrinter {
	private PrettyPrinterConfig printerConfig; 
	
	public void println(PrettyString prettyString) {
		println(prettyString, printerConfig);
	}

	public static void println(PrettyString prettyString, PrettyPrinterConfig printerConfig) {
		System.out.println(prettyString.toString(printerConfig));
	}
}
