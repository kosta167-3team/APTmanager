package maintain_fees.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import maintain_fees.model.BillService;
import maintain_fees.model.Personal_mgmt_ex;
import maintain_fees.model.setIdMonth;

public class getMonthBill implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response )	throws Exception {
		
		
		BillService service = BillService.getInstance();

		Date today =new Date();
		
		SimpleDateFormat sdf0;
		sdf0 = new SimpleDateFormat("yy-MM");
		System.out.println(sdf0.format(today));
		
		List<Personal_mgmt_ex>list = service.getMonthBill(new setIdMonth("dmsql123", sdf0.format(today)) );

		ActionForward actionForward = new ActionForward();
		request.setAttribute("list", list);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/maintain_fees/haha32123.jsp");
	
			
		
		return actionForward;
	}

}
