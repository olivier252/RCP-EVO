package apsidiscount.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Article implements Cloneable {
	private int id;
	private String name;
	private String image;
	private BigDecimal price;
	private String content;
	private Category category;
	private Manufacturer manufacturer;
	private Date published;
	private int stock;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/**
	 * 
	 */
	public Article() {
		this(0, null, null, null, null); // call to the overloaded constructor 
	}
	/**
     * Construct a new article with required fields
     * @param id
     * @param name
     * @param price
     * @param category
     * @param manufacturer
     */
    public Article(int id, String name, BigDecimal price, Category category, Manufacturer manufacturer) {
        this(id, name, "", price, "", category, manufacturer, null, 0);
    }
    /**
     * Construct a new article with all fields
     * @param id
     * @param name
     * @param image
     * @param price
     * @param content
     * @param category
     * @param manufacturer
     * @param published
     * @param stock
     */
    public Article(int id, String name, String image, BigDecimal price, String content, Category category, Manufacturer manufacturer, Date published, int stock) {
        this.setId(id);
        this.setName(name);
        this.setImage(image);
        this.setPrice(price);
        this.setContent(content);
        this.setCategory(category);
        this.setManufacturer(manufacturer);
        this.setPublished(published);
        this.setStock(stock);
    }
    
    /**
     * clone an existing article
     * @return An article having the same field values
     */
    public Article clone() {
    	return new Article(id, name, image, price, content, category, manufacturer,
    			 published != null ? new Date(published.getTime()) : null, stock);
    		
    }
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	/**
	 * Get the Article id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id of the Article
	 * @param id the id to set
	 */
	public void setId(int id) {
		pcs.firePropertyChange("id", this.id, this.id = id);
	}

	/**
	 * Get the Article name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the Article
	 * @param name the name to set
	 */
	public void setName(String name) {
		pcs.firePropertyChange("name", this.name, this.name = name);
	}

	/**
	 * Get the Article image link
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Set the image link of the Article
	 * @param image the image to set
	 */
	public void setImage(String image) {
		pcs.firePropertyChange("image", this.image,this.image = image);
	}

	/**
	 * Get the Article price
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Set the price of the Article
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		pcs.firePropertyChange("price", this.price, this.price = price);
	}

	/**
	 * Get the Article description content
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	public String getDesignation() {
		return content;
	}

	/**
	 * Set the description content of the Article
	 * @param content the content to set
	 */
	public void setContent(String content) {
		pcs.firePropertyChange("content", this.content, this.content = content);
	}
	
	public void setDesignation(String content) {
		pcs.firePropertyChange("content", this.content, this.content = content);
	}

	/**
	 * Get the Article Category
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Set the category of the Article
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		pcs.firePropertyChange("category", this.category, this.category = category);
	}

	/**
	 * Get the Article manufacturer
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * Set the manufacturer of the Article
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		pcs.firePropertyChange("manufacturer", this.manufacturer, this.manufacturer = manufacturer);
	}

	/**
	 * Get the Article published date
	 * @return the published
	 */
	public Date getPublished() {
		return published;
	}
	
	public String getPublishedString() {
		return published == null
				? "not referenced"
				: new SimpleDateFormat("YYYY/MM/dd").format(published);
		
	}

	/**
	 * Set the published date of the Article
	 * @param published the published to set
	 */
	public void setPublished(Date published) {
		pcs.firePropertyChange("published", this.published, this.published = published);
	}

	/**
	 * Get the Article stock int
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Set the stock of the Article
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		pcs.firePropertyChange("stock", this.stock, this.stock = stock);
	}
	
}
