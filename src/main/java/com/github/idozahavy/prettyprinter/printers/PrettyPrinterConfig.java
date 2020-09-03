package com.github.idozahavy.prettyprinter.printers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrettyPrinterConfig {

	public PrettyPrinterConfig() {
		topChar = ' ';
		bottomChar = ' ';
		leftString = "";
		rightString = "";
		itemSeperatorString = " ";
	}

	private char topChar;
	private char bottomChar;
	private String leftString;
	private String rightString;
	private String itemSeperatorString;

}
