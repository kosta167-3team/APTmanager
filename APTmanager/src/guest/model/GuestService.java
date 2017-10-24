package guest.model;

import java.util.List;

public class GuestService {
	private static GuestService service = new GuestService();
	private static GuestDao guestDao;

	public static GuestService getInstance() {
		guestDao = GuestDao.getInstance();

		return service;
	}
	
	public List<Guest> selectedGuest(String date){
		return guestDao.selectedGuest(date);
		
	}
	
	public int insertRe(GuestRe review){
		return guestDao.insertRe(review);
	}
	public int getMaxRev_id(){
		return guestDao.getMaxRev_id();
	}
	
	public List<GuestRe> listRe(int f_id){
		return guestDao.listRe(f_id);
	}
}
