package resident.model;

import java.util.List;

public class ResidentService {
	private static ResidentService residentService = new ResidentService();
	static ResidentDao residentDao;
	private static final int PAGE_SIZE = 5;

	public static ResidentService getInstance() {
		residentDao = ResidentDao.getInstance();
		return residentService;
	}

	public ResidentService() {
	}

	public Resident selectResident(String r_id) {
		return residentDao.login(r_id);
	}

	public int getReservationId() {
		return residentDao.getReservationId() + 1;
	}

	public int createReservation(Reservation reservation) {
		return residentDao.createReservation(reservation);
	}
	public int deleteReservation(String vr_id) {
		return residentDao.deleteReservation(vr_id);
	}

	public ListModel searchReservation(String r_id, int requestPage) {
		// 페이지당 글갯수, 총글갯수, 총페이지수, 시작페이지, 마지막페이지, 현재페이지
		int totalCount = residentDao.getReservationCount(r_id);
		int totalPageCount = totalCount / PAGE_SIZE;
		if (totalCount % PAGE_SIZE > 0) {
			totalPageCount++;
		}

		int startPage = requestPage - (requestPage - 1) % 5;
		int endPage = startPage + 4;
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}

		int startRow = (requestPage - 1) * PAGE_SIZE;
		List<Reservation> list = residentDao.searchReservation(r_id, requestPage);

		return new ListModel(list, requestPage, totalPageCount, startPage, endPage);
	}
	
	public int searchDong(String r_id) {
		return residentDao.searchDong(r_id);
	}
	public int searchHo(String r_id) {
		return residentDao.searchHo(r_id);
	}
}
