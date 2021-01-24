package example1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
@WebServlet("/TenServlet")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>1부터 10까지 출력<h1>");
		for(int i = 1; i <= 10; i++)
			out.print(i+"<br>");
		
		out.close();
	}
}
