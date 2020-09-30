package prettyprinter.tests.convertor.table;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.convertors.ObjectPrettyConvertor;
import com.github.idozahavy.prettyprinter.convertors.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.convertors.table.PrettyTableConvertor;
import com.github.idozahavy.prettyprinter.printers.PrettyPrinterConfig;
import com.github.idozahavy.prettyprinter.printers.PrettyStringPrinter;

import prettyprinter.tests.beans.TestClass;

public class Test1 {

	public static void main(String[] args) {
		List<TestClass> ls = new ArrayList<>();
		ls.add(new TestClass("ab", 1.1, new int[] {1,2,3}));
		ls.add(new TestClass("r45", 1.1, new int[] {4,3751516,546}));
		ls.add(new TestClass("aghvr", 5345.1, new int[] {6,2,1}));
		
		PrettyPrinterConfig printerConfig = new PrettyPrinterConfig();
		printerConfig.setItemSeperatorString(" ");
		PrettyStringPrinter printer = new PrettyStringPrinter(printerConfig);
		
		PrettyConvertorConfig convertorConfig = new PrettyConvertorConfig();
		convertorConfig.addModifier(Modifier.PRIVATE);
		IPrettyString prettyLs = ObjectPrettyConvertor.convert(ls, convertorConfig);
		
		PrettyTableConvertor tableConvertor = new PrettyTableConvertor();
		
		IPrettyString table = tableConvertor.convert(prettyLs);
		
		
		
//		printer.println(prettyLs);
		printer.println(table);
	}

}
