package guest.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.GestureSupport;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import AptManagerController.ControllerExcuteClass;
import maintain_fees.action.CompareWidthAction;
import maintain_fees.action.getMonthBillAction;
import maintain_fees.action.getYearMonthBillAction;

public class GuestController implements ControllerExcuteClass {

	public GuestController() {	}
	
	public static GuestController guestController = new GuestController();
	
	public static GuestController getInstance(){
		return guestController;
	}
	@Override
	public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String commend) throws ServletException, IOException {
		ActionForward forward = null;
		Action action = null;
		
		if (commend.equals("nowGuest.guest")) {
			/* 媛� actionClass �뱾�� Action �겢�옒�뒪瑜� implements �븳�떎.*/
			action = new getGuestAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ( commend.equals("FaInsertReview.guest") ) {
			action = new FaInsertAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} /*else if(commend.equals("facilityReview.guest")) {
			action = new listReAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
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
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,	String commend) {
			try 
			{
				doProcess(httpServletRequest, httpServletResponse, commend);
			} 
			catch (ServletException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		return null;
	}

}
