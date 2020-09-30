package prettyprinter.tests;

import com.github.idozahavy.prettyprinter.core.Pretty;
import prettyprinter.*;

public class Test1 {
	public static void main(String[] args) {

		TestClass3 tc3 = new TestClass3(4,new TestClass2(new TestClass("asdf", 25, true, 2.543), 366));

		Pretty.printlnPrivates(tc3);
	}
}
