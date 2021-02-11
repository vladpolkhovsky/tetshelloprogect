import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);
        try {
            server.getConnectors()[0].getConnectionFactory(HttpConnectionFactory.class);
            server.setHandler(new HttpHandler());
            server.start();
            System.out.println("Started.");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
