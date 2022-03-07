/**
 * @author Benjamin Whisler - bwhisler1
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Event;
import model.Venue;

public class VenueHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Events");
	
	public void addVenue(Venue v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
		}
	
	public void removeVenue(Venue v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Venue> typedQuery = em.createQuery("select v from Venue v where v.id = :selectedId", Venue.class);
		typedQuery.setParameter("selectedId", v.getId());
		typedQuery.setMaxResults(1);
		Venue result = typedQuery.getSingleResult();
		EventHelper eh = new EventHelper();
		for (Event ev : eh.getAllEventsOfVenue(v)) {
			eh.removeEvent(ev);
		}
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Venue> getAllVenues(){
		EntityManager em = emfactory.createEntityManager();
		List<Venue> allVenues = em.createQuery("SELECT v FROM Venue v").getResultList();
		return allVenues;
		}
	
	public Venue getVenueByID(int idToFind) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Venue result = em.find(Venue.class, idToFind);
		em.close();
		return result;
	}
	
	public void editVenue (Venue toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
