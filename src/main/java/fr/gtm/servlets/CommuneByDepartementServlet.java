package fr.gtm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.entities.Commune;
import fr.gtm.services.CommuneServices;

/**
 * Servlet implementation class CommuneByDepartementServlet
 */
@WebServlet("/CommuneByDepartementServlet")
public class CommuneByDepartementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommuneServices service=(CommuneServices) getServletContext().getAttribute(Constantes.COMMUNE_SERVICE);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String departement=request.getParameter("departement");
		String page;
		if(departement==null ||departement.isEmpty()) {
			page="/index.jsp";
		}else {
			List<Commune> communes=service.getCommunesByDepartement(departement);
			request.setAttribute("communes", communes);
			page="/show-communes-by-departement.jsp";
		}

		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
