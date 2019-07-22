package apsidiscount.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Beans handling the category of article defined by its name and id.
 * @author Victor
 */
public class Category {
	private int id;
	private String name;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/**
	 * Construct a new category with invalid name (empty) and invalid id (set to 0). 
	 */
	public Category() {
		this.setId(0);
		this.setName(null);
	}
	
	/**
	 * Construct a new category with the specified data. 
	 */
	public Category(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	/**
	 * Get the category id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the category id
	 * @param id
	 */
	public void setId(int id) {
		pcs.firePropertyChange("id",this.id,this.id = id);
	}	
	
	/**
	 * Get the category name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	public String getNom() {
		return name;
	}

	/**
	 * Set the category name
	 * @param name
	 */
	public void setName(String name) {
		pcs.firePropertyChange("name", this.name,this.name = name);
	}
	
	public void setNom(String name) {
		pcs.firePropertyChange("name", this.name,this.name = name);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Category) {
			return this.id == ((Category) o).id;
		}
		return false;
	}



	
		
}
