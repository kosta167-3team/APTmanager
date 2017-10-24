package guest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import guest.model.GuestRe;
import guest.model.GuestService;

public class FaInsertAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GuestService service = GuestService.getInstance();
		GuestRe guestre = new GuestRe();
		
		guestre.setR_id(request.getParameter("R_id"));
		guestre.setRev_contents(request.getParameter("contents"));
		guestre.setF_id(Integer.parseInt(request.getParameter("f_id")) );
		guestre.setRev_id(service.getMaxRev_id());
		guestre.setRev_rate(Integer.parseInt(request.getParameter("rev_rate")) );
		System.out.println(guestre);
		service.insertRe(guestre);
		

		List<GuestRe> listRe = service.listRe(guestre.getF_id());   //후기리스트

		request.setAttribute("listRe", listRe);

		ActionForward actionForward = new ActionForward();

		actionForward.setRedirect(false);
		actionForward.setPath("/guest/facilityReview.jsp");

		return actionForward;
	}

}
