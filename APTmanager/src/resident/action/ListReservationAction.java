package resident.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.ListModel;
import resident.model.ResidentService;

public class ListReservationAction implements Action {
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();
		ListModel listModel = null;
		HttpSession session = request.getSession();
		String pageNum = (String)request.getAttribute("pageNum");
		if(pageNum == null) {
			pageNum = "0";
		}
		listModel = residentService.searchReservation((String)session.getAttribute("r_id"), Integer.parseInt(pageNum));
		request.setAttribute("listModel", listModel);
		forward.setPath("/resident/listReservation.jsp"); // 내가 갈곳
		forward.setRedirect(false);

		return forward;
	}
}