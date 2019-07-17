/**
 * 
 */
package apsidiscount.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Singleton;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.e4.core.di.annotations.Creatable;
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
	

	public Catalog() {
		
        manufacturers.add(new Manufacturer( 1, "asus"	 ));
		manufacturers.add(new Manufacturer( 2, "acer"	 ));
		manufacturers.add(new Manufacturer( 3, "samsung" ));
		manufacturers.add(new Manufacturer( 4, "evga"	 ));
		manufacturers.add(new Manufacturer( 5, "iiyama"	 ));
		manufacturers.add(new Manufacturer( 6, "logitech"));
		manufacturers.add(new Manufacturer( 7, "gigabyte"));
		manufacturers.add(new Manufacturer( 8, "MSI"	 ));
		manufacturers.add(new Manufacturer( 9, "intel"	 ));
		manufacturers.add(new Manufacturer(10, "AMD"	 ));

		categories.add(new Category(1, "écran"));
		categories.add(new Category(2, "clavier"));
		categories.add(new Category(3, "carte graphique"));
		categories.add(new Category(4, "cpu"));
		categories.add(new Category(5, "carte mère"));
		categories.add(new Category(6, "stockage"));
		categories.add(new Category(7, "souris"));
		
		Calendar cal = new GregorianCalendar();
		
		articles.add(new Article(
			1, "ASUS Ecran Gaming MG248QE", 
			"/assets/images/materiel/ASUS Ecran Gaming MG248QE.PNG", new BigDecimal(219.00),
			"Ecran LCD à rétroéclairage LED - matrice active TFT\nInterfaces : DisplayPort, HDMI, DVI-D (double connexion), Casque\nRésolution native : Full HD (1080p) 1920 x 1080 à 144 Hz\nTemps de réponse : 1 ms (gris à gris)\nType de panneau : TN\nLuminosité : 350 cd-m²\nRapport de contraste : 100000000:1 (dynamique)",
			categories.get(0), manufacturers.get(0), null,5
		));
		articles.add(new Article(
			2, "MSI Optix MAG241C",
			"assets/images/materiel/MSI Optix MAG241C.PNG", new BigDecimal(214.00),
			"Ecran Gamer Incurvé 23,6\" - FHD - 1ms - 144Hz - DisplayPort / HDMI \nEcran LCD à rétroéclairage LED - matrice active TFT \nInterfaces : DisplayPort, 2 x HDMI, Amont USB 2.0 (Type B), 2 x aval USB 2.0, Casque \nRésolution native : Full HD (1080p) 1920 x 1080 (DisplayPort: 144 Hz, HDMI: 144 Hz) \nTemps de réponse : 1 ms (MPRT) \nType de panneau : VA \nLuminosité : 300 cd-m² \nRapport de contraste : 3000:1 - 100000000:1 (dynamique)",
			categories.get(0), manufacturers.get(7), cal.getTime(), 20
		));
		articles.add(new Article(
			3, "SAMSUNG Ecran incurvé C24FG73", 
			"/assets/images/materiel/SAMSUNG Ecran incurvé C24FG73.PNG", new BigDecimal(309.99),
			"24\" Full HD - Dalle VA - 1ms - HDMI/DP - FreeSync \nQLED monitor - matrice active TFT \nInterfaces : DisplayPort, 2 x HDMI, Casque \nRésolution native : Full HD (1080p) 1920 x 1080 à 144 Hz \nTemps de réponse : 1 ms \nType de panneau : VA \nLuminosité : 350 cd-m² \nRapport de contraste : 3000:1",
			categories.get(0), manufacturers.get(2), cal.getTime(), 5
		));
		articles.add(new Article(
			4, "GIGABYTE Carte Mère Z370P D3",
			"/assets/images/materiel/GIGABYTE Carte Mère Z370P D3.PNG", new BigDecimal(109.99),
			"Carte-mère - ATX - Socket LGA1151\nTechnologie : DDR4\nInterfaces : 1 x LAN (Gigabit Ethernet), 1 x HDMI, 1 x clavier PS-2, 1 x sortie de ligne audio - mini-jack, 1 x entrée de ligne audio - mini-jack, 1 x microphone - mini-jack,",
			categories.get(4), manufacturers.get(6), cal.getTime(), 6
		));
		articles.add(new Article(
			5, "ASUS Carte Mère ROG MAXIMUS X HERO",
			"/assets/images/materiel/ASUS Carte Mère ROG MAXIMUS X HERO.PNG", new BigDecimal(273.27),
			"Carte-mère - ATX - Socket LGA1151\nTechnologie : DDR4\nInterfaces : 1 x HDMI, 1 x DisplayPort, 4 x USB 3.1 Gen 1, 1 x LAN (Gigabit Ethernet), 1 x entrée de ligne audio - mini-jack, 1 x sortie de ligne audio - mini-jack,",
			categories.get(4), manufacturers.get(0), cal.getTime(),2
		));
		articles.add(new Article(
			6, "LOGITECH Souris Gamer G402",
			"/assets/images/materiel/LOGITECH Souris Gamer G402 Hyperion Fury FPS.PNG", new BigDecimal(29.99),
			"La souris Logitech G402 Hyperion Fury est la souris pour le jeu la plus rapide au monde, grâce à la technologie de moteur à fusion qui permet le suivi à une vitesse de plus de 1 m/s, en plus de ses 8 boutons programmables et ses 4 paramètres de résolution ppp.",
			categories.get(6), manufacturers.get(5), cal.getTime(), 10
		));
		articles.add(new Article(
			7, "LOGITECH M330 Silent Plus",
			"/assets/images/materiel/LOGITECH M330 Silent Plus.PNG", new BigDecimal(19.99),
			"Souris - Connectivité sans fil 2,4 GHz de pointe\nRésolution : 1000 ppp\nNombre de boutons : 3\nCaractéristiques : Silencieuse : réduction des bruits de plus de 90 %",
			categories.get(6), manufacturers.get(5), cal.getTime(), 10
		));
		articles.add(new Article(
			8, "LOGITECH M187 Noir",
			"/assets/images/materiel/LOGITECH M187 Noir.PNG", new BigDecimal(16.95),
			"Souris sans fil - Format de poche ultra-compacte - Récepteur compact pour la connexion sans fil - Technologie sans fil 2,4 GHz de pointe Logitech pour une connexion fiable - Compatible PC (Windows Vista, 7, 8 et Windows 10), Mac et Linux - Garantie du fabricant 1 an.",
			categories.get(6), manufacturers.get(5), cal.getTime(), 5
		));
		articles.add(new Article(
			9, "GeForce® GTX 1050 Ti ",
			"/assets/images/materiel/cg_1050ti.PNG", new BigDecimal(195.40),
			"NVIDIA GeForce GTX 1050 Ti - 4 Go\nType de bus : PCI Express 3.0 x16\nHorloge principale : 1316 MHz\nHorloge boostée : 1430 MHz\nInterfaces : DVI-D (liaison double), DisplayPort, HDMI\nTechnologie : GDDR5 SDRAM",
			categories.get(2), manufacturers.get(0), cal.getTime(), 5
		));
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
