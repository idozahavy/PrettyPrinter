package prettyprinter.tests.stringcollection;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViString;

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
	}
//		ViCollection hori1 = new ViCollection(null,"hori1");
//		hori1.push(new ViString("heri1first"));
//		hori1.push(new ViString("heri1second"));
//
//		ViCollection vert1 = new ViCollection(null,"vert1");
//		vert1.push(new ViString("vert1first"));
//		vert1.push(new ViString("vert1second"));
//		vert1.push(new ViString("vert1third"));
//		vert1.push(hori1);
//
//		ViCollection coll0 = vert1.getColumn(0);
//		ViCollection coll1 = vert1.getColumn(1);
//
//		System.out.println("***vert1*************************\r\n" + 
//				"*  vert1first  ,                *\r\n" + 
//				"*  vert1second ,                *\r\n" + 
//				"*  vert1third  ,                *\r\n" + 
//				"* ***hori1********************  *\r\n" + 
//				"* * hori1first , hori1second *  *\r\n" + 
//				"* ****************************  *\r\n" + 
//				"*********************************");
//		System.out.println();
//		System.out.println("coll0");
//		printPrettyString(coll0);
//		System.out.println("********************************");
//		System.out.println("coll1");
//		printPrettyString(coll1);
//	}
//
//	private static void printPrettyString(IPrettyString prtStr) {
//		if (prtStr instanceof ViCollection) {
//			ViCollection collection = (ViCollection) prtStr;
//			System.out.println("-----" + collection.getObject().toString() + "-----");
//			for (IPrettyString prettyString : collection) {
//				if (prettyString instanceof ViCollection) {
//					System.out.println(((ViCollection) prettyString).getFirst().getValue());
//				} else if (prettyString instanceof ViCollection) {
//					printPrettyString((ViCollection) prettyString);
//				} else if (prettyString instanceof ViString) {
//					System.out.println(((ViString) prettyString).getValue());
//				}
//			}
//		} else {
//			if (prtStr instanceof ViString) {
//				System.out.println(((ViString) prtStr).getValue());
//			} else {
//				System.out.println("Wierd");
//			}
//		}
//	}

}
