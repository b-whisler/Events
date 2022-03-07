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
import javax.persistence.TypedQuery;

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
	
	public void removeEvent(Event e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Event> typedQuery = em.createQuery("select e from Event e where e.id = :selectedId", Event.class);
		typedQuery.setParameter("selectedId", e.getId());
		typedQuery.setMaxResults(1);
		Event result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Event> getAllEvents(){
		EntityManager em = emfactory.createEntityManager();
		List<Event> allEvents = em.createQuery("SELECT e FROM Event e").getResultList();
		return allEvents;
	}
	
	public List<Event> getAllEventsOfVenue(Venue v){
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Event> typedQuery = em.createQuery("SELECT e FROM Event e where e.venue.id = :selectedId", Event.class);
		typedQuery.setParameter("selectedId", v.getId());
		List<Event> allEvents = typedQuery.getResultList();
		return allEvents;
	}
	
	public Event getEventByID(int idToFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Event result = em.find(Event.class, idToFind);
		em.close();
		return result;
	}
	
	public void editEvent (Event toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
