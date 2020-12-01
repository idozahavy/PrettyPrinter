package prettyprinter.tests.convertor;

import com.github.idozahavy.prettyprinter.beans.ViCollection;
import com.github.idozahavy.prettyprinter.beans.ViObject;
import com.github.idozahavy.prettyprinter.beans.ViString;
import com.github.idozahavy.prettyprinter.config.InvokationPermit;
import com.github.idozahavy.prettyprinter.convertors.ObjectViConvertor;
import com.github.idozahavy.prettyprinter.convertors.ViConvertorConfig;
import com.github.idozahavy.prettyprinter.strtable.StrTableConvertor;

public class Test0 {

	public static void main(String[] args) {
		
		ViConvertorConfig config = new ViConvertorConfig();
		config.addPermit(InvokationPermit.ToString);
		ViObject ob = ObjectViConvertor.convert(new int[]{1,2,3}, config);
		System.out.println(ob);
		if (ob instanceof ViCollection) {
			ViCollection coll = (ViCollection) ob;
			System.out.println(coll.getType());
			for (ViObject viObject : coll) {
				System.out.println(viObject);
			}
		}
		else {
			ViString str = (ViString) ob;
			System.out.println(str);
		}
		System.out.println("***");
		System.out.println(StrTableConvertor.convert(ob));
	}

}
