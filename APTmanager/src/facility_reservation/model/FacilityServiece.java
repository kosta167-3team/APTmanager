package facility_reservation.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacilityServiece {

	public static FacilityServiece service = new FacilityServiece();
	public static FacilityDao facilityDao;

	public static FacilityServiece getinstance() {

		facilityDao = FacilityDao.getinstance();
		return service;
	}

	public Facility getDetail(int f_id) {
		Facility facility = facilityDao.getDetail(f_id);
		return facility;
	}

	public List<Facility_time> getTimetable() {
		List<Facility_time> timeTable = facilityDao.getTimetable();

		return timeTable;
	}

	public HashMap<String, Integer> getRunningTime(int f_id) {

		Facility facility = facilityDao.getDetail(f_id);
		List<Facility_time> timeTable = facilityDao.getTimetable();
		HashMap<String, Integer> runningTimeId = new HashMap<String, Integer>();

		for (int i = 0; i < timeTable.size(); i++) {

			if (timeTable.get(i).getT_start().equals(facility.getF_open())) {

				runningTimeId.put("open_id", timeTable.get(i).getT_id());
				System.out.println(timeTable.get(i).getT_id());

			}
			if (timeTable.get(i).getT_end().equals(facility.getF_close())) {

				runningTimeId.put("close_id", timeTable.get(i).getT_id());
				System.out.println(timeTable.get(i).getT_id());
			}

		}
		System.out.println(runningTimeId);
		return runningTimeId;
	}

	public int getSpot(Facility_reservation reservation) {

		Facility facility = facilityDao.getDetail(reservation.getF_id());
		int f_capa = facility.getF_capa();
		System.out.println("시설 수용" + f_capa);
		
		int fr_cnt = facilityDao.getSpot(reservation);
		System.out.println("예약 인원" + fr_cnt);
		
		int spot = f_capa - fr_cnt;
		System.out.println("스팟" + spot);
		
		return spot;
	}
}
