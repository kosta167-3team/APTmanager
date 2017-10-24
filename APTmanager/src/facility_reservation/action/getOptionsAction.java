package facility_reservation.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.FacilityServiece;
import facility_reservation.model.Facility_reservation;
import facility_reservation.model.Facility_time;

public class getOptionsAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1.시간 확인
		FacilityServiece service = FacilityServiece.getinstance();

		List<Facility_time> timeTable = service.getTimetable();

		HashMap<String, Integer> hash = service.getRunningTime(1);

		// 시작하는 index
		Integer open_id = hash.get("open_id");

		// 끝내는 index
		Integer close_id = hash.get("close_id");

		System.out.println(open_id + " " + close_id + " Action");

		request.setAttribute("open_id", open_id);
		request.setAttribute("close_id", close_id);
		request.setAttribute("timeTable", timeTable);

		// 2.인원 확인

		//날짜
		String now = "2017-10-25 10:20:30"; // 형식을 지켜야 함
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(now);
 
		//reservation 객체 만들어서 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = open_id; i < close_id + 1; i++) {

			Facility_reservation reservation = new Facility_reservation(1, i, t);

			int spot = service.getSpot(reservation);
			map.put(reservation.getT_id(), spot);  

		}
		
		int f_cp = service.getDetail(1).getF_capa();
		request.setAttribute("map", map); 
		request.setAttribute("capa", f_cp); 

		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/facility_reservation/options.jsp");

		return actionForward;
	}

}
