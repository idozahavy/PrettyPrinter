package prettyprinter.tests.printer;

import java.lang.reflect.Modifier;

import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.convertors.ObjectViConvertor;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;
import com.github.idozahavy.prettyprinter.printers.ViPrinter;
import com.github.idozahavy.prettyprinter.printers.ViPrinterConfig;
import com.github.idozahavy.prettyprinter.printers.ViStringPrinter;

import prettyprinter.tests.beans.TestClass;
import prettyprinter.tests.beans.TestClass2;

public class ClassTest {

	public static void main(String[] args) {
		ViPrinterConfig printerConfig = new ViPrinterConfig();
		printerConfig.setItemSeperatorString(" | ");
		printerConfig.setLeftString("* ");
		printerConfig.setRightString(" *");
		ViPrinter printer = new ViStringPrinter(printerConfig); 
		
		TestClass cl1 = new TestClass("abc", 3.65, new int[] {4,2,6});
		TestClass2 cl2 = new TestClass2(cl1,5);
		
		ViConvertorConfig convertorConfig = new ViConvertorConfig();
		convertorConfig.addModifier(Modifier.PRIVATE);
		ViObject prettyCl1 = ObjectViConvertor.convert(cl1, convertorConfig);
		convertorConfig.resetConverted();
		ViObject prettyCl2 = ObjectViConvertor.convert(cl2, convertorConfig);
		
		printer.println(prettyCl1);
		System.out.println();
		printer.println(prettyCl2);

	}

}
