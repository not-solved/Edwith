package example2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoServlet() {
        super();
    }

    // 서블릿의 정보를 읽는 방법
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>form</title><head>");
		out.println("<body>");
		
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String contentPath = request.getContextPath();
		String remoteAddr = request.getRemoteAddr();
		
		out.println("URI\t:" + uri + "<br>");
		out.println("URL\t:" + url + "<br>");
		out.println("ContentPath\t:" + contentPath + "<br>");
		out.println("ReomteAddr\t:" + remoteAddr + "<br>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
