package com.prettyprinter.string.beans;

import com.prettyprinter.config.PrettyConfig;

public class PrettyFieldString extends PrettyString {
	private String header;
	private PrettyString value;

	public PrettyFieldString(String header, PrettyString value) {
		this.header = header;
		this.value = value;
	}

	public String getHeader() {
		return header;
	}

	public PrettyString getValue() {
		return value;
	}

	@Override
	public int getWidth(PrettyConfig config) {
		return Math.max(header.length(), value.getWidth(config));
	}

	@Override
	public int getRowCount(PrettyConfig config) {
		return 1 + value.getRowCount(config);
	}

	@Override
	public String toString(PrettyConfig config) {
		throw new UnsupportedOperationException("No toString method implementation for PrettyFieldString object");
	}

	@Override
	public int getRowHeight(int row, PrettyConfig config) {
		if (row == 0) {
			return 1;
		}
		return value.getRowHeight(row - 1, config);
	}

	@Override
	public String getRowLine(int row, int line, PrettyConfig config) {
		if (row == 0) {
			return line == 0 ? header : "";
		}
		return value.getRowLine(row - 1, line, config);
	}

	@Override
	public String getRowSeperator(int row, PrettyConfig config) {
		if (row == 0) {
			return config.getRowSep().repeat(getWidth(config));
		}
		return value.getRowSeperator(row - 1, config);
	}

}
