package util;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

  private EntityManagerFactory factory;

  public EntityManagerProducer() {
    this.factory = Persistence.createEntityManagerFactory("meuPU");
  }

  @Produces
  @RequestScoped
  public EntityManager createEntityManager() {
    return this.factory.createEntityManager();
  }

  public void closeEntityManager(@Disposes EntityManager manager) {
    manager.close();
  }
  
  @PreDestroy
  public void closeFactory() {
	  if (this.factory != null && this.factory.isOpen()) {
		  this.factory.close();
	  }
  }
}
