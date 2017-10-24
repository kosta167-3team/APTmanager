package resident.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.Reservation;
import resident.model.ResidentService;

public class SendPassImageAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();
		Reservation reservation = new Reservation();
		
		request.setCharacterEncoding("utf-8");
		reservation = (Reservation)request.getSession().getAttribute("reservation");
		request.setAttribute("reservation", reservation);
		int vr_id = residentService.getReservationId();
		System.out.println(reservation.toString());
		if(vr_id != -1) {
			
			reservation.setVr_id(Integer.toString(vr_id));
			System.out.println(vr_id);
			System.out.println(reservation.toString());
			residentService.createReservation(reservation);
			forward.setPath("/resident/sendPassImage.jsp"); // 내가 갈곳	
			request.setAttribute("reservation", reservation);
		} else {
			forward.setPath("/resident/.jsp"); // 내가 갈곳
		}
		
		
		
		forward.setRedirect(false);
		return forward;
	}
}
