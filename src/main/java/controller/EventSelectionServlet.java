package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import model.Venue;

/**
 * Servlet implementation class EventSelectionServlet
 */
@WebServlet("/eventSelectionServlet")
public class EventSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventHelper eh = new EventHelper();
		String action = request.getParameter("userSelection");
		String path = "/viewEventsServlet"; // Default path
		try {
			if (action.equals("Delete")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Event eventToRemove = eh.getEventByID(selectId);
					eh.removeEvent(eventToRemove);
			} else if (action.equals("Edit")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Event eventToEdit = eh.getEventByID(selectId);
					request.setAttribute("eventToEdit", eventToEdit);
					VenueHelper vh = new VenueHelper();
					request.setAttribute("allVenues", vh.getAllVenues());
					path = "/edit-event.jsp";	
			} else if (action.equals("Add")) {
			path = "/add-event.html";
			}
		} catch (NumberFormatException e) {
			//Invalid ID selection, simply returns the user back to the list
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
