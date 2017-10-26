package facility_reservation.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.FacilityServiece;
import facility_reservation.model.Facility_reservation;
import facility_reservation.model.Facility_time;

public class TimeOptionAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		// 1.시간 확인
		 
		FacilityServiece service = FacilityServiece.getinstance();
		//날짜
		Timestamp now = java.sql.Timestamp.valueOf(request.getParameter("date")); // 형식을 지켜야 함
				
				
		List<Facility_time> timeTable = service.getTimetable();
		HttpSession session = request.getSession();
		String f_id = (String)session.getAttribute("f_id");
		request.setAttribute("f_id", f_id);
		HashMap<String, Integer> hash = service.getRunningTime(1);

		// 시작하는 index
		Integer open_id = hash.get("open_id");

		// 끝내는 index
		Integer close_id = hash.get("close_id"); 
		request.setAttribute("open_id", open_id);
		request.setAttribute("close_id", close_id);
		request.setAttribute("timeTable", timeTable);

		// 2.인원 확인

		
	//	java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
 
		//reservation 객체 만들어서 
		Facility_reservation reservation = new Facility_reservation();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = open_id; i < close_id + 1; i++) {

		//	Facility_reservation reservation = new Facility_reservation(Integer.parseInt(f_id), i, now);
			
			reservation.setF_id(Integer.parseInt(f_id));
			reservation.setT_id(i);
			reservation.setFr_date(now);
			reservation.setFr_cnt(0);
			int spot = service.getSpot(reservation);
			
			map.put(reservation.getT_id(), spot);  

		}
		
		int f_cp = service.getDetail(Integer.parseInt(f_id)).getF_capa();
		request.setAttribute("map", map); 
		request.setAttribute("capa", f_cp); 
		System.out.println("fr_date : "+now);
		session.setAttribute("fr_date", now);
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/facility_reservation/4 time.jsp");

		return actionForward;
	}

}
