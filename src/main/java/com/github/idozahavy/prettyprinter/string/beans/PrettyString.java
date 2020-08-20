package com.github.idozahavy.prettyprinter.string.beans;

import com.github.idozahavy.prettyprinter.config.PrettyConfig;

public abstract class PrettyString {

	@Override
	public String toString() {
		return this.toString(new PrettyConfig('-', " | ", '*', '*', " *", "* "));
	}

	public abstract String toString(PrettyConfig config);

	public abstract int getWidth(PrettyConfig config);

	public abstract int getRowCount(PrettyConfig config);

	public abstract String getRowLine(int row, int line, PrettyConfig config);

	public abstract int getRowHeight(int row, PrettyConfig config);

	public abstract String getRowSeperator(int row, PrettyConfig config);
}
