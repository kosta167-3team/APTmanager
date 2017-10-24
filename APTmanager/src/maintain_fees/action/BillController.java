package maintain_fees.action;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import AptManagerController.ControllerExcuteClass;

public class BillController implements ControllerExcuteClass {
	/* 각 컨트롤러는 ControllerExcuteClass를 implements한다. */
	private static BillController billController = new BillController();

	public BillController() {
		super();
	}

	public static BillController getInstance() {
		return billController;
	}

	public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String command) throws ServletException, IOException {
		/*
		 * String requestUri = httpServletRequest.getRequestURI(); String
		 * contextPath = httpServletRequest.getContextPath(); String command =
		 * requestUri.substring(contextPath.length() + 1);
		 * 
		 * System.out.println(command);
		 */

		ActionForward forward = null;
		Action action = null;

		if (command.equals("month.bill")) {
			/* 각 actionClass 들은 Action 클래스를 implements 한다. */
			action = new getMonthBillAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("yearMonth.bill")) {
			action = new getYearMonthBillAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("width.bill")) {
			action = new CompareWidthAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}

		 

		} else if(command.equals("year.bill")) {
			action = new AllYearAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("energy.bill")) {
			action = new EnergyAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return forward;
	}

	@Override
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String commend) {
		try {
			return doProcess(httpServletRequest, httpServletResponse, commend);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
