/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Mar 6, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Event;
import model.Venue;

public class EventHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Events");
	
	public void addEvent(Event e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
		}
	
	
	public List<Event> getAllEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<Event> allEvents = em.createQuery("SELECT e FROM Event e").getResultList();
		return allEvents;
	}
}
