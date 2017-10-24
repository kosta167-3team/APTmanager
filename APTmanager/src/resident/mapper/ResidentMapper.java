package resident.mapper;

import java.util.List;

import resident.model.Reservation;
import resident.model.Resident;

public interface ResidentMapper {
	public int getReservationId();
	public Resident login(String r_id);
	public int createReservation(Reservation reservation);
	public List<Reservation> searchReservation(String r_id);
	public int getReservationCount(String r_id);
}
