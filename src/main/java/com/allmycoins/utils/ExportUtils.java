package com.allmycoins.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import com.allmycoins.datatype.Balance;

public class ExportUtils {

	/* Delimiters that must be in the CSV fileWriter. */
	private static final String CSV_DELIMITER = ",";
	private static final String CSV_SEPARATOR = "\n";

	/* CSV fileWriter header. */
	private static final String CSV_HEADER = "Coin,Amount,Value";

	/**
	 * Constructor.
	 */
	private ExportUtils() {
		/* Empty. */
	}

	public static final void exportCsv(final List<Balance> balances) {
		try {
			File exportFile = new File("Export.csv");

			exportFile.delete();

			FileWriter fileWriter = new FileWriter(exportFile);

			/* Add header. */
			fileWriter.append(CSV_HEADER);
			/* Add a new line after the header. */
			fileWriter.append(CSV_SEPARATOR);
			/* Iterate through the balances. */
			Iterator it = balances.iterator();
			while (it.hasNext()) {
				Balance b = (Balance) it.next();
				fileWriter.append(b.getAsset());
				fileWriter.append(CSV_DELIMITER);
				fileWriter.append(String.valueOf(b.getQuantity()));
				fileWriter.append(CSV_DELIMITER);
				fileWriter.append(String.valueOf(b.getCurrencyValue()));
				fileWriter.append(CSV_SEPARATOR);
			}

			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
