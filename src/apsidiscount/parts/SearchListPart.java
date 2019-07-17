 
package apsidiscount.parts;

import javax.inject.Inject;

import javax.annotation.PostConstruct;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import apsidiscount.models.Catalog;
import apsidiscount.models.Category;

public abstract class SearchListPart {
	@Inject
	public SearchListPart() {
		
	}
	
	private final static String MAINSTACKID = "apsidiscount.partstack.main";
	private int subpart = 1;
	public abstract IObservableList getObservableItems(Catalog catalog);
	
	public abstract String getLabel(Object element);
	
	@PostConstruct
	public void postConstruct(Composite parent, Catalog catalog, EPartService partService, EModelService modelService, MApplication app) {
		parent.setLayout(new GridLayout());
		
		Text searchbar = new Text(parent,SWT.SINGLE|SWT.BORDER);
		searchbar.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false,1,1));
		
		ListViewer list = new ListViewer(parent,SWT.SINGLE);
		list.getList().setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,true,1,1));
		list.addDoubleClickListener(e -> {
			MPartStack stackMain = (MPartStack) modelService.find(MAINSTACKID,app);
			MPart newPart = modelService.createModelElement(MPart.class);
			Object selection = list.getStructuredSelection().getFirstElement();
			
			newPart.setElementId("apsidiscount.part.products" + subpart++);
			newPart.setCloseable(true);
			newPart.setLabel(getLabel(selection));
			newPart.setContributionURI("bundleclass://ApsiDiscount/apsidiscount.parts.ProductGridPart");
			partService.showPart(newPart, PartState.ACTIVATE);
			stackMain.getChildren().add(newPart);
			
		});
		
		
		searchbar.addModifyListener(e -> {
			list.setFilters(new ViewerFilter() {

				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return getLabel(element).toLowerCase().contains(searchbar.getText().toLowerCase());
				}
				
			});
		});
		
		ViewerSupport.bind(list,getObservableItems(catalog), BeanProperties.value("name"));
	}
	

	
	
	
}