package prettyprinter.tests.printer;

import java.lang.reflect.Modifier;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.ObjectPrettyConvertor;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.printers.PrettyPrinter;
import com.github.idozahavy.prettyprinter.printers.PrettyPrinterConfig;
import com.github.idozahavy.prettyprinter.printers.PrettyStringPrinter;

import prettyprinter.tests.beans.TestClass;
import prettyprinter.tests.beans.TestClass2;

public class ClassTest {

	public static void main(String[] args) {
		PrettyPrinterConfig printerConfig = new PrettyPrinterConfig();
		printerConfig.setItemSeperatorString(" | ");
		printerConfig.setLeftString("* ");
		printerConfig.setRightString(" *");
		PrettyPrinter printer = new PrettyStringPrinter(printerConfig); 
		
		TestClass cl1 = new TestClass("abc", 3.65, new int[] {4,2,6});
		TestClass2 cl2 = new TestClass2(cl1,5);
		
		PrettyConvertorConfig convertorConfig = new PrettyConvertorConfig();
		convertorConfig.addModifier(Modifier.PRIVATE);
		IPrettyString prettyCl1 = ObjectPrettyConvertor.convert(cl1, convertorConfig);
		convertorConfig.resetConverted();
		IPrettyString prettyCl2 = ObjectPrettyConvertor.convert(cl2, convertorConfig);
		
		printer.println(prettyCl1);
		System.out.println();
		printer.println(prettyCl2);

	}

}
