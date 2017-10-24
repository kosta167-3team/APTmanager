package real_estate.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import real_estate.model.NearByRealStateService;
import real_estate.model.RealEstate_rent;


public class XMLParserAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forword = new ActionForward();
		NearByRealStateService service = NearByRealStateService.getInstance();
		
		service.XMLParserService(request);
		
		forword.setRedirect(false);
		forword.setPath("showRentList.realEstate");
		
		
		return forword;
	}

}
