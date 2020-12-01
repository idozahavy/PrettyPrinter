package prettyprinter.tests.convertor.table;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.convertors.ObjectViConvertor;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;
import com.github.idozahavy.prettyprinter.printers.ViPrinterConfig;
import com.github.idozahavy.prettyprinter.printers.ViStringPrinter;
import com.github.idozahavy.prettyprinter.strtable.StrTableConvertor;

import prettyprinter.tests.beans.TestClass;

public class Test1 {

	public static void main(String[] args) {
		List<TestClass> ls = new ArrayList<>();
		ls.add(new TestClass("ab", 1.1, new int[] {1,2,3}));
		ls.add(new TestClass("r45", 1.1, new int[] {4,3751516,546}));
		ls.add(new TestClass("aghvr", 5345.1, new int[] {6,2,1}));
		
		ViPrinterConfig printerConfig = new ViPrinterConfig();
		printerConfig.setItemSeperatorString(" ");
		ViStringPrinter printer = new ViStringPrinter(printerConfig);
		
		ViConvertorConfig convertorConfig = new ViConvertorConfig();
		convertorConfig.addModifier(Modifier.PRIVATE);
		ViObject prettyLs = ObjectViConvertor.convert(ls, convertorConfig);
		
		
//		printer.println(prettyLs);
//		printer.println(table);
		
		System.out.println("***");
		System.out.println(StrTableConvertor.convert(prettyLs));
	}

}
