package real_estate.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import real_estate.model.RealStateService;
import real_estate.model.RealEstate_Area;
import real_estate.model.RealEstate_rent;
import real_estate.model.RealEstate_trade;

public class ShowMyAptPriceAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		RealStateService service = RealStateService.getInstance();
		
		RealEstate_rent lastMonthRent = service.showMyAptRentService();
		List<RealEstate_rent> annualRentList = service.showMyAptRentAnnualService();
		
		RealEstate_trade lastMonthTrade = service.showMyAptTradeService();
		List<RealEstate_trade> annualTradeList = service.showMyAptTradeAnnualService();
		
		List<RealEstate_Area> catAreaList = service.showMyAptCatAreaService();
		
		request.setAttribute("lastMonthRent", lastMonthRent);
		request.setAttribute("lastMonthTrade", lastMonthTrade);
		request.setAttribute("annualRent", annualRentList);
		request.setAttribute("annualTrade", annualTradeList);
		request.setAttribute("catArea", catAreaList);
		
		forward.setRedirect(false);
		//forward.setPath("/RealEstate/NewFile1.jsp");
		forward.setPath("/RealEstate/realEstate.jsp");
		//forward.setPath("/RealEstate/cat_area.jsp");
		
		return forward;
	}

}
