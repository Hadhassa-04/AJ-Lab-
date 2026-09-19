import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DemoServlet extends HttpServlet {

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        PrintWriter pw = res.getWriter();

        ServletContext context = getServletContext();

        String driverName = context.getInitParameter("dname");

        pw.println("<html>");
        pw.println("<body>");

        pw.println("<h1>ServletContext Example</h1>");

        pw.println("<p>Driver name is: " + driverName + "</p>");

        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }
}