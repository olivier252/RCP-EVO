package apsidiscount.parts;

import org.eclipse.core.databinding.observable.list.IObservableList;

import apsidiscount.models.Catalog;
import apsidiscount.models.Category;

public class CategorySearchListPart extends SearchListPart {

	@Override
	public IObservableList getObservableItems(Catalog catalog) {
		
		return catalog.getObservableCategory();
		
	}

	@Override
	public String getLabel(Object element) {
		
		return ((Category)element).getName();
	}

}
