package prettyprinter.tests.printer;

import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.convertors.ObjectViConvertor;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;
import com.github.idozahavy.prettyprinter.printers.ViPrinter;
import com.github.idozahavy.prettyprinter.printers.ViPrinterConfig;
import com.github.idozahavy.prettyprinter.printers.ViStringPrinter;

public class ArraysTest {

	public static void main(String[] args) {
		ViPrinterConfig printerConfig = new ViPrinterConfig();
		printerConfig.setItemSeperatorString(", ");
		printerConfig.setLeftString("[");
		printerConfig.setRightString("]");
		ViPrinter printer = new ViStringPrinter(printerConfig);

		ViConvertorConfig convertorConfig = new ViConvertorConfig();
		ViObject prettyStringInts = ObjectViConvertor.convert(new int[] { 1, 3, 2, 6 }, convertorConfig);
		ViObject prettyStringStrings = ObjectViConvertor.convert(new String[] { "ew", "Gfdsg", "5436tr" },
				convertorConfig);
		ViObject prettyStringBooleans = ObjectViConvertor.convert(new boolean[] { false, true, true },
				convertorConfig);
		ViObject prettyStringIntegers = ObjectViConvertor.convert(new Integer[] { 1, 3, 2, 6 },
				convertorConfig);

		printer.println(prettyStringInts);
		printer.println(prettyStringStrings);
		printer.println(prettyStringBooleans);
		printer.println(prettyStringIntegers);

	}

}
