package com.github.idozahavy.prettyprinter.beans;

import java.util.Iterator;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

public abstract class PrettyString implements Iterable<PrettyString> {

	@Override
	public String toString() {
		return this.toString(PrettyPrinterConfig.defaultConfig);
	}

	public abstract String toString(PrettyPrinterConfig config);

	public abstract int getWidth(PrettyPrinterConfig config);

	public abstract int getRowCount();

	public abstract String getRowLine(int row, int line, PrettyPrinterConfig config);

	public abstract int getRowHeight(int row, PrettyPrinterConfig config);

	public abstract String getRowSeperator(int row, PrettyPrinterConfig config);

	@Override
	public Iterator<PrettyString> iterator() {
		PrettyString obj = this;
		return new Iterator<PrettyString>() {

			private boolean canNext = true;

			@Override
			public PrettyString next() {
				canNext = false;
				return obj;
			}

			@Override
			public boolean hasNext() {
				return canNext;
			}
		};
	}
}
