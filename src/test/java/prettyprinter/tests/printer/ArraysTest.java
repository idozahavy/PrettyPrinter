package prettyprinter.tests.printer;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.ObjectPrettyConvertor;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.printers.PrettyPrinter;
import com.github.idozahavy.prettyprinter.printers.PrettyPrinterConfig;
import com.github.idozahavy.prettyprinter.printers.PrettyStringPrinter;

public class ArraysTest {

	public static void main(String[] args) {
		PrettyPrinterConfig printerConfig = new PrettyPrinterConfig();
		printerConfig.setItemSeperatorString(", ");
		printerConfig.setLeftString("[");
		printerConfig.setRightString("]");
		PrettyPrinter printer = new PrettyStringPrinter(printerConfig);

		PrettyConvertorConfig convertorConfig = new PrettyConvertorConfig();
		IPrettyString prettyStringInts = ObjectPrettyConvertor.convert(new int[] { 1, 3, 2, 6 }, convertorConfig);
		IPrettyString prettyStringStrings = ObjectPrettyConvertor.convert(new String[] { "ew", "Gfdsg", "5436tr" },
				convertorConfig);
		IPrettyString prettyStringBooleans = ObjectPrettyConvertor.convert(new boolean[] { false, true, true },
				convertorConfig);
		IPrettyString prettyStringIntegers = ObjectPrettyConvertor.convert(new Integer[] { 1, 3, 2, 6 },
				convertorConfig);

		printer.println(prettyStringInts);
		printer.println(prettyStringStrings);
		printer.println(prettyStringBooleans);
		printer.println(prettyStringIntegers);

	}

}
