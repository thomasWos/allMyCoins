package com.allmycoins.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TableConsole {

	private final ArrayList<List<String>> table;

	public TableConsole(List<String> header) {
		table = new ArrayList<>();
		table.add(header);
	}

	public void addRow(List<String> row) {
		table.add(row);
	}

	@Override
	public String toString() {

		List<Integer> columnLengthList = new ArrayList<>();

		List<String> headers = table.get(0);
		for (int i = 0; i < headers.size(); i++) {
			final int index = i;
			Integer maxColumnLength = table.stream().map(row -> row.get(index).length()).max(Integer::compare)
					.orElseGet(() -> 0);
			columnLengthList.add(maxColumnLength);
		}

		List<String> formatList = new ArrayList<>();
		for (int i = 0; i < columnLengthList.size(); i++) {
			Integer columnLength = columnLengthList.get(i);
			String format = "%" + (i + 1) + "$" + columnLength + "s";
			formatList.add(format);
		}

		String format = formatList.stream().collect(Collectors.joining(" | "));
		StringBuilder strBuilder = new StringBuilder(System.lineSeparator());
		for (int i = 0; i < table.size(); i++) {
			List<String> row = table.get(i);
			Object[] items = row.toArray(new String[row.size()]);
			String formatedRow = String.format(format, items);
			if (i == 1) {
				strBuilder.append("-".repeat(formatedRow.length())).append(System.lineSeparator());
			}

			strBuilder.append(formatedRow).append(System.lineSeparator());
		}
		return strBuilder.toString();
	}
}
