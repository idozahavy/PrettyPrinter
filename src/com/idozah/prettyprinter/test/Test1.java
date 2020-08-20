package com.idozah.prettyprinter.test;

import java.util.ArrayList;
import java.util.List;

import com.idozah.prettyprinter.config.PrettyAccessor;
import com.idozah.prettyprinter.config.PrettyConfig;
import com.idozah.prettyprinter.core.PrettyPrint;

class Test1 {

	public static void main(String[] args) {
		PrettyPrint.println(new int[] { 123, 546, 812, 64 });
		PrettyPrint.println(new Object[] { "123", new TestClass("a", 2, true, 3.2), 812, 64 });
		PrettyPrint.println(new TestClass("abc", 32, true, 6.5));

		PrettyPrint.println(new TestClass2(new TestClass("str", 1, false, 42.42), 50));

		PrettyPrint.println(new TestClass3(4, new TestClass2(new TestClass("blop", 123, false, 444.11), 5)),
				PrettyAccessor.Private);
		PrettyPrint.println(new TestClass3(4, new TestClass2(new TestClass("blop", 123, false, 444.11), 5)));

		List<Integer> ls = new ArrayList<Integer>();
		ls.add(5);
		ls.add(5);
		ls.add(5);
		ls.add(5);
		ls.add(5);

		PrettyPrint.println(ls);
		PrettyPrint.println(ls, new PrettyConfig('-', " | ", 'v', '^', " <", "> "));
	}

}
