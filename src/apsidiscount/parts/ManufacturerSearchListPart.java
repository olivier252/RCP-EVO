package apsidiscount.parts;

import org.eclipse.core.databinding.observable.list.IObservableList;

import apsidiscount.models.Catalog;
import apsidiscount.models.Manufacturer;

public class ManufacturerSearchListPart extends SearchListPart {

	@Override
	public IObservableList getObservableItems(Catalog catalog) {
		
		return catalog.getObservableManufacturer();
	}

	@Override
	public String getLabel(Object element) {
	
		return ((Manufacturer)element).getName();
	}

}
