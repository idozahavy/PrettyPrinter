package com.github.idozahavy.prettyprinter.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

public class PrettyStringMap extends PrettyString {
	private List<PrettyString> columns;

	public PrettyStringMap() {
		columns = new ArrayList<>();
	}

	public PrettyStringMap(String str) {
		columns = new ArrayList<>();
		columns.add(new AString(str));
	}

	public PrettyStringMap(List<PrettyString> rows) {
		this.columns = rows;
	}

	public void add(PrettyString prettyString) {
		columns.add(prettyString);
	}

	public List<PrettyString> getRows() {
		return columns;
	}

	@Override
	public String toString(PrettyPrinterConfig config) {
		int rowCount = this.getRowCount();
		String string = "";
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			int rowHeight = this.getRowHeight(rowIndex, config);
			for (int i = 0; i < rowHeight; i++) {
				string += this.getRowLine(rowIndex, i, config) + "\r\n";
			}
			if (rowIndex < rowCount - 1) {
				string += getRowSeperator(rowIndex, config) + "\r\n";
			}
		}
		if (string.equalsIgnoreCase("") == false) {
			string = string.substring(0, string.length() - 2);
		}
		return string;
	}

	@Override
	public int getWidth(PrettyPrinterConfig config) {
		int maxWidth = -1;
		for (int i = 0; i < this.getRowCount(); i++) {
			int lineWidth = 0;
			for (PrettyString prettyString : columns) {
				lineWidth += prettyString.getWidth(config) + config.getItemSep().length();
			}
			maxWidth = Math.max(maxWidth, lineWidth - config.getItemSep().length());
		}
		return maxWidth + config.getLeftEdge().length() + config.getRightEdge().length();
	}

	@Override
	public int getRowCount() {
		int rowCount = -1;
		for (PrettyString prettyString : columns) {
			rowCount = Math.max(rowCount, prettyString.getRowCount());
		}
		return rowCount;
	}

	@Override
	public String getRowLine(int row, int line, PrettyPrinterConfig config) {
		// last row last line bottom edge string
		if (row == this.getRowCount() - 1) {
			if (line == this.getRowHeight(row, config) - 1) {
				return config.getBottomEdge().repeat(this.getWidth(config));

			}
		}
		// first row first line top edge string
		if (row == 0) {
			if (line == 0) {
				return config.getTopEdge().repeat(this.getWidth(config));
			}
			line -= 1;
		}
		String string = "";
		for (PrettyString prettyString : columns) {
			String strAddition = prettyString.getRowLine(row, line, config);
			strAddition = middlePadSpace(strAddition, prettyString.getWidth(config));
			string += strAddition + config.getItemSep();
		}
		string = string.substring(0, string.length() - config.getItemSep().length());
		return config.getLeftEdge() + string + config.getRightEdge();
	}

	@Override
	public int getRowHeight(int row, PrettyPrinterConfig config) {
		int rowHeight = 0;
		for (PrettyString prettyString : columns) {
			rowHeight = Math.max(rowHeight, prettyString.getRowHeight(row, config));
		}
		rowHeight += ((row == 0) ? 1 : 0) + ((row == this.getRowCount() - 1) ? 1 : 0);
		return rowHeight;
	}

	@Override
	public String getRowSeperator(int row, PrettyPrinterConfig config) {
		if (config.isRowSeperatorAll() && row == 0) {
			return config.getLeftEdge()
					+ config.getRowSep()
							.repeat(getWidth(config) - config.getLeftEdge().length() - config.getRightEdge().length())
					+ config.getRightEdge();
		}
		String string = config.getLeftEdge();
		for (PrettyString prettyString : columns) {
			string += middlePadSpace(prettyString.getRowSeperator(row, config), prettyString.getWidth(config))
					+ config.getItemSep();
		}
		string = string.substring(0, string.length() - config.getItemSep().length());
		return string + config.getRightEdge();
	}

	@Override
	public Iterator<PrettyString> iterator() {
		return this.columns.iterator();
	}

}
