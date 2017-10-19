package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import maintain_fees.model.BillService;
import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;

public class getYearMonthBillAction implements Action {

	public getYearMonthBillAction(){}
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BillService service = BillService.getInstance();
		
		Date today = new Date();
		Personal_mgmt_ex compare = new Personal_mgmt_ex();
		SimpleDateFormat year_format = new SimpleDateFormat("yy");

		
		String now_year = year_format.format(today);		
		String before_year = String.valueOf(Integer.parseInt(now_year)-1);
		
		Calendar cal = Calendar.getInstance();
		
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		System.out.println(now_year + " " + before_year);
		System.out.println(now_year + "-" + month + " " + before_year + "-" + month);
		Personal_mgmt_ex now = service.getMonthBill(new setIdMonth("dmsql123", now_year + "-" + month) );

		Personal_mgmt_ex before = service.getMonthBill(new setIdMonth("dmsql123", before_year + "-" + month ) );		
		
		request.setAttribute("Personal_mgmt_ex", now);
		request.setAttribute("compare", before);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/maintain_fees/yearMonth.jsp");
		return actionForward;
	}

}
