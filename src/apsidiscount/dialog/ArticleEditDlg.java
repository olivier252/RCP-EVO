package apsidiscount.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import apsidiscount.models.Article;
import apsidiscount.models.Catalog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.Button;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;

public class ArticleEditDlg extends Dialog {
	
	private DataBindingContext m_bindingContext;


	/**
	 * Create the dialog.
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public ArticleEditDlg(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM);
	}
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param catalog use to fill the combo in the EditDialog
	 * @wbp.parser.constructor
	 */
	public ArticleEditDlg(Shell parentShell, Catalog catalog) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM);
		this.catalog = catalog; 
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(String.format("Article dialog : %s (%d)", article.getName(), article.getId()));
	}
	
	private Catalog catalog;
	private Article article;
	private Text txtName;
	private Text txtImage;
	private Label lblManufacturer;
	private Combo cmbCategory;
	private ComboViewer cmbViewerCat;
	private Combo cmbManufacturer;
	private ComboViewer cmbViewerMan;
	private Label lblImage_1;
	private Button btnNewButton_3;
	private Label lblContent;
	private Text txtContent;
	
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	


	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 3;
		
		Label lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label lblImage = new Label(container, SWT.NONE);
		lblImage.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImage.setText("Category");
		
		//Combo category
		cmbViewerCat = new ComboViewer(container, SWT.NONE);
		cmbCategory = cmbViewerCat.getCombo();
		cmbCategory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		
		lblManufacturer = new Label(container, SWT.NONE);
		lblManufacturer.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblManufacturer.setText("Manufacturer");
		
		cmbViewerMan = new ComboViewer(container, SWT.NONE);
		cmbManufacturer = cmbViewerMan.getCombo();
		cmbManufacturer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		lblImage_1 = new Label(container, SWT.NONE);
		lblImage_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImage_1.setText("Image");
		
		txtImage = new Text(container, SWT.BORDER);
		txtImage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnNewButton_3 = new Button(container, SWT.NONE);
		btnNewButton_3.setText("...");
		
		lblContent = new Label(container, SWT.NONE);
		lblContent.setAlignment(SWT.CENTER);
		lblContent.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 3, 1));
		lblContent.setText("Content");
		
		txtContent = new Text(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		GridData gd_txtContent = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_txtContent.heightHint = 209;
		txtContent.setLayoutData(gd_txtContent);
		
		
		
		ViewerSupport.bind(cmbViewerCat		,catalog.getObservableCategory() 	, BeanProperties.value("name"));
		ViewerSupport.bind(cmbViewerMan		,catalog.getObservableManufacturer(), BeanProperties.value("name"));
		
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		m_bindingContext = initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(666, 639);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtName);
		IObservableValue nameArticleObserveValue = BeanProperties.value("name").observe(article);
		bindingContext.bindValue(observeTextTxtNameObserveWidget, nameArticleObserveValue, null, null);
		//
		IObservableValue observeTextTxtImageObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtImage);
		IObservableValue imageArticleObserveValue = BeanProperties.value("image").observe(article);
		bindingContext.bindValue(observeTextTxtImageObserveWidget, imageArticleObserveValue, null, null);
		//
		IObservableValue observeTextTxtContentObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtContent);
		IObservableValue contentArticleObserveValue = BeanProperties.value("content").observe(article);
		bindingContext.bindValue(observeTextTxtContentObserveWidget, contentArticleObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionCmbViewerCat = ViewerProperties.singleSelection().observe(cmbViewerCat);
		IObservableValue categoryArticleObserveValue = BeanProperties.value("category").observe(article);
		bindingContext.bindValue(observeSingleSelectionCmbViewerCat, categoryArticleObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionCmbViewerMan = ViewerProperties.singleSelection().observe(cmbViewerMan);
		IObservableValue manufacturerArticleObserveValue = BeanProperties.value("manufacturer").observe(article);
		bindingContext.bindValue(observeSingleSelectionCmbViewerMan, manufacturerArticleObserveValue, null, null);
		//
		return bindingContext;
	}
}
