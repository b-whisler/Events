/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.VenueHelper;

@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Venue venue;
	@Column(name="NAME")
	private String name;
	@Column(name="DATE")
	private LocalDate date;
	
	
	public Event() {
		
	}
	
	public Event(Venue venue, String name, LocalDate date) {
		this.venue = venue;
		this.name = name;
		this.date = date;
	}
	
	public Event(String name, int venueID, String date) {
		VenueHelper vh = new VenueHelper();
		this.name = name;
		this.venue = vh.getVenueByID(venueID);
		this.date = convertDate(date);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setDate(String date) {
		this.date = convertDate(date);
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", venue=" + venue + ", name=" + name + ", date=" + date + "]";
	}
	
	private LocalDate convertDate(String formDate) {
		int year = Integer.parseInt(formDate.substring(0, 4));
		int month = Integer.parseInt(formDate.substring(5, 7));
		int day = Integer.parseInt(formDate.substring(8, 10));
		LocalDate convertedDate = LocalDate.of(year, month, day);
		//LocalDate convertedDate = LocalDate.now();
		return convertedDate;
	}
	
	
}
