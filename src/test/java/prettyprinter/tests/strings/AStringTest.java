package prettyprinter.tests.strings;

import com.github.idozahavy.prettyprinter.core.Pretty;

import prettyprinter.tests.beans.TestEnum1;

public class AStringTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		System.out.println("int test");
		Pretty.println(4);
		
		System.out.println("string test");
		Pretty.println("af");
		
		System.out.println("boolean test");
		Pretty.println(false);
		
		System.out.println("enum test");
		Pretty.println(TestEnum1.b);
		
		System.out.println("double test");
		Pretty.println(5.94);
		
		System.out.println("Integer test");
		Pretty.println(new Integer(5));
	}
}
