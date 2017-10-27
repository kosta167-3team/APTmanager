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
		HttpSession session = request.getSession();
		
		request.setAttribute("fr_date",request.getParameter("fr_date"));
		
		System.out.println("TimeO"+(int)session.getAttribute("f_id"));
		
		
		int f_id = (int)session.getAttribute("f_id");
		//날짜
		Timestamp now = java.sql.Timestamp.valueOf(request.getParameter("fr_date")); // 형식을 지켜야 함
		
		session.setAttribute("fr_date", request.getParameter("fr_date"));
				
		List<Facility_time> timeTable = service.getTimetable();
	 
		
		 
		HashMap<String, Integer> hash = service.getRunningTime(f_id);
		
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

			if(close_id == 24){
				
			}
		//	Facility_reservation reservation = new Facility_reservation(Integer.parseInt(f_id), i, now);
			
			reservation.setF_id(f_id);
			reservation.setT_id(i);
			reservation.setFr_date(now);
			reservation.setFr_cnt(0);
			int spot = service.getSpot(reservation);
			
			map.put(reservation.getT_id(), spot);  

		}
		
		int f_cp = service.getDetail(f_id).getF_capa();
		request.setAttribute("map", map); 
		request.setAttribute("capa", f_cp); 
		System.out.println("fr_date : "+now); 
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/facility_reservation/4time.jsp");

		return actionForward;
	}

}
