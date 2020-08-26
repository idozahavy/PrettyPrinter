package com.github.idozahavy.prettyprinter.beans;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

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
	public int getWidth(PrettyPrinterConfig config) {
		return Math.max(header.length(), value.getWidth(config));
	}

	@Override
	public int getRowCount() {
		return 1 + value.getRowCount();
	}

	@Override
	public String toString(PrettyPrinterConfig config) {
		return header + "\r\n" + value.toString(config);
	}

	@Override
	public int getRowHeight(int row, PrettyPrinterConfig config) {
		if (row == 0) {
			return 1;
		}
		return value.getRowHeight(row - 1, config);
	}

	@Override
	public String getRowLine(int row, int line, PrettyPrinterConfig config) {
		if (row == 0) {
			return line == 0 ? header : "";
		}
		return value.getRowLine(row - 1, line, config);
	}

	@Override
	public String getRowSeperator(int row, PrettyPrinterConfig config) {
		if (row == 0) {
			return config.getRowSep().repeat(getWidth(config));
		}
		return value.getRowSeperator(row - 1, config);
	}

}
