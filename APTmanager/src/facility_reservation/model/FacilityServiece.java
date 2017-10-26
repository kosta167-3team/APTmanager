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
	
	public List<Facility> getFacilityList (){
		
		List<Facility> facilityList = new ArrayList<Facility>();
		
		facilityList = facilityDao.getFacilityList();
		
		return facilityList;
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

		System.out.println("f_id : "+reservation.getF_id());
		Facility facility = facilityDao.getDetail(reservation.getF_id());
		int f_capa = facility.getF_capa();
		System.out.println("qqqq");
		System.out.println("reservation_date" + reservation.getFr_date());
		int fr_cnt = facilityDao.getSpot(reservation);
		System.out.println("wwww");
		int spot = f_capa - fr_cnt;

		System.out.println("예약 가능 인원 확인=" + spot +"명");

		return spot;
	}

	public Integer checkDoubleBook(Facility_reservation reservation) {

		System.out.println("중복 예약 여부 확인=");
		
		FacilityDao facilityDao = FacilityDao.getinstance();
		
		Integer ok = facilityDao.checkDoubleBook(reservation);
	
		System.out.println(ok +"건" );
		return ok;
	}

	
	
	
	
}
