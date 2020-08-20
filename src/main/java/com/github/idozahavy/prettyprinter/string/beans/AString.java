package com.github.idozahavy.prettyprinter.string.beans;

import com.github.idozahavy.prettyprinter.config.PrettyConfig;

public class AString extends PrettyString {
	private String value;

	public AString(String value) {
		this.value = value;
	}

	@Override
	public int getWidth(PrettyConfig config) {
		return value.length();
	}

	@Override
	public int getRowCount(PrettyConfig config) {
		return 1;
	}

	@Override
	public String toString(PrettyConfig config) {
		return value;
	}

	@Override
	public int getRowHeight(int row, PrettyConfig config) {
		return row == 0 ? 1 : 0;
	}

	@Override
	public String getRowLine(int row, int line, PrettyConfig config) {
		return (row == 0 && line == 0) ? value : "";
	}

	@Override
	public String getRowSeperator(int row, PrettyConfig config) {
		if (row == 0) {
			return String.valueOf(config.getRowSep()).repeat(getWidth(config));
		}
		return " ".repeat(getRowCount(config));
	}

}
