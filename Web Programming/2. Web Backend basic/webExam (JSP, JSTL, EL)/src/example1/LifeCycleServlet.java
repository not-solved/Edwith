package example1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// LifeCycleServelt 클래스 생성자
    public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	// Init 매서드 : Servlet을 초기화하는 함수 (생성 시 초기화)
    // 메모리에 Servlet이 없을 경우, 해당 서블릿 클래스를 생성 후 메모리에 올리고 init 호출
	public void init(ServletConfig config) throws ServletException {
		// ServletConfig : Servlet 상태를 설정
		System.out.println("Servlet is created!");
	}

	// Destory 매서드 : Servlet을 제거하는 함수 (사용 종료시 해제하는 역할)
	// WAS 종료 시점, 또는 Servlet 파일이 갱신될 경우 호출
	public void destroy() {
		System.out.println("Servlet is destoyed!");
	}

	/*  Service 메서드 : 클라이언트의 요청을 받아 서비스를 제공하는 부분
	 *	클라이언트가 WAS에 접근할 경우 실행됨
	 *	클라이언트의 요청에 따라 request, response 관련 메서드를 호출
	 *	GET일 경우 doGet을, POST일 경우 doPost 방식으로 수행된다.  
	 
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet service is served");
	}
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/webExam/LifeCycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}
}
