 
package apsidiscount.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

import apsidiscount.dialog.ArticleEditDlg;
import apsidiscount.models.Article;
import apsidiscount.models.Catalog;

public class NewArticleHandler {
	@Execute
	public void execute(Shell shell, Catalog catalog) {
		
		ArticleEditDlg dlg = new ArticleEditDlg(shell, catalog);
		
		Article a = new Article();
		dlg.setArticle(a);
		
		if(dlg.open() == IDialogConstants.OK_ID) {
			catalog.getObservableArticles().add(a);
		}

	}
		
}