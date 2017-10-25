package facility_reservation.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.Facility;
import facility_reservation.model.FacilityServiece;

public class getDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		
		//service 객체 불러서 처리
		FacilityServiece service = FacilityServiece.getinstance();  
		
		Facility facility = service.getDetail(1);
		List<Timestamp> date = facility.Set_date();
		
		request.setAttribute("facility", facility);
		request.setAttribute("date", date);
		
		//actionforward 
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/facility_reservation/facility.jsp");
		
		return actionForward; //액션포워드 리턴
	}

}
