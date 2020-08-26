package com.github.idozahavy.prettyprinter.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

public class PrettyStringMap extends PrettyString {
	private List<PrettyString> rows;

	public PrettyStringMap() {
		rows = new ArrayList<>();
	}

	public PrettyStringMap(String str) {
		rows = new ArrayList<>();
		rows.add(new AString(str));
	}

	public PrettyStringMap(List<PrettyString> rows) {
		this.rows = rows;
	}

	public void add(PrettyString prettyString) {
		rows.add(prettyString);
	}

	public List<PrettyString> getRows() {
		return rows;
	}

	public static String middlePadSpace(String str, int length) {
		while (str.length() <= length - 2) {
			str = " " + str + " ";
		}
		if (str.length() < length) {
			str += " ";
		}
		return str;
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
			for (PrettyString prettyString : rows) {
				lineWidth += prettyString.getWidth(config) + config.getItemSep().length();
			}
			maxWidth = Math.max(maxWidth, lineWidth - config.getItemSep().length());
		}
		return maxWidth + config.getLeftEdge().length() + config.getRightEdge().length();
	}

	@Override
	public int getRowCount() {
		int rowCount = -1;
		for (PrettyString prettyString : rows) {
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
		for (PrettyString prettyString : rows) {
			String strAddition = prettyString.getRowLine(row, line, config);
			strAddition = middlePadSpace(strAddition, prettyString.getWidth(config));
			string += strAddition + config.getItemSep();
		}
		string = string.substring(0, string.length() - config.getItemSep().length());
		return config.getLeftEdge() + string + config.getRightEdge();
	}

	@Override
	public int getRowHeight(int row, PrettyPrinterConfig config) {
		int maxLineHeight = 0;
		for (PrettyString prettyString : rows) {
			maxLineHeight = Math.max(maxLineHeight, prettyString.getRowHeight(row, config));
		}
		maxLineHeight += ((row == 0) ? 1 : 0) + ((row == this.getRowCount() - 1) ? 1 : 0);
		return maxLineHeight;
	}

	@Override
	public String getRowSeperator(int row, PrettyPrinterConfig config) {
		if (config.isRowSeperatorAll() && row == 0) {
			return "" + config.getLeftEdge()
					+ config.getRowSep()
							.repeat(getWidth(config) - config.getLeftEdge().length() - config.getRightEdge().length())
					+ config.getRightEdge();
		}
		String string = "" + config.getLeftEdge();
		for (PrettyString prettyString : rows) {
			string += middlePadSpace(prettyString.getRowSeperator(row, config), prettyString.getWidth(config))
					+ config.getItemSep();
		}
		string = string.substring(0, string.length() - config.getItemSep().length());
		return string + config.getRightEdge();
	}

	@Override
	public Iterator<PrettyString> iterator() {
		return this.rows.iterator();
	}

}
