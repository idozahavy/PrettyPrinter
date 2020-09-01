package prettyprinter.tests;

import java.util.ArrayList;

import com.github.idozahavy.prettyprinter.config.PrettyAccessor;
import com.github.idozahavy.prettyprinter.config.PrettyConvertorConfig;
import com.github.idozahavy.prettyprinter.config.PrettyPrinterConfig;
import com.github.idozahavy.prettyprinter.core.Pretty;
import com.github.idozahavy.prettyprinter.core.PrettyPrinter;

import prettyprinter.tests.beans.TestClass;
import prettyprinter.tests.beans.TestClass2;
import prettyprinter.tests.beans.TestClass3;

public class Test2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//		Pretty.println(TestEnum1.a);
//		TestEnum1 en = TestEnum1.c;
//		Pretty.println(en);
//		Pretty.println(new Integer(4));
		
		TestClass tc1 = new TestClass("fdd", 354, true, 5.1667);
		TestClass2 tc2 = new TestClass2(tc1, 9);
		TestClass3 tc3 = new TestClass3(5, tc2);
		PrettyPrinterConfig.defaultConfig = new PrettyPrinterConfig('-', "|", '^', 'v', ">", "<", false);
		Pretty.println(tc3, PrettyAccessor.Private);
		Pretty.println(tc3, new PrettyConvertorConfig(PrettyAccessor.Private, false, true));
	}
}
