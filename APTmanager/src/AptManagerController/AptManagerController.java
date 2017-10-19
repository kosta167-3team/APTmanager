package AptManagerController;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintain_fees.action.BillController;

@WebServlet("*.bill")
public class AptManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AptManagerController() {

    }
    public void doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)	throws ServletException, IOException 
    {
		String requestUri = httpServletRequest.getRequestURI();
		String command = null;
		
		StringTokenizer st1 = new StringTokenizer(requestUri);
		while(st1.hasMoreTokens()){
			command = st1.nextToken("/");
		}

		System.out.println(command);
		
		BillController billController = BillController.getInstance();
		/*여기에 Controllr 를 설정하시오
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
				
		
		
		ControllerExcuteClass controll;
		ActionForward forward = null;
		
		if (command.matches("^\\S+.(bill)$")) {
			/*
			 * 위의 정규식을 이용하여 ^\\S.(guest)$ , ^\\S.(Realestate) 와 같이 입력하시오 
			 * 각 컨트롤러는 ControllerExcuteClass 를 구현합니다. implements ControllerExcuteClass
			 * 
			 * 
			 * */
			controll = billController;
			try {
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} /*else if ( command.equals("insertAction.do") ) {
			action = new InsertAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("listAction.do")) {
			action = new ListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("detail.do")) {
			action = new DetailAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("updateAction.do")) {
			action = new UpdateAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/

		if (forward != null) {
			if (forward.isRedirect()) {
				httpServletResponse.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(forward.getPath());
				dispatcher.forward(httpServletRequest, httpServletResponse);

			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
