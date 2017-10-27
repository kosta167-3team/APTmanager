package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import maintain_fees.model.BillService;
import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;

public class CompareWidthAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BillService service = BillService.getInstance();
		
		Date today = new Date();
		SimpleDateFormat year_format = new SimpleDateFormat("yy");

		String year = year_format.format(today);
		Calendar cal = Calendar.getInstance();
		
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		
		HttpSession session = request.getSession();
		String r_id = (String)session.getAttribute("r_id");
		
		if( r_id == null){
			r_id = "a";
		}
		
		Personal_mgmt_ex me = service.getMonthBill(new setIdMonth(r_id,year + "-" + month));
		System.out.println(me);
		
		List<Personal_mgmt_ex> list = service.getWidthBill(me.getWidth());
		Double All_sum =0.0;
		Double average = 0.0;
		int count=0;
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i) );
			All_sum += Double.valueOf(list.get(i).allBill());
			count = i;
		}
		average = All_sum / count;
		
		Double result = Double.valueOf(me.allBill()/17) - average/17;
		
		
		
		request.setAttribute("me", Double.valueOf(me.allBill()/17));
		request.setAttribute("average", average/17);
		request.setAttribute("result", result);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/maintain_fees/width.jsp");
		
		
		return actionForward;
	}

}
