package prettyprinter.tests;

import java.util.ArrayList;
import java.util.List;

import com.github.idozahavy.prettyprinter.convertors.PrettyConvertor;
import com.github.idozahavy.prettyprinter.core.Pretty;
import com.github.idozahavy.prettyprinter.core.PrettyPrinter;

import prettyprinter.tests.beans.TestClass;
import prettyprinter.tests.beans.TestClass2;
import prettyprinter.tests.beans.TestClass3;

import com.github.idozahavy.prettyprinter.config.PrettyAccessor;
import com.github.idozahavy.prettyprinter.config.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;

class Test1 {

	public static void main(String[] args) {
		Pretty.println(new int[] { 123, 546, 812, 64 });
		Pretty.println(new Object[] { "123", new TestClass("a", 2, true, 3.2), 812, 64 });
		Pretty.println(new TestClass("abc", 32, true, 6.5));

		Pretty.println(new TestClass2(new TestClass("str", 1, false, 42.42), 50));

		PrettyConvertor privateConvertor = new PrettyConvertor(new PrettyConvertorConfig(PrettyAccessor.Private));
		Pretty.println(privateConvertor.convert(new TestClass3(4, new TestClass2(new TestClass("blop", 123, false, 444.11), 5))));
		Pretty.println(new TestClass3(4, new TestClass2(new TestClass("blop", 123, false, 444.11), 5)));

		List<Integer> ls = new ArrayList<Integer>();
		ls.add(5000);
		ls.add(5);
		ls.add(6);
		ls.add(5000);
		ls.add(5);

		Pretty.println(ls);
		PrettyPrinter printer = new PrettyPrinter(new PrettyPrinterConfig('-', " | ", 'v', '^', " <", "> ", true));
		printer.println(PrettyConvertor.convert(ls,PrettyConvertorConfig.defaultConfig));
	}

}
