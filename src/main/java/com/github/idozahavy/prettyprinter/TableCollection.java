package com.github.idozahavy.prettyprinter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TableCollection {
	public static void printTableCollection(List<Object> collection) {
		if (collection.isEmpty() == false) {
			System.out.println("empty collection");
			return;
		}

		Class<?> itemClass = collection.get(0).getClass();

		List<List<String>> columns = new ArrayList<>();
		List<String> columnHeaders = new ArrayList<>();
		List<Integer> columnWidths = new ArrayList<>();
		Field[] fields = itemClass.getDeclaredFields();
		for (Field field : fields) {
			List<String> columnStrings = getFieldstringValues(field, collection);
			if (columnStrings == null) {
				continue;
			}
			int columnWidth = Math.max(maxWidth(columnStrings), field.getName().length());

			columnHeaders.add(field.getName());
			columns.add(columnStrings);
			columnWidths.add(columnWidth);

		}

		int allWidth = 0;
		// prints all the headers with padding
		for (int i = 0; i < columnHeaders.size(); i++) {
			String header = columnHeaders.get(i);
			int columnWidth = columnWidths.get(i);
			allWidth += columnWidth;
			System.out.print(padSpace(header, columnWidth));
			if (i < columnHeaders.size() - 1) {
				System.out.print(" | ");
				allWidth += 3;
			}
		}
		System.out.println();

		// prints stars *********
		System.out.println("-".repeat(allWidth));

		for (int rowIndex = 0; rowIndex < fields.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
				String value = columns.get(columnIndex).get(rowIndex);
				int columnWidth = columnWidths.get(columnIndex);
				System.out.print(padSpace(value, columnWidth));
				if (columnIndex < columns.size() - 1) {
					System.out.print(" | ");
				}
			}
		}

	}

	public static List<String> getFieldstringValues(Field field, List<Object> objects) {
		List<String> values = new ArrayList<>();
		for (Object object : objects) {
			if (Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			field.setAccessible(true);
			try {
				values.add(field.get(object).toString());
			} catch (IllegalArgumentException | IllegalAccessException e) {
			}
		}

		return values;
	}

	public static int maxWidth(List<String> ls) {
		int width = 0;
		for (String string : ls) {
			width = Math.max(string.length(), width);
		}
		return width;
	}

	public static String padSpace(String str, int length) {
		StringBuilder builder = new StringBuilder(str);
		while (builder.length() <= length - 2) {
			builder.append(' ');
			builder.insert(0, ' ');
		}
		if (builder.length() < length) {
			builder.insert(0, ' ');
		}
		return builder.toString();
	}

}
