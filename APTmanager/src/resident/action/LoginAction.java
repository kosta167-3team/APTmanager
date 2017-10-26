package resident.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.ResidentService;

public class LoginAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String r_id = request.getParameter("r_id");
		String r_pw = request.getParameter("r_pw");
		
		if(residentService.selectResident(r_id) != null &&
				residentService.selectResident(r_id).getR_pw().equals(r_pw)){
			session.setAttribute("r_id", request.getParameter("r_id"));
			forward.setPath("/resident/mainForm.jsp"); // 내가 갈곳	
			request.setAttribute("resident", residentService.selectResident(r_id));
		} else {
			forward.setPath("/resident/loginForm.jsp"); // 내가 갈곳
		}
		
		
		
		forward.setRedirect(false);
		return forward;
	}

}
