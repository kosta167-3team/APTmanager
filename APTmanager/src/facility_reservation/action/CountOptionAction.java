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
		
		 request.setAttribute("t_id",request.getParameter("t_id"));
		
		 HttpSession session = request.getSession();
		 
		Timestamp now = java.sql.Timestamp.valueOf((String)session.getAttribute("fr_date")); // 형식을 지켜야 함
		//java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
		
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		
		session.setAttribute("t_id", t_id);
		Integer f_id = (Integer) session.getAttribute("f_id");
		
		System.out.println("t_id = " + t_id);
		ActionForward actionForward = new ActionForward();
		
		Facility_reservation reservation = new Facility_reservation(f_id, t_id, "ㅇㅇㅇ", 1, now);

		Integer ok = service.checkDoubleBook(reservation);

		Integer spot = service.getSpot(new Facility_reservation(f_id, t_id, now));
		
		request.setAttribute("spot", spot);
		request.setAttribute("t_id", t_id);
		
		if (ok == null ) { 
			
			actionForward.setPath("../facility_reservation/5count.jsp");
			actionForward.setRedirect(false);
			
		} else{
			
			actionForward.setPath("../facility_reservation/fail_double.jsp");
			actionForward.setRedirect(false);
		
		} 
		return actionForward;
	}

}
