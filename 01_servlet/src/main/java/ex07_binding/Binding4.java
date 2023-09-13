package ex07_binding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Binding3
 */
@WebServlet("/binding4")
public class Binding4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Binding4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  // ServletContext 영역의 msg 확인하기
	  Object msg7 = request.getServletContext().getAttribute("msg");
	  System.out.println(msg7);
	  
	  // HttpSession 영역의 msg 확인하기
	  String msg8 = (String)request.getSession().getAttribute("msg");
	  System.out.println(msg8);
	  
	  // HttpServletRequest 영역의 msg 확인하기
	  String msg9 = (String)request.getAttribute("msg");
	  System.out.println(msg9);

	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
