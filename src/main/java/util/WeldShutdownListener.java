package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.jboss.weld.environment.servlet.Listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class WeldShutdownListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		stopWeldPreloaderThreads();
	}
	
    private void stopWeldPreloaderThreads() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            Thread[] threads = new Thread[threadGroup.activeCount()];
            threadGroup.enumerate(threads);

            for (Thread thread : threads) {
                if (thread.getName().startsWith("weld-preloader")) {
                    thread.interrupt();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
