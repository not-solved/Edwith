package example1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// HelloServlet 클래스 생성자
    public HelloServlet() {
        super();
    }

    /*	Functions
     * 	1. GET : 정보를 요청(Select)
     * 	2. POST : 정보를 삽입(Insert)
     * 	3. PUT : 정보를 업데이트(Update)
     * 	4. DELETE : 정보를 삭제 (Delete)
     * 
     * 	5. HEAD : http 헤더 정보만 요청 (해당 자원이 존재하는지, 혹은 서버에 문제가 없는지 확인용)
     * 	6. OPTIONS : 웹서버가 지원하는 메서드의 종류를 요청
     * 	7. TRACE : 클라이언트의 요청을 그대로 반환 (= Echo)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	/*	request	 : HttpServlet의 요청에 대한 매개변수
    	 *		- http 프로토콜의 request(요청)정보를 서블릿에게 전달하기 위해 사용된다.
    	 *		- 헤더정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽는 메서드를 갖는다.
    	 *		- Body의 Stream을 읽어 들이는 메서드를 갖는다. 
    	 */
    	/*	response : HttpServlet의 요청에 대한 반응을 하는 매개변수
    	 * 		- WAS는 어떤 클라이언트가 어떤 요청을 보냈는지 알고 있으며, 이에 응답을 보내기 위한 객체이다.
    	 * 		- content type, 응답코드, 응답 메세지 등을 전달하기 위해 사용된다.
    	 */
    	// 오컨데 reqeust에 대한 response를 지정하는 함수라 할 수 있다.
		response.setContentType("text/html;'charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello World!</h1>");
		
		/* setContentType -> response으로 입출력을 할 때의 설정 (텍스트를 html방식으로, charset을 UTF-8 방식으로 이용)
		 * getWriter -> 출력을 위한 함수
		 */
	}
}
