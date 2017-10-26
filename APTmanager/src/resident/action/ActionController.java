package resident.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import AptManagerController.ControllerExcuteClass;

public class ActionController implements ControllerExcuteClass {
	/* 각 컨트롤러는 ControllerExcuteClass를 implements한다. */
	private static ActionController actionController = new ActionController();

	public ActionController() {
		super();
	}

	public static ActionController getInstance() {
		return actionController;
	}

	public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String command) throws ServletException, IOException {

		ActionForward forward = null;
		Action action = null;

		if (command.equals("login.resident")) {
			/* 각 actionClass 들은 Action 클래스를 implements 한다. */
			action = new LoginAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("createReservationMenu.resident")) {
			action = new CreateReservationMenuAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("createReservation.resident")) {
			action = new CreateReservationAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("sendPassImage.resident")) {
			action = new SendPassImageAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("listReservation.resident")) {
			action = new ListReservationAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("deleteReservation.resident")) {
			action = new DeleteReservationAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("updateReservation.resident")) {
			action = new ListReservationAction();
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