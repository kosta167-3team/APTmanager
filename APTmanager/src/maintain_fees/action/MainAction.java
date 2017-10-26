package maintain_fees.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import maintain_fees.model.BillService;
import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;
import resident.model.Resident;

public class MainAction implements Action {
	@Override
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)	throws Exception {
		
		BillService service = BillService.getInstance();
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR)-2000;
		int month = cal.get(Calendar.MONTH)+1;
		
		String nowYear = year+ "-" + month;
		
		HttpSession session = httpServletRequest.getSession();
		String r_id = (String)session.getAttribute("r_id");
		System.out.println(r_id);
		
		if( r_id == null){
			r_id = "a";
		}
		
		Personal_mgmt_ex personal_mgmt_ex = service.getMonthBill(new setIdMonth(r_id,nowYear));
		Resident resident = service.getResident(r_id);
		System.out.println(personal_mgmt_ex);
		
		httpServletRequest.setAttribute("personBill", personal_mgmt_ex);	
		httpServletRequest.setAttribute("resident", resident);
		System.out.println(resident);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/Main.jsp");
		return actionForward;
	}

}
