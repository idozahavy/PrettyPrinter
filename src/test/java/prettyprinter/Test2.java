package prettyprinter;

import com.github.idozahavy.prettyprinter.core.PrettyPrint;

public class Test2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		PrettyPrint.println(TestEnum1.a);
		TestEnum1 en = TestEnum1.c;
		PrettyPrint.println(en);
		PrettyPrint.println(new Integer(4));
	}
}
