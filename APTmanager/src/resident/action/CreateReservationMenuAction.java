package resident.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.ResidentService;

public class CreateReservationMenuAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      ResidentService residentService = ResidentService.getInstance();
	      ActionForward forward = new ActionForward();
	      request.setCharacterEncoding("utf-8");
	      HttpSession session = request.getSession();
	      
	      System.out.println("ha");
	      System.out.println("CreateReservationMenuAction " + (String)session.getAttribute("r_id"));
	      session.setAttribute("r_id", (String)session.getAttribute("r_id"));
	      if((String)session.getAttribute("r_id") == null) {
	         forward.setPath("/resident/loginForm.jsp");
	      } else {
	         forward.setPath("/resident/createReservationForm.jsp"); // 내가 갈곳
	      }
	      
	      forward.setRedirect(false);
	      return forward;
	   }

}