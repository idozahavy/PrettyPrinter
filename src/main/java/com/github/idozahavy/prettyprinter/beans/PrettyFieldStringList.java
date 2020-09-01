package com.github.idozahavy.prettyprinter.beans;

import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrettyFieldStringList extends PrettyString {

	private String header;
	private List<PrettyString> items;

	public PrettyFieldStringList(String header) {
		this.header = header;
	}

	public void addString(PrettyString prettyString) {
		if (items == null) {
			items = new ArrayList<PrettyString>();
		}
		items.add(prettyString);
	}

	@Override
	public String toString(PrettyPrinterConfig config) {
		throw new RuntimeException("no toString to type PrettyFieldStringList");
	}

	@Override
	public int getWidth(PrettyPrinterConfig config) {
		int maxWidth = -1;
		for (PrettyString prettyString : items) {
			maxWidth = Math.max(maxWidth, prettyString.getWidth(config));
		}
		maxWidth = Math.max(header.length(), maxWidth);
		return maxWidth + config.getRightEdge().length() + config.getLeftEdge().length();
	}

	public int getInnerWidth(PrettyPrinterConfig config) {
		int maxWidth = -1;
		for (PrettyString prettyString : items) {
			maxWidth = Math.max(maxWidth, prettyString.getWidth(config));
		}
		maxWidth = Math.max(header.length(), maxWidth);
		return maxWidth;
	}

	@Override
	public int getRowCount() {
		int rowCount = 1;
		for (PrettyString prettyString : items) {
			rowCount += prettyString.getRowCount();
		}
		return rowCount;
	}

	public int getRowCountUntilItem(PrettyString item) {
		int rowCount = 1;
		for (int i=0;i<items.size();i++) {
			PrettyString prettyString = items.get(i);
			if (prettyString == item) {
				break;
			}
			rowCount += prettyString.getRowCount();
		}
		return rowCount;
	}

	@Override
	public String getRowLine(int row, int line, PrettyPrinterConfig config) {
		// first row first line top edge string
		if (row == 0) {
			if (line == 0) {
				return config.getTopEdge().repeat(this.getWidth(config));
			}
			if (line == 1) {
				return config.getLeftEdge() + header + config.getRightEdge();
			}
			line -= 2;
		}
		// last row last line bottom edge string
		if (row == this.getRowCount() - 1) {
			if (line == this.getRowHeight(row, config) - 1) {
				return config.getBottomEdge().repeat(this.getWidth(config));
			}
		}
		row--;
		PrettyString prettyString = getItemInRow(row);
		String string = prettyString.getRowLine(line, line, config);
		string = middlePadSpace(string, getInnerWidth(config)) + config.getItemSep();
		string = string.substring(0, string.length() - config.getItemSep().length());
		return config.getLeftEdge() + string + config.getRightEdge();
	}
	
	private PrettyString getItemInRow(int row) {
		int rowsPassed = 0;
		for (int i=0;i<items.size();i++) {
			int rowRowCount = items.get(i).getRowCount();		
			if (rowsPassed + rowRowCount > row) {
				return items.get(i);
			}
			rowsPassed += rowRowCount;
		}
		throw new RuntimeException("no row in type PrettyFieldStringList");
//		return null;
	}

	@Override
	public int getRowHeight(int row, PrettyPrinterConfig config) {
		if (row == 0) {
			return 2;
		}
		PrettyString prettyString = getItemInRow(row-1);
		int rowHeight = prettyString.getRowHeight(row-getRowCountUntilItem(prettyString), config);
		if (row == this.getRowCount() - 2)
			rowHeight += 1;
		return rowHeight;
	}

	@Override
	public String getRowSeperator(int row, PrettyPrinterConfig config) {
		int edgesLength = config.getLeftEdge().length() + config.getRightEdge().length();
		String sepString = config.getRowSep().repeat(getWidth(config) - edgesLength);
		return config.getLeftEdge() + sepString + config.getRightEdge();
	}
}
