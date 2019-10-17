package fr.gtm.servlets;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.dao.CommuneDAO;
import fr.gtm.entities.Commune;
import fr.gtm.services.CommuneServices;

@WebServlet("/CommuneServlet")
public class CommuneServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommuneServices service=(CommuneServices) getServletContext().getAttribute(Constantes.COMMUNE_SERVICE);
		Writer out =response.getWriter();
		String cp=request.getParameter("cp");
		String page;
		if(cp==null ||cp.isEmpty()) {
			page="/index.jsp";
		}else {
			List<Commune> communes=service.getCommunesByCodePostal(cp);
			request.setAttribute("communes", communes);
			page="/show-communes-by-CP.jsp";
		}

		RequestDispatcher rd=getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
