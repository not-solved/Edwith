package example2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParameterServlet() {
        super();
    }
    /*	파라미터 정보 접근방법
   	 *	URL 상의 정보를 통해 읽기 때문에, URL에서 해당 파라미터의 정보가 없으면 null값으로 출력된다.
   	 *	http://localhost:8000/ParameterServlet		<= name, age 값이 없다.
   	 *			--> ParameterServlet 이후에 ?을 시작으로 파라미터 정보가 온다.
   	 *								이는 클래스 상단에 명시된 웹 서블릿 주소 이후에 명시할 수 있다.
   	 *			-->	(변수명)=(변수값) 형태로 오며, &으로 연결하여 여러 파라미터 변수가 나열된다.
   	 *	URL상에서 파라미터 정보가 없어도 input 태그를 통해 파라미터를 전달할 수 있다.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		out.println("name : " + name + "<br>");
		out.println("age  : " + age + "<br>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
