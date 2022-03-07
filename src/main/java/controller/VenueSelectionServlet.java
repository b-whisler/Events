package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Venue;

/**
 * Servlet implementation class VenueSelectionServlet
 */
@WebServlet("/venueSelectionServlet")
public class VenueSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenueSelectionServlet() {
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
		VenueHelper vh = new VenueHelper();
		String action = request.getParameter("userSelection");
		String path = "/viewVenuesServlet"; // Default path
		try {
			if (action.equals("Delete")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Venue venueToRemove = vh.getVenueByID(selectId);
					vh.removeVenue(venueToRemove);
			} else if (action.equals("Edit")) {
					Integer selectId = Integer.parseInt(request.getParameter("id"));
					Venue venueToEdit = vh.getVenueByID(selectId);
					request.setAttribute("venueToEdit", venueToEdit);
					path = "/edit-venue.jsp";	
			} else if (action.equals("Add")) {
			path = "/add-venue.html";
			}
		} catch (NumberFormatException e) {
			//Invalid ID selection, simply returns the user back to the list
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
