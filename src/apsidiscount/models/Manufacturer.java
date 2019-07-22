package apsidiscount.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Beans handling the manufacturer of article defined by its name and id.
 * @author Victor
 */
public class Manufacturer {
	
	private int id;
	private String name;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	/**
	 * Construct a new manufacturer with invalid name (empty) and invalid id (set to 0). 
	 */
	public Manufacturer() {
		this.setId(0);
		this.setName(null); 
	}
	/**
	 * Construct a new Manufacturer with the specified data. 
	 */
	public Manufacturer(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	/**
	 * Get the Manufacturer id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Set the Manufacturer id
	 * @param id the id to set
	 */
	public void setId(int id) {
		pcs.firePropertyChange("id",this.id , this.id = id);
	}
	/**
	 * Get the Manufacturer name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public String getNom() {
		return name;
	}
	/**
	 * set the manufacturer name
	 * @param name the name to set
	 */
	public void setName(String name) {
		pcs.firePropertyChange("name", this.name, this.name = name);
	}
	
	public void setNom(String name) {
		pcs.firePropertyChange("name", this.name, this.name = name);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Manufacturer) {
			return this.id == ((Manufacturer) o).id;
		}
		return false;
	}

	
	
}
