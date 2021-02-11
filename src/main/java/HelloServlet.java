import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        System.out.println("Connection. + " + req.getServletPath());
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(String.format("<h1>url = '%s'</h1>", req.getServletPath()));
    }
}
