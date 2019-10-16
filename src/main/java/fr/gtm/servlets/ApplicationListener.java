package fr.gtm.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

import fr.gtm.services.CommuneServices;

@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger("communes");

	public void contextDestroyed(ServletContextEvent sce) {
		EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
		emf.close();
		LOG.info(">>> EMF closed");
		LOG.info(">>> application retirée");
	}

	public void contextInitialized(ServletContextEvent sce) {
		LOG.info(">>> application anihilée");
		// le "communes" doit être le nom ds le persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("communes");
		LOG.info(">>>EMF: " + emf);
		// récupère le contexte de l'application (toutes les servlets)
		ServletContext application = sce.getServletContext();
		application.setAttribute(Constantes.EMF, emf);
		// création du service
		CommuneServices service = new CommuneServices(emf);
		LOG.info(">>> service: " + service);
		application.setAttribute(Constantes.COMMUNE_SERVICE, service);

	}

}
