package bill.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.model.BillService;
import bill.model.Personal_mgmt_ex;
import bill.model.setIdMonth;

public class getMonthBill implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, BillService service)	throws Exception {
		
		System.out.println("jhh");
		Date today =new Date();
		
		SimpleDateFormat sdf0;
		sdf0 = new SimpleDateFormat("yy-MM");
		System.out.println(sdf0.format(today));
		
		List<Personal_mgmt_ex>list = service.getMonthBill(new setIdMonth("dmsql123", sdf0.format(today)) );
		System.out.println("jhh");
		ActionForward actionForward = new ActionForward();
		request.setAttribute("list", list);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/haha.jsp");
	
			
		
		return actionForward;
	}

}
