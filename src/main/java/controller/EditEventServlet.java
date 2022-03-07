package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;

/**
 * Servlet implementation class EditEventServlet
 */
@WebServlet("/editEventServlet")
public class EditEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEventServlet() {
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
		String name = request.getParameter("name");
		int venueID = Integer.parseInt(request.getParameter("venue"));
		String date = request.getParameter("date");
		int tempId = Integer.parseInt(request.getParameter("id"));
		Event eventToUpdate = eh.getEventByID(tempId);
		eventToUpdate.setName(name);
		VenueHelper vh = new VenueHelper();
		eventToUpdate.setVenue(vh.getVenueByID(venueID));
		eventToUpdate.setDate(date);
		eh.editEvent(eventToUpdate);
		getServletContext().getRequestDispatcher("/viewEventsServlet").forward(request, response);
	}

}
