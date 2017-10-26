package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import maintain_fees.model.BillService;
import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;

public class getMonthBillAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response )	throws Exception {
		
		
		BillService service = BillService.getInstance();

		Date today = new Date();                   
		Personal_mgmt_ex compare = new Personal_mgmt_ex();
		SimpleDateFormat year_format = new SimpleDateFormat("yy");

		String year = year_format.format(today);
		Calendar cal = Calendar.getInstance();
		
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		String beforeMonth = String.valueOf(cal.get(Calendar.MONTH));
		System.out.println(year + "-" + month);
		System.out.println(year + "-" + beforeMonth);
		
		Personal_mgmt_ex now = service.getMonthBill(new setIdMonth("dmsql123", year + "-" + month) );

		Personal_mgmt_ex before = service.getMonthBill(new setIdMonth("dmsql123", year + "-" + beforeMonth ) );
		
		System.out.println(now + "\n" + before);
		compare.compareSet(now, before);
		
		System.out.println(compare);
		ActionForward actionForward = new ActionForward();
		
		request.setAttribute("Personal_mgmt_ex", now);
		request.setAttribute("compare", compare);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/maintain_fees/monthBill.jsp");
			
		return actionForward;
	}

}
