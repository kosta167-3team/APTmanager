package facility_reservation.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import AptManagerController.ControllerExcuteClass;

public class FacilityController implements ControllerExcuteClass {

	private static FacilityController facilityController = new FacilityController();

	public FacilityController() {
		super();
	}

	public static FacilityController getInstance() {
		return facilityController;
	}

	@Override
	public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String command) throws ServletException, IOException {

		ActionForward forward = null;
		Action action = null;

		if (command.equals("detail.facility")) {

			action = new getDetailAction();

	 	}else if(command.equals("options.facility")){
			
			action = new getOptionsAction(); 
			
		}
		try {
			forward = action.excute(httpServletRequest, httpServletResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

	@Override
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String command) {
		// TODO Auto-generated method stub
		return null;
	}

}