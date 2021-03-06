import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(Integer.parseInt(System.getenv("PORT")));

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("data");

        contextHandler.addServlet(new ServletHolder(new IndexViewer("./index.html")), "/index.html");
        contextHandler.addServlet(new ServletHolder(new IndexViewer("vladislav/index.html")), "/vladislav");
        contextHandler.addServlet(new ServletHolder(new IndexViewer("theyalow/index.html")), "/theyalow");
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