package com.github.idozahavy.prettyprinter.string.beans;

import java.util.Iterator;

import com.github.idozahavy.prettyprinter.config.PrettyConfig;

public abstract class PrettyString implements Iterable<PrettyString> {

	@Override
	public String toString() {
		return this.toString(PrettyConfig.defaultConfig);
	}

	public abstract String toString(PrettyConfig config);

	public abstract int getWidth(PrettyConfig config);

	public abstract int getRowCount();

	public abstract String getRowLine(int row, int line, PrettyConfig config);

	public abstract int getRowHeight(int row, PrettyConfig config);

	public abstract String getRowSeperator(int row, PrettyConfig config);
	
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
