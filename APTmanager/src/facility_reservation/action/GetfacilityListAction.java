package facility_reservation.action;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import facility_reservation.model.Facility;
import facility_reservation.model.FacilityServiece;

public class GetfacilityListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
		
		FacilityServiece service = FacilityServiece.getinstance();
		
		List<Facility> facilityList = new ArrayList<Facility>();
		
		facilityList = service.getFacilityList(); 
		
		request.setAttribute("list", facilityList);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/facility_reservation/2 list.jsp");
		
		return actionForward;
	}

}
