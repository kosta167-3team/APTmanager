package resident.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.Reservation;
import resident.model.ResidentService;

public class CreateReservationAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();
		Reservation reservation = new Reservation();
		
		HttpSession session = request.getSession();
		session.setAttribute("r_id", (String)session.getAttribute("r_id"));

		reservation.setR_id((String)session.getAttribute("r_id"));
		reservation.setV_contents(request.getParameter("v_contents"));
		reservation.setV_name(request.getParameter("v_name"));
		reservation.setV_tel(request.getParameter("v_tel"));
		reservation.setVr_date(request.getParameter("vr_date"));
		int vr_id = residentService.getReservationId();
		System.out.println(reservation.toString());
		if(vr_id != -1) {
			
			reservation.setVr_id(Integer.toString(vr_id));
			System.out.println(vr_id);
			System.out.println(reservation.toString());
			residentService.createReservation(reservation);
			
			session.setAttribute("reservation", reservation);
			System.out.println(reservation.toString());
			forward.setPath("/resident/sendPassImage.resident"); // 내가 갈곳	
			
			request.setAttribute("reservation", reservation);
		} else {
			forward.setPath("/resident/loginForm.jsp"); // 내가 갈곳
		}
		
		
		
		forward.setRedirect(false);
		return forward;
	}
}
