package resident.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.Reservation;
import resident.model.ResidentService;

public class DeleteReservationAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();

		String vr_id = (String)request.getParameter("vr_id");
		System.out.println(vr_id);
		residentService.deleteReservation(vr_id);
		forward.setPath("/listReservation.resident"); // 내가 갈곳	
		forward.setRedirect(false);
		return forward;
	}
}
