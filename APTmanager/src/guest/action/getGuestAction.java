package guest.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import guest.model.Guest;
import guest.model.GuestService;

public class getGuestAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GuestService service = GuestService.getInstance();
		Guest guest = new Guest();
		
		Date today = new Date();
		
		SimpleDateFormat today_format = new SimpleDateFormat("yy/MM/dd");
		String string_today = today_format.format(today);

		System.out.println(string_today);
		
		List<Guest> selected = service.selectedGuest(string_today);
		
		request.setAttribute("selected", selected);
		
		ActionForward actionForward = new ActionForward();
		
		actionForward.setRedirect(false);
		actionForward.setPath("/guest/nowGuest.jsp");
		
		
		return actionForward;
	}

}
