package com.github.idozahavy.prettyprinter.beans;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

public class AString extends PrettyString {
	private String value;

	public AString(String value) {
		this.value = value;
	}

	@Override
	public int getWidth(PrettyPrinterConfig config) {
		return value.length();
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public String toString(PrettyPrinterConfig config) {
		return value;
	}

	@Override
	public int getRowHeight(int row, PrettyPrinterConfig config) {
		return row == 0 ? 1 : 0;
	}

	@Override
	public String getRowLine(int row, int line, PrettyPrinterConfig config) {
		return (row == 0 && line == 0) ? value : "";
	}

	@Override
	public String getRowSeperator(int row, PrettyPrinterConfig config) {
//		if (row == 0) {
//			return String.valueOf(config.getRowSep()).repeat(getWidth(config));
//		}
		return " ".repeat(getRowCount());
	}
}
