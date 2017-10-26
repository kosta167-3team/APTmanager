package resident.mapper;

import java.util.List;

import resident.model.Reservation;
import resident.model.Resident;

public interface ResidentMapper {
	public int getReservationId();
	public Resident login(String r_id);
	public int createReservation(Reservation reservation);
	public int deleteReservation(String vr_id);
	public List<Reservation> searchReservation(String r_id);
	public int getReservationCount(String r_id);
	public int searchDong(String r_id);
	public int searchHo(String r_id);
}
