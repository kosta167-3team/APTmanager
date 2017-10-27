package resident.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AptManagerController.Action;
import AptManagerController.ActionForward;
import resident.model.Reservation;
import resident.model.ResidentService;
import sun.print.resources.serviceui;

public class SendPassImageAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResidentService residentService = ResidentService.getInstance();
		ActionForward forward = new ActionForward();
		Reservation reservation = new Reservation();
		request.setCharacterEncoding("utf-8");
		reservation = (Reservation)request.getSession().getAttribute("reservation");
		request.setAttribute("reservation", reservation);
		System.out.println("reservation r_id : "+ reservation.getR_id());
		int vr_id = residentService.getReservationId();
		String dong = Integer.toString(residentService.searchDong(reservation.getR_id()));
		String ho = Integer.toString(residentService.searchHo(reservation.getR_id()));
		
		System.out.println("동 : " + dong);
		System.out.println("호 : " + ho);
		if(vr_id != -1) {
			
			reservation.setVr_id(Integer.toString(vr_id));
			residentService.createReservation(reservation);
			forward.setPath("/resident/sendPassImage.jsp"); // 내가 갈곳	
			request.setAttribute("address", dong +"-"+ho );
		} else {
			forward.setPath("/resident/mainForm.jsp"); // 내가 갈곳
		}
		
		
		
		forward.setRedirect(false);
		return forward;
	}
}
