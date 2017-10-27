package facility_reservation.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import facility_reservation.action.FacilityController;

public class FacilityServiece {

	public static FacilityServiece service = new FacilityServiece();
	public static FacilityDao facilityDao;

	public static FacilityServiece getinstance() {

		facilityDao = FacilityDao.getinstance();
		return service;
	}

	public List<Facility> getFacilityList() {

		return facilityDao.getFacilityList();
	}

	public Facility getDetail(int f_id) {

		return facilityDao.getDetail(f_id);
	}

	public List<Facility_time> getTimetable() {

		return facilityDao.getTimetable();
	}

	public HashMap<String, Integer> getRunningTime(int f_id) {

		System.out.println("운영시간 확인");

		Facility facility = facilityDao.getDetail(f_id);
		List<Facility_time> timeTable = facilityDao.getTimetable();

		HashMap<String, Integer> runningTimeId = new HashMap<String, Integer>();

		for (int i = 0; i < timeTable.size(); i++) {

			if (timeTable.get(i).getT_start().equals(facility.getF_open())) {

				runningTimeId.put("open_id", timeTable.get(i).getT_id());

			}
			if (timeTable.get(i).getT_end().equals(facility.getF_close())) {

				runningTimeId.put("close_id", timeTable.get(i).getT_id());
			}

		}
		return runningTimeId;
	}

	public int getSpot(Facility_reservation reservation) {

		System.out.println("예약 가능 인원 확인=");

		Facility facility = facilityDao.getDetail(reservation.getF_id());
		int f_capa = facility.getF_capa();

		int fr_cnt = facilityDao.getSpot(reservation);

		int spot = f_capa - fr_cnt;

		System.out.println(spot + "명");

		return spot;
	}

	public Integer checkDoubleBook(Facility_reservation reservation) {

		System.out.println("중복 예약 여부 확인=");

		Integer ok = facilityDao.checkDoubleBook(reservation);

		System.out.println(ok + "건");

		return ok;
	}

	public int insertReservation(Facility_reservation reservation) {

		return facilityDao.insertReservation(reservation);
	}

}
