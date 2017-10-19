package maintain_fees.action;


import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import AptManagerController.ControllerExcuteClass;

public class BillController implements ControllerExcuteClass
{	
	private static BillController billController = new BillController();
	
    public BillController() {
        super();
    }
    public static BillController getInstance(){
    	return billController;
    }
    
    public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String command)	throws ServletException, IOException 
    {
		/*String requestUri = httpServletRequest.getRequestURI();
		String contextPath = httpServletRequest.getContextPath();
		String command = requestUri.substring(contextPath.length() + 1);
		
		System.out.println(command);*/

		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("haha32123.bill")) {
			action = new getMonthBill();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
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

		return forward;
	}
	@Override
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String commend) 
	{	
		try 
		{
			return doProcess(httpServletRequest, httpServletResponse,commend);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
}
