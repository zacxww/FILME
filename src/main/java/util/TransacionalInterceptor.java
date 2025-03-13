package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable {

  private static final long serialVersionUID = -929071369808806068L;

  @Inject
  private EntityManager manager;

  @AroundInvoke
  public Object invoke(InvocationContext context) throws Exception {
    EntityTransaction trx = manager.getTransaction();
    boolean criador = false;

    try {
      if (!trx.isActive()) {
        trx.begin();
        trx.rollback();
        trx.begin();
        criador = true;
      }
      return context.proceed();
    } catch (Exception e) {
      if (trx != null && criador) {
        trx.rollback();
      }
      throw e;
    } finally {
      if (trx != null && trx.isActive() && criador) {
        trx.commit();
      }
    }
  }
}
