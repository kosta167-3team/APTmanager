package facility_reservation.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.FacilityServiece;
import facility_reservation.model.Facility_reservation;

public class CountOptionAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		FacilityServiece service = FacilityServiece.getinstance();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		System.out.println("aaaa : "+ (Timestamp)session.getAttribute("fr_date"));
		Timestamp now = (Timestamp)session.getAttribute("fr_date"); // 형식을 지켜야 함
		//java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
		String t_id = request.getParameter("t_id");
		String f_id = (String)session.getAttribute("f_id");
		System.out.println("t_id = " + t_id);
		ActionForward actionForward = new ActionForward();
		Facility_reservation reservation = new Facility_reservation(Integer.parseInt(f_id), Integer.parseInt(t_id), "ㅇㅇㅇ", 1, now);

		Integer ok = service.checkDoubleBook(reservation);

		Integer spot = service.getSpot(new Facility_reservation(Integer.parseInt(f_id), Integer.parseInt(t_id), now));
		
		request.setAttribute("spot", spot);
		
		if (ok == null ) { 
			
			actionForward.setPath("../facility_reservation/5 count.jsp");
			actionForward.setRedirect(false);
			
		} else{
			
			actionForward.setPath("../facility_reservation/fail_double.jsp");
			actionForward.setRedirect(true);
		
		} 
		return actionForward;
	}

}
