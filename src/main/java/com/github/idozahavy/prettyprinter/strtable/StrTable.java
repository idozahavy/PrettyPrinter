package com.github.idozahavy.prettyprinter.strtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import com.github.idozahavy.prettyprinter.utils.ViStringUtils;

import lombok.Data;

@Data
public class StrTable {

	List<List<String>> rows = new LinkedList<>();

	public int getColumnCount() {
		try {
			return this.rows.stream().max((a, b) -> a.size() - b.size()).get().size();
		} catch (NoSuchElementException e) {
			return 0;
		}

	}

	public int getRowCount() {
		return this.rows.size();
	}

	public int getStrWidth() {
		List<Integer> widths = new ArrayList<>();
		for (List<String> row : this.rows) {
			while (widths.size() < row.size()) {
				widths.add(0);
			}
			for (int i = 0; i < row.size(); i++) {
				widths.set(i, Math.max(row.get(i).length(), widths.get(i)));
			}
		}
		return this.rows.stream()
				.flatMapToInt((ls) -> IntStream.builder().add(ls.stream()
						.flatMapToInt((str) -> IntStream.builder().add(str.length()).build()).max().getAsInt()).build())
				.sum();

//		return widths.stream().flatMapToInt((num) -> IntStream.builder().add(num).build()).sum();
	}

	public int getStrWidth(int columnIndex) {
		return this.rows.parallelStream()
				.flatMapToInt((ls) -> IntStream.builder().add(ls.get(columnIndex).length()).build()).max().getAsInt();
	}

	public void padVertical(int ver) {
		List<String> emptyRow = new ArrayList<>();
		int columnCount = this.getColumnCount();
		for (int i = 0; i < columnCount; i++) {
			emptyRow.add("");
		}
		while (rows.size() < ver - 1) {
			rows.add(0, new ArrayList<>(emptyRow));
			rows.add(new ArrayList<>(emptyRow));
		}
		if (rows.size() < ver) {
			rows.add(0, new ArrayList<>(emptyRow));
		}
	}

	public void padHorizontal(int hor) {
		for (List<String> row : rows) {
			while (row.size() < hor - 1) {
				row.add(0, "");
				row.add("");
			}
			if (row.size() < hor) {
				row.add(0, "");
			}
		}
	}

	public void appendHor(StrTable oLines) {
		this.padVertical(oLines.rows.size());
		int center = this.rows.size() / 2;
		int oCenter = oLines.rows.size() / 2;
		int offset = center - oCenter;
		int rowCount = this.getRowCount();
		int addColCount = oLines.getColumnCount();

		for (int i = 0; i < rowCount; i++) {
			List<String> row = this.rows.get(i + offset);
			if (i >= offset && i < oLines.rows.size() + offset) {
				for (int j = 0; j < addColCount; j++) {
					row.add(oLines.rows.get(i - offset).get(j));
				}
			} else {
				for (int j = 0; j < addColCount; j++) {
					row.add("");
				}
			}
		}
	}

	public void appendHor(String str) {
		this.padVertical(1);
		int center = this.rows.size() / 2;
		int offset = center;
		int rowCount = this.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			List<String> row = this.rows.get(i + offset);
			if (i == offset) {
				row.add(str);
			} else {
				row.add("");
			}
		}
	}

	public void insertHor(StrTable oLines, int columnIndex) {
		this.padVertical(oLines.rows.size());
		int center = this.rows.size() / 2;
		int oCenter = oLines.rows.size() / 2;
		int offset = center - oCenter;
		int rowCount = this.getRowCount();
		int addColCount = oLines.getColumnCount();

		for (int i = 0; i < rowCount; i++) {
			List<String> row = this.rows.get(i + offset);
			if (i >= offset && i < oLines.rows.size() + offset) {
				for (int j = addColCount - 1; j >= 0; j--) {
					row.add(columnIndex, oLines.rows.get(i - offset).get(j));
				}
			} else {
				for (int j = 0; j < addColCount; j++) {
					row.add(columnIndex, "");
				}
			}
		}
	}

	public void appendVer(String str) {
		this.padHorizontal(1);
		int columnCount = this.getColumnCount();
		List<String> row = new LinkedList<>();
		row.add(str);
		while (row.size() < columnCount - 1) {
			row.add(0, "");
			row.add("");
		}
		if (row.size() < columnCount) {
			row.add(0, "");
		}
		this.rows.add(row);
	}

	public void appendVer(StrTable oLines) {
		this.padHorizontal(oLines.getColumnCount());
		int columnCount = Math.max(this.getColumnCount(), oLines.getColumnCount());

		for (int i = 0; i < oLines.getRowCount(); i++) {
			List<String> row = new LinkedList<>(oLines.rows.get(i));
			while (row.size() < columnCount - 1) {
				row.add(0, "");
				row.add("");
			}
			if (row.size() < columnCount) {
				row.add(0, "");
			}
			this.rows.add(row);
		}
	}

	public void insertVer(StrTable oLines, int rowIndex) {
		this.padHorizontal(oLines.getColumnCount());
		int columnCount = Math.max(this.getColumnCount(), oLines.getColumnCount());

		for (int i = oLines.getRowCount() - 1; i >= 0; i--) {
			List<String> row = new LinkedList<>(oLines.rows.get(i));
			while (row.size() < columnCount - 1) {
				row.add(0, "");
				row.add("");
			}
			if (row.size() < columnCount) {
				row.add(0, "");
			}
			this.rows.add(rowIndex, row);
		}
	}

	public void border(BorderConfig config) {
		if (config.getLeftStr() != null) {
			this.insertHor(this.getLRBorder(config.getLeftStr()), 0);
		}
		if (config.getRightStr() != null) {
			this.appendHor(this.getLRBorder(config.getRightStr()));
		}

		if (config.getTopChar() != null) {
			this.insertVer(this.getTBBorder(config.getTopChar()), 0);
		}
		if (config.getBottomChar() != null) {
			this.appendVer(this.getTBBorder(config.getBottomChar()));
		}
	}

	public StrTable getLRBorder(String str) {
		StrTable table = new StrTable();
		for (int i = 0; i < this.getRowCount(); i++) {
			table.appendVer(str);
		}
		return table;
	}

	public StrTable getTBBorder(String str) {
		StrTable table = new StrTable();
		for (int i = 0; i < this.getColumnCount(); i++) {
			table.appendHor(str.repeat(this.getStrWidth(i)));
		}
		return table;
	}

	@Override
	public String toString() {

		List<Integer> widths = new ArrayList<>();
		for (List<String> row : this.rows) {
			while (widths.size() < row.size()) {
				widths.add(0);
			}
			for (int i = 0; i < row.size(); i++) {
				widths.set(i, Math.max(row.get(i).length(), widths.get(i)));
			}
		}

		StringBuilder builder = new StringBuilder();

		for (List<String> row : this.rows) {
			for (int i = 0; i < row.size(); i++) {
				builder.append(ViStringUtils.padCenter(row.get(i), widths.get(i), ' '));
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}

}
