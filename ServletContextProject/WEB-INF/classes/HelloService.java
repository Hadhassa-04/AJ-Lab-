import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloService extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello I am from IT-D</h1>");
        out.println("<p>Hadhassa</p>");
        out.println("</body>");
        out.println("</html>");
    }
}