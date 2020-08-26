package com.github.idozahavy.prettyprinter.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PrettyPrinterConfig {
	public static PrettyPrinterConfig defaultConfig = new PrettyPrinterConfig('-', " | ", '*', '*', " *", "* ", false);
	
	private char rowSepChar;
	private String itemSepStr;
	private char topEdgeChar;
	private char bottomEdgeChar;
	private String rightEdgeStr;
	private String leftEdgeStr;
	@Getter
	private boolean rowSeperatorAll;

	public String getRowSep() {
		return String.valueOf(rowSepChar);
	}

	public String getItemSep() {
		return itemSepStr;
	}

	public String getTopEdge() {
		return String.valueOf(topEdgeChar);
	}

	public String getBottomEdge() {
		return String.valueOf(bottomEdgeChar);
	}

	public String getRightEdge() {
		return rightEdgeStr;
	}

	public String getLeftEdge() {
		return leftEdgeStr;
	}
	

}
