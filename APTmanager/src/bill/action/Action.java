package bill.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.action.ActionForward;
import bill.model.BillService;

public interface Action {
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, BillService service) throws Exception;
}
