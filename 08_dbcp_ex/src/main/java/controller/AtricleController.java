package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AtricleController
 */
@WebServlet("*.do")
public class AtricleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtricleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  // 인코딩 및 응답 타입
	  response.setContentType("text/html; charset=UTF-8");
	  
	  // 요청 주소 확인.
	  String requestURI = request.getRequestURI(); // 요청된 URL와 경로로 지정된 파일과 이름이 같다면 requestURI에 저장
	  String contextPath = request.getContextPath(); // context 된 경로를 나타낸다. 즉, 루트경로.
	  String urlMapping = requestURI.substring(contextPath.length());  // 
	  
	  // 어디로 어떻게 이동할 것인지 알고 있는 ActionForward 객체 
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
