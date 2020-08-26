package prettyprinter;

import com.github.idozahavy.prettyprinter.core.Pretty;

public class recursivePointerClass1 {
	public recursivePointerClass2 recursive;
	
	public static void main(String[] args) {
		recursivePointerClass1 r1 = new recursivePointerClass1();
		recursivePointerClass2 r2 = new recursivePointerClass2();
		
		r1.recursive = r2;
		r2.recursive = r1;
		
		Pretty.println(r1);
	}
}
