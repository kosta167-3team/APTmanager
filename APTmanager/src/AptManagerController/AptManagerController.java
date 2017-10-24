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
import real_estate.action.RealEstateController;


@WebServlet(  urlPatterns = {"*.bill","*.guest","*.realEstate", "*.facility"}  )

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

		RealEstateController nreController = RealEstateController.getInstance();
		/*여기에 Controllr 를 설정하시오
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
			//facility
		FacilityController facilityController = FacilityController.getInstance();
	 

		ControllerExcuteClass controll;
		ActionForward forward = null;

		if (command.matches("^\\S+.(bill)$")) {
			controll = billController;
			try {
			 	//컨트롤러 액션 익세큐트 ← 각 액션 클래스에서 지정해준 것
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//facility
		}else if (command.matches("^\\S+.(facility)$")) {
			controll = facilityController;
			
			try {
			 	//컨트롤러 액션 익세큐트 ← 각 액션 클래스에서 지정해준 것
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	
		 
		 	//각 액션 클래스에서 지정해준 것

		} else if ( command.matches("^\\S+.(realEstate)$") ) {
			controll = nreController;
			System.out.println("실행 : " +command);
			try {
				forward = controll.doProcess(httpServletRequest, httpServletResponse, command);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} /*else if(command.equals("listAction.do")) {
			action = new ListAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("detail.do")) {
			action = new DetailAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("updateAction.do")) {
			action = new UpdateAction();
			try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		else{
			System.out.println("실패... command:" + command);
		}
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
