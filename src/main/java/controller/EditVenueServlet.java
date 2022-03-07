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
 * Servlet implementation class EditVenueServlet
 */
@WebServlet("/editVenueServlet")
public class EditVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVenueServlet() {
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
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String owner = request.getParameter("owner");
		int tempId = Integer.parseInt(request.getParameter("id"));
		Venue venueToUpdate = vh.getVenueByID(tempId);
		venueToUpdate.setName(name);
		venueToUpdate.setAddress(address);
		venueToUpdate.setOwnerName(owner);
		vh.editVenue(venueToUpdate);
		getServletContext().getRequestDispatcher("/viewVenuesServlet").forward(request, response);
	}

}
