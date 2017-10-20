package AptManagerController;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.action.GuestController;
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
		GuestController guestController = GuestController.getInstance();
		/*�뿬湲곗뿉 Controllr 瑜� �꽕�젙�븯�떆�삤
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
			 * �쐞�쓽 �젙洹쒖떇�쓣 �씠�슜�븯�뿬 ^\\S.(guest)$ , ^\\S.(Realestate) �� 媛숈씠 �엯�젰�븯�떆�삤 
			 * 媛� 而⑦듃濡ㅻ윭�뒗 ControllerExcuteClass 瑜� 援ы쁽�빀�땲�떎. implements ControllerExcuteClass
			 * 
			 * 
			 * */
			controll = billController;
			try {
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ( command.equals("^\\S+.(guest)$") ) {
			controll = guestController;
			try {
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} /*else if(command.equals("listAction.do")) {
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
