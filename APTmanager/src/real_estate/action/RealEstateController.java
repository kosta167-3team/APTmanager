package real_estate.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import AptManagerController.ControllerExcuteClass;
import maintain_fees.action.CompareWidthAction;
import maintain_fees.action.getMonthBillAction;
import maintain_fees.action.getYearMonthBillAction;

public class RealEstateController implements ControllerExcuteClass{
	
	private static RealEstateController reController = new RealEstateController();
	
	public static RealEstateController getInstance(){
		return reController;
	}
	@Override
	public ActionForward excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String commend) {
		try 
		{
			return doProcess(httpServletRequest, httpServletResponse,commend);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ActionForward doProcess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String command) throws ServletException, IOException {
		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("inqRealEstate.realEstate")) {
			/* 각 actionClass 들은 Action 클래스를 implements 한다.*/
			action = new InqRealStateAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("xmlParser.realEstate")){ 
			action = new XMLParserAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("showRentList.realEstate")){
			action = new ShowMyAptPriceAction();
			try {
				forward = action.excute(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("command :" +command);
		}

		return forward;
	}
	
}
