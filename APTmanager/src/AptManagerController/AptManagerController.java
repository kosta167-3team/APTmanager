package AptManagerController;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facility_reservation.action.FacilityController;
import maintain_fees.action.BillController;

@WebServlet(urlPatterns = { "*.bill", "*.n_realEstate", "*.facility" })
public class AptManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AptManagerController() {

	}

	public void doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		System.out.println("컨트롤러");
		String requestUri = httpServletRequest.getRequestURI();
		String command = null;

		StringTokenizer st1 = new StringTokenizer(requestUri);
		while (st1.hasMoreTokens()) {
			command = st1.nextToken("/");
		}

		System.out.println(command);

		BillController billController = BillController.getInstance();
		
			//facility
		FacilityController facilityController = FacilityController.getInstance();
	 

		ControllerExcuteClass controll;
		ActionForward forward = null;

		if (command.matches("^\\S+.(bill)$")) {
			controll = billController;
			
			//facility
		}else if (command.matches("^\\S+.(facility)$")) {
			controll = facilityController;
			
			try {
			 	//컨트롤러 액션 익세큐트 ← 각 액션 클래스에서 지정해준 것
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	
		 
		 	//각 액션 클래스에서 지정해준 것
		if (forward != null) {
			if (forward.isRedirect()) {
				httpServletResponse.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(forward.getPath());
				dispatcher.forward(httpServletRequest, httpServletResponse);

			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

}
