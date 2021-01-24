package example2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HeaderServlet() {
        super();
    }
    //	헤더 정보 접근방법
    /*	request	 : HttpServlet의 요청에 대한 매개변수
	 *		- http 프로토콜의 request(요청)정보를 서블릿에게 전달하기 위해 사용된다.
	 *		- 헤더정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽는 메서드를 갖는다.
	 *		- Body의 Stream을 읽어 들이는 메서드를 갖는다. 
	 */
	/*	response : HttpServlet의 요청에 대한 반응을 하는 매개변수
	 * 		- WAS는 어떤 클라이언트가 어떤 요청을 보냈는지 알고 있으며, 이에 응답을 보내기 위한 객체이다.
	 * 		- content type, 응답코드, 응답 메세지 등을 전달하기 위해 사용된다.
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		int index = 1;
		while(headerNames.hasMoreElements()) {	// 헤더 정보가 남아있으면 반복
			String HeaderName = headerNames.nextElement(); // iterator상의 element에 접근
			String HeaderValue = request.getHeader(HeaderName);
			out.println(index++ + " " + HeaderName + " : " + HeaderValue + "<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
