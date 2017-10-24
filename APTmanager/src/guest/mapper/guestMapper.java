package guest.mapper;

import java.util.List;

import guest.model.Guest;
import guest.model.GuestRe;

public interface guestMapper {
	List<Guest> selectedGuest(String date);
	int insertRe(GuestRe review);
	Integer getMaxRev_id();
	List<GuestRe> listRe(int f_id);
}
