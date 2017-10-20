package guest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;

public class TestAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		int test = 0;
		request.setAttribute("test", test);
		
		ActionForward actionForward = new ActionForward();
		
		actionForward.setRedirect(false);
		actionForward.setPath("/guest/haha32123.jsp");
			
		return actionForward;
	}

}
