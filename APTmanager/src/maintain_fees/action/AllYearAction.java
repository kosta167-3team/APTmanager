package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class AllYearAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BillService service = BillService.getInstance();

		List<Personal_mgmt_ex> allYear = new ArrayList<Personal_mgmt_ex>();
		Calendar cal = Calendar.getInstance();
		
		int int_before_year = cal.get(Calendar.YEAR)-2001;
		int int_now_month = cal.get(Calendar.MONTH)+1;
		
		for( int i =0; i < 13; i++){
			String date = int_before_year + "-" +int_now_month;
			if( int_now_month == 13){
				int_now_month = 1;
				int_before_year ++;
			}
			
			Personal_mgmt_ex now = service.getMonthBill(new setIdMonth("dmsql123", date) );
			System.out.println(now + " " + date);
			allYear.add(now);			
			int_now_month++;
		}		
		
		ActionForward actionForward = new ActionForward();
		
		request.setAttribute("allYearList",allYear);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/maintain_fees/year.jsp");
			
		return actionForward;
	}

}
