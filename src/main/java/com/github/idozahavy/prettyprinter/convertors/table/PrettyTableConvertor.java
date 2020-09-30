package com.github.idozahavy.prettyprinter.convertors.table;

import java.util.List;

import com.github.idozahavy.prettyprinter.beans.SimpleString;
import com.github.idozahavy.prettyprinter.beans.StringCollection;
import com.github.idozahavy.prettyprinter.beans.StringHorizontalCollection;
import com.github.idozahavy.prettyprinter.beans.StringVerticalCollection;
import com.github.idozahavy.prettyprinter.beans.interfaces.IPrettyString;
import com.github.idozahavy.prettyprinter.beans.interfaces.IStringCollection;
import com.github.idozahavy.prettyprinter.convertors.interfaces.IPrettyConvertor;

public class PrettyTableConvertor implements IPrettyConvertor<IPrettyString> {

	@Override
	public IPrettyString convert(IPrettyString object) {
		return convertTable(object);
	}

	public static IPrettyString convertTable(IPrettyString object) {
		IPrettyString result = object;

		if (object instanceof IStringCollection) {
			StringCollection coll = (StringCollection) object;
			
			List<IPrettyString> items = coll.getItems();
			StringCollection newColl;
			if (coll instanceof StringHorizontalCollection) {
				newColl = new StringHorizontalCollection(null);
			} else if (coll instanceof StringVerticalCollection) {
				newColl = new StringVerticalCollection(null);
			}
			else { // OneStringCollection
				return object;
			}
			for (int i = 0; i < items.size(); i++) {
				newColl.add(convertTable(items.get(i)));
			}
			if (coll.getObject() == null) {
				return newColl;
			}

			String objectName = ((Class<?>)coll.getObject()).getSimpleName();

			StringHorizontalCollection newHorizontalCollection = new StringHorizontalCollection(null);

			StringVerticalCollection leftVerticalCollection = new StringVerticalCollection(null);
			for (int i = 0; i < newColl.getHeight() + 2; i++) {
				leftVerticalCollection.add(new SimpleString("*"));
			}

			StringVerticalCollection middleVerticalCollection = new StringVerticalCollection(null);
			System.out.println("coll width"+newColl.getWidth());
			int firstWidth = Math.max(newColl.getColumn(0).getWidth(), objectName.length()+2);
			String firstUpperStars = "*" + objectName + "*".repeat(firstWidth - objectName.length() - 1);
			StringHorizontalCollection upperCollection = new StringHorizontalCollection(null);
			upperCollection.add(new SimpleString(firstUpperStars));
			for (int i=1;i<newColl.getColumnCount();i++)
			{
				upperCollection.add(new SimpleString("*".repeat(newColl.getColumn(i).getWidth())));
			}
			middleVerticalCollection.add(upperCollection);
			middleVerticalCollection.add(newColl);
			StringHorizontalCollection bottomCollection = new StringHorizontalCollection(null);
			bottomCollection.add(new SimpleString("*".repeat(firstWidth)));
			for (int i=1;i<newColl.getColumnCount();i++)
			{
				bottomCollection.add(new SimpleString("*".repeat(newColl.getColumn(i).getWidth())));
			}
			middleVerticalCollection.add(bottomCollection);

			StringVerticalCollection rightVerticalCollection = new StringVerticalCollection(null);
			for (int i = 0; i < newColl.getHeight() + 2; i++) {
				rightVerticalCollection.add(new SimpleString("*"));
			}

			newHorizontalCollection.add(leftVerticalCollection);
			newHorizontalCollection.add(middleVerticalCollection);
			newHorizontalCollection.add(rightVerticalCollection);

			return newHorizontalCollection;
		}
		return result;
	}

}
