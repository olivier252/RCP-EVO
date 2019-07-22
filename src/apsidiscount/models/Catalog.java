/**
 * 
 */
package apsidiscount.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import javax.inject.Singleton;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.e4.core.di.annotations.Creatable;

import apsidiscount.control.HttpClient;
/**
 * Bean to store articles, manufacturers and categories
 * @author Victor
 *
 */
@Creatable
@Singleton
public class Catalog {
	private WritableList<Article> 		articles = 		new WritableList<>();
	private WritableList<Manufacturer> manufacturers=	new WritableList<>();
	private WritableList<Category> 	categories=		new WritableList<>();
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private HttpClient httpClient =  new HttpClient();
	
	public Catalog() {
		
		List<Manufacturer> httpMan = httpClient.getAllManufacturer();
		List<Category> httpCat = httpClient.getAllCategory();
		List<Article> httpArticles = httpClient.getAllArticle(); 
		
		manufacturers.addAll(httpMan);
		categories.addAll(httpCat);
		articles.addAll(httpArticles);
		
		
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	// Getter and setter on collection , it's particular 
	
	public IObservableList<Article> getObservableArticles() {
		return articles;
	}
	
	/**
	 * Get all the articles in the catalog
	 * @return All catalog articles
	 */
	public Iterable<Article> getArticles() {
		return articles;
	}
	/**
	 * Get an article from the catalog.
	 * @param index the index of the article to retrieve
	 * @return The article at the given index
	 */
	public Article getArticles(int index) {
		return articles.get(index);
	}
	/**
	 * Set all the articles in the catalog.
	 * @param articles 
	 */
	public void setArticles(Article[] articles) {
		Object[] old = this.articles.toArray();
		this.articles.clear();
		for(Article a : articles) {
			this.articles.add(a);
		}
		pcs.firePropertyChange("articles", old, articles);
	}
	/**
	 * Set an article at the specified index.
	 * @param index to put the article on
	 * @param article to set in the catalog
	 */
	public void setArticles( int index, Article article) {
		Article old = getArticles(index);
		
		articles.set(index, article);
		pcs.fireIndexedPropertyChange("articles", index, old, article);
		httpClient.modifiedArticle(article);
	}
	/**
	 * Get all the manufacturers in the catalog
	 * @return All catalog manufacturers
	 */
	
	public Iterable<Manufacturer> getManufacturer() {
		return manufacturers;
	}
	/**
	 * Get an manufacturers from the catalog.
	 * @param index the index of the manufacturer to retrieve
	 * @return The manufacturer at the given index
	 */
	public Manufacturer getManufacturers(int index) {
		return manufacturers.get(index);
	}
	
	public IObservableList<Manufacturer> getObservableManufacturer() {
		return manufacturers;
	}
	/**
	 * Set all the manufacturers in the catalog.
	 * @param manufacturers 
	 */
	public void setManufacturers(Manufacturer[] manufacturer) {
		Object[] old = this.manufacturers.toArray();
		this.manufacturers.clear();
		for(Manufacturer a : manufacturer) {
			this.manufacturers.add(a);
		}
		pcs.firePropertyChange("manufacturers", old, articles);
	}
	/**
	 * Set an manufacturer at the specified index.
	 * @param index to put the article on
	 * @param manufacturer to set in the catalog
	 */
	public void setManufacturers( int index, Manufacturer manufacturer) {
		Manufacturer old = getManufacturers(index);
		
		manufacturers.set(index, manufacturer);
		pcs.fireIndexedPropertyChange("manufacturers", index, old, manufacturer);
	}
	
	/**
	 * Get all the categories in the catalog
	 * @return All catalog categories
	 */
	
	public Iterable<Category> getcategory() {
		return categories;
	}
	
	public IObservableList<Category> getObservableCategory() {
		return categories;
	}
	/**
	 * Get an categories from the catalog.
	 * @param index the index of the category to retrieve
	 * @return The category at the given index
	 */
	public Category getCategories(int index) {
		return categories.get(index);
	}
	/**
	 * Set all the categories in the catalog.
	 * @param categories 
	 */
	public void setCategories(Category[] category) {
		Object[] old = this.categories.toArray();
		this.categories.clear();
		for(Category a : category) {
			this.categories.add(a);
		}
		pcs.firePropertyChange("categories", old, articles);
	}
	/**
	 * Set an category at the specified index.
	 * @param index to put the article on
	 * @param category to set in the catalog
	 */
	public void setCategories( int index, Category category) {
		Category old = getCategories(index);
		
		categories.set(index, category);
		pcs.fireIndexedPropertyChange("categories", index, old, category);
	}
	

}
