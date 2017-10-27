package facility_reservation.mapper;
 
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import facility_reservation.model.Facility;
import facility_reservation.model.Facility_reservation;
import facility_reservation.model.Facility_time;

public interface FacilityMapper {
	List<Facility> getFacilityList();
	Facility getDetail (int f_id);
	List<Facility_time> getTimetable();
	Integer getSpot (Facility_reservation reservation);
 	Integer checkDoubleBook (Facility_reservation reservation); 
 	int insertReservation (Facility_reservation reservation);
}
