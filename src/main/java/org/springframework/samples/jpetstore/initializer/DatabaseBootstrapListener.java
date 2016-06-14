package org.springframework.samples.jpetstore.initializer;


import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener()
public class DatabaseBootstrapListener implements ServletContextListener {

	@Resource(name = "jdbc/jpetstore")
	DataSource ds;
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ConnectionManager.initialize(ds);
		
		DataLoader dataLoader = new DataLoader();
		dataLoader.setUpParksData();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	
}
