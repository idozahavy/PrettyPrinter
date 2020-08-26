package prettyprinter;

import com.github.idozahavy.prettyprinter.core.Pretty;

public class Test2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Pretty.println(TestEnum1.a);
		TestEnum1 en = TestEnum1.c;
		Pretty.println(en);
		Pretty.println(new Integer(4));
	}
}
