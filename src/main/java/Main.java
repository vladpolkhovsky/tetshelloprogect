import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("data");

        contextHandler.addServlet(new ServletHolder(new HelloServlet()), "/");
        contextHandler.addServlet(new ServletHolder(new IndexViewer("vladislav/index.html")), "/vladislav");
        HandlerList hList = new HandlerList();

        hList.setHandlers(new Handler[]{ resourceHandler, contextHandler });
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