package facility_reservation.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.Facility;
import facility_reservation.model.FacilityServiece;

public class GetDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
		FacilityServiece service = FacilityServiece.getinstance();
		
		request.setCharacterEncoding("utf-8");
		
		//String f_id = (String)request.getParameter("f_id");
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		//Facility facility = service.getDetail(Integer.parseInt(f_id));
		Facility facility = service.getDetail(f_id);
		List<Timestamp> date = facility.Set_date();

		request.setAttribute("facility", facility);
		request.setAttribute("date", date);
		

	//	System.out.println("f_id = " + f_id);
		//HttpSession session = request.getSession(); 
		
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/facility_reservation/3 detail.jsp");

		return actionForward;  
	}

}
