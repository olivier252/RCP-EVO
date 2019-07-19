 
package apsidiscount.parts;

import javax.inject.Inject;

import java.text.DecimalFormat;

import javax.annotation.PostConstruct;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import apsidiscount.control.HttpClient;
import apsidiscount.dialog.ArticleEditDlg;
import apsidiscount.models.Article;
import apsidiscount.models.Catalog;


public class ProductGridPart {
	
	private CheckboxTableViewer tableViewer;
	
	class LineBgColor {
		Color [] colors = new Color[2];
		private int cur = 0;
		
		public LineBgColor(Display display, RGB... colors) {
			this.colors = new Color[colors.length];
			for(int i=0; i<colors.length; i++) {
				this.colors[i] = new Color(display, colors[i]);
			}
		}
		public ViewerCell bg(ViewerCell cell) {
			cell.setBackground(colors[cur]);
			return cell;
		}
		public ViewerCell nextBgColor(ViewerCell cell) {
			cur = (cur+1)%colors.length;
			return bg(cell);
		}
	}
	
	private interface ArticleLabelProvider {
		public void update(ViewerCell cell, Article article);
	}
	
	@Inject
	public ProductGridPart() {
		
	}
	
	private TableViewerColumn addColumn(String title, int width, int style, ArticleLabelProvider provider) {
		TableViewerColumn col = new TableViewerColumn(tableViewer, style);
		
		col.getColumn().setWidth(width);
		col.getColumn().setText(title);
		col.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				provider.update(cell, (Article)cell.getElement());
				
			}
		});
		return col;
	}
	
	
	
	@PostConstruct
	public void postConstruct(Shell shell ,Composite parent,Catalog catalog) {
		parent.setLayout(new GridLayout(1, false));
		ArticleEditDlg dlg = new ArticleEditDlg(shell, catalog);
		HttpClient httpClient = new HttpClient();
		
		tableViewer = new CheckboxTableViewer(new Table(
				parent,
				SWT.BORDER|SWT.SINGLE|SWT.CHECK|SWT.FULL_SELECTION
		));
		
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.getTable().setHeaderVisible(true);
		
		DecimalFormat df = new DecimalFormat("0.00 €");
		LineBgColor line = new LineBgColor (
				parent.getDisplay(),
				new RGB(245,245,245),
				new RGB(210,210,210)
		);
		
		addColumn("name"		, 300	, SWT.LEFT	, (cell, article) -> line.nextBgColor(cell).setText(article.getName()));
		addColumn("Price"		, 100	, SWT.RIGHT	, (cell, article) -> line.bg(cell).setText(df.format(article.getPrice())));
		addColumn("Published"	, 150 	, SWT.CENTER, (cell, article) -> line.bg(cell).setText(article.getPublishedString()));
		addColumn("Stock"		, 60	, SWT.RIGHT	, (cell, article) -> {
			int stock = article.getStock();
			if(stock < 10) {
				cell.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
			}
			line.bg(cell).setText(Integer.toString(stock));
		});
		
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		tableViewer.setInput(catalog.getArticles());
		tableViewer.addDoubleClickListener(e -> {
			Article article = (Article) tableViewer.getStructuredSelection().getFirstElement();
			
			dlg.setArticle(httpClient.getArticleById(article.getId()));
			
			if(dlg.open() == IDialogConstants.OK_ID) {
				int index = catalog.getObservableArticles().indexOf(article);
				catalog.setArticles(index, dlg.getArticle());

			}
			
		});
		catalog.getObservableArticles().addListChangeListener(e -> tableViewer.refresh());
		
	}
	
	
	
	
}