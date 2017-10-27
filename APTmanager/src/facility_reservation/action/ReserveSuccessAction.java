package facility_reservation.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.FacilityServiece;
import facility_reservation.model.Facility_reservation;

public class ReserveSuccessAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FacilityServiece service = FacilityServiece.getinstance();

		HttpSession session = request.getSession(false); 
		
		System.out.println(session);
		
		System.out.println("예약: 1");
		 
		String [] cnt ;
		cnt =request.getParameterValues("cnt");
		for(int i = 0 ; i<cnt.length ; i++){
			System.out.println(cnt[i]);
		}
		int fr_cnt = Integer.parseInt(cnt[0]);
		
		Integer f_id = (Integer) session.getAttribute("f_id"); 
		int t_id = (int) session.getAttribute("t_id"); 
		
		 //((Integer)(session.getAttribute("index"))).intValue()
/*		int f_id =  (Integer) session.getAttribute("f_id");
		int t_id =  Integer.valueOf((String)session.getAttribute("t_id"));*/
	//	Integer t_id = (Integer)(session.getAttribute("t_id"));
		// String r_id = (String) request.getAttribute("r_id");
		//Integer fr_cnt = Integer.parseInt( request.getParameter("fr_cnt"));
		Timestamp fr_date =    java.sql.Timestamp.valueOf((String)session.getAttribute("fr_date"));
/*		System.out.println("f_id" + f_id);
		System.out.println("t_id"+t_id);*/
		//System.out.println("cnt"+fr_cnt);
		//System.out.println("date"+fr_date); 
		
		System.out.println("예약: 2");
		
		 int re = service.insertReservation(new Facility_reservation(f_id, t_id, "dmsql123", fr_cnt, fr_date));
		System.out.println("예약: "+ re);
		 
		
		ActionForward actionForward = new ActionForward();
		if (re>0) {

			actionForward.setPath("/facility_reservation/6done.jsp");
			actionForward.setRedirect(false);
		} else {
			actionForward.setPath("/facility_reservation/7fail_double.jsp");
			actionForward.setRedirect(false);
		} 
		return actionForward;
	}

}
