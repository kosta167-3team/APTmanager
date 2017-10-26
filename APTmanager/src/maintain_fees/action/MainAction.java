package maintain_fees.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		Personal_mgmt_ex personal_mgmt_ex = service.getMonthBill(new setIdMonth("dmsql123",nowYear));
		Resident resident = service.getResident("dmsql123");
		
		
		httpServletRequest.setAttribute("personBill", personal_mgmt_ex);	
		httpServletRequest.setAttribute("resident", resident);
		System.out.println(resident);
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/Main.jsp");
		return actionForward;
	}

}
