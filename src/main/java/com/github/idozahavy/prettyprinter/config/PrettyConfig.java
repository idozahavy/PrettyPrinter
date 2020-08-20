package com.github.idozahavy.prettyprinter.config;

public class PrettyConfig {
	private char rowSepChar;
	private String itemSepStr;
	private char topEdgeChar;
	private char bottomEdgeChar;
	private String rightEdgeStr;
	private String leftEdgeStr;

	public PrettyConfig(char rowSepChar, String itemSepStr, char topEdgeChar, char bottomEdgeChar, String rightEdgeStr,
			String leftEdgeStr) {
		this.rowSepChar = rowSepChar;
		this.itemSepStr = itemSepStr;
		this.topEdgeChar = topEdgeChar;
		this.bottomEdgeChar = bottomEdgeChar;
		this.rightEdgeStr = rightEdgeStr;
		this.leftEdgeStr = leftEdgeStr;
	}

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
