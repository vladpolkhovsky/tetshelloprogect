import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new HelloServlet()), "/hello");
        HandlerList hList = new HandlerList();
        hList.setHandlers(new Handler[]{ contextHandler });
        server.setHandler(hList);
        try {
            server.start();
            System.out.println("started");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}