package resident.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.ResidentService;

public class InsertMenuAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
	
		String r_id = (String)session.getAttribute("r_id");
		forward.setPath("/resident/createReservationForm.jsp"); // 내가 갈곳
		

		forward.setRedirect(false);
		return forward;
	}

}