package prettyprinter.tests.stringcollection;

import com.github.idozahavy.prettyprinter.beans.OneStringCollection;
import com.github.idozahavy.prettyprinter.beans.SimpleString;
import com.github.idozahavy.prettyprinter.beans.StringCollection;
import com.github.idozahavy.prettyprinter.beans.StringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.StringVerticalCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringCollection;

public class Test1 {

	public static void main(String[] args) {
//		***vert1*************************
//		*  vert1first  ,                *
//		*  vert1second ,                *
//		*  vert1third  ,                *
//		* ***hori1********************  *
//		* * hori1first , hori1second *  *
//		* ****************************  *
//		*********************************

		StringHorizontalCollection hori1 = new StringHorizontalCollection("hori1");
		hori1.add(new SimpleString("heri1first"));
		hori1.add(new SimpleString("heri1second"));

		StringVerticalCollection vert1 = new StringVerticalCollection("vert1");
		vert1.add(new SimpleString("vert1first"));
		vert1.add(new SimpleString("vert1second"));
		vert1.add(new SimpleString("vert1third"));
		vert1.add(hori1);

		IStringCollection coll0 = vert1.getColumn(0);
		IStringCollection coll1 = vert1.getColumn(1);

		System.out.println("***vert1*************************\r\n" + 
				"*  vert1first  ,                *\r\n" + 
				"*  vert1second ,                *\r\n" + 
				"*  vert1third  ,                *\r\n" + 
				"* ***hori1********************  *\r\n" + 
				"* * hori1first , hori1second *  *\r\n" + 
				"* ****************************  *\r\n" + 
				"*********************************");
		System.out.println();
		System.out.println("coll0");
		printPrettyString(coll0);
		System.out.println("********************************");
		System.out.println("coll1");
		printPrettyString(coll1);
	}

	private static void printPrettyString(IPrettyString prtStr) {
		if (prtStr instanceof StringCollection) {
			StringCollection collection = (StringCollection) prtStr;
			System.out.println("-----" + collection.getObject().toString() + "-----");
			for (IPrettyString prettyString : collection) {
				if (prettyString instanceof OneStringCollection) {
					System.out.println(((OneStringCollection) prettyString).getFirst().getValue());
				} else if (prettyString instanceof StringCollection) {
					printPrettyString((StringCollection) prettyString);
				} else if (prettyString instanceof SimpleString) {
					System.out.println(((SimpleString) prettyString).getValue());
				}
			}
		} else {
			if (prtStr instanceof SimpleString) {
				System.out.println(((SimpleString) prtStr).getValue());
			} else {
				System.out.println("Wierd");
			}
		}
	}

}
