/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="venue")
public class Venue {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String address;
	private String ownerName;
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<Event> listOfEvents;
	
	public Venue() {
		
	}
	
	public Venue(String name, String address, String ownerName) {
		this.address = address;
		this.name = name;
		this.ownerName = ownerName;
	}

	public Venue(String name, String address, String ownerName, List<Event> listOfEvents) {
		this.address = address;
		this.name = name;
		this.ownerName = ownerName;
		this.listOfEvents = listOfEvents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Event> getListOfEvents() {
		return listOfEvents;
	}

	public void setListOfEvents(List<Event> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", address=" + address + ", ownerName=" + ownerName
				+ ", listOfEvents=" + listOfEvents + "]";
	}
	
	
}
