package bill.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.model.BillService;
import bill.action.Action;
import bill.action.ActionForward;
import bill.action.getMonthBill;


@WebServlet("*.bill")
public class BillController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public BillController() {
        super();
    }
    public void doProcess(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
    {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestUri.substring(contextPath.length() + 1);
		BillService service = BillService.getInstance();	
		
		System.out.println(command);

		ActionForward forward = null;
		Action action = null;

		if (command.equals("haha.bill")) {
			action = new getMonthBill();
			try {
				forward = action.excute(request, response,service);
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
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

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
