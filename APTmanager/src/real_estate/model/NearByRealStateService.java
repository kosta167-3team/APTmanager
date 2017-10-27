package real_estate.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class NearByRealStateService {
	RealEstateDAO rDao = RealEstateDAO.getInstance();
	private static NearByRealStateService service = new NearByRealStateService();
	// private static BoardDao dao;
	// 페이징처리할 한페이지당 글 갯수
	// private static final int PAGE_SIZE = 2;

	public NearByRealStateService() {
	}

	// 객체간의 의존 관계
	// service객체는 DAO 객체를 가지고 있어야 한다.
	public static NearByRealStateService getInstance() {
		// dao = BoardDao.getInstance();
		return service;
	}

	// 전월세 API
	public void inqRealEstateRentApiService(HttpServletRequest request, String date) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=pmqdGOgIO64BfpKzKRzwW5SBXPyaqD9rn6I5GRHSiiwNZTcQEurKQotrwONTQkGXUKBgMwVWJaNKM5udCe5zOA%3D%3D"); /*
																													 * Service
																													 * Key
																													 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode("11680", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(date, "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		// File("C:\\JAVA\\workspace\\project\\RealEstate\\WebContent\\RealEstate\\xmlFiles\\monthChartset.xml");

		String path2 = request.getRealPath("RealEstate/xmlFiles");
		System.out.println("path2: " + path2);

		String path3 = path2 + "/monthRent.xml";

		BufferedWriter bw = new BufferedWriter(new FileWriter(path3));

		String str = null;
		while ((str = rd.readLine()) != null) {
			bw.write(str);
		}

		rd.close();
		conn.disconnect();
		bw.close();
	}

	// 매매 API
	public void InqRealEstateTradeApiService(HttpServletRequest request, String date) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=pmqdGOgIO64BfpKzKRzwW5SBXPyaqD9rn6I5GRHSiiwNZTcQEurKQotrwONTQkGXUKBgMwVWJaNKM5udCe5zOA%3D%3D"); /*
																													 * Service
																													 * Key
																													 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode("11680", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(date, "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		String path = request.getRealPath("RealEstate/xmlFiles");
		System.out.println("path: " + path);

		String path3 = path + "/monthTrade.xml";

		BufferedWriter bw = new BufferedWriter(new FileWriter(path3));

		String str = null;
		while ((str = rd.readLine()) != null) {
			bw.write(str);
		}

		rd.close();
		conn.disconnect();
		bw.close();
	}

	// 처음에 1년 데이터를 전세 DB에 넣어주기 위한 작업
	public void RepeatInqRealEstateRentApiService(HttpServletRequest request, String date, int index) throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=pmqdGOgIO64BfpKzKRzwW5SBXPyaqD9rn6I5GRHSiiwNZTcQEurKQotrwONTQkGXUKBgMwVWJaNKM5udCe5zOA%3D%3D"); /*
																													 * Service
																													 * Key
																													 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode("11680", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(date, "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		// File("C:\\JAVA\\workspace\\project\\RealEstate\\WebContent\\RealEstate\\xmlFiles\\monthChartset.xml");

		String path = request.getRealPath("RealEstate/xmlFiles");
		System.out.println("path: " + path);

		String path3 = path + "/monthRent" + index + ".xml";

		BufferedWriter bw = new BufferedWriter(new FileWriter(path3));

		String str = null;
		while ((str = rd.readLine()) != null) {
			bw.write(str);
		}

		rd.close();
		conn.disconnect();
		bw.close();
	}

	// 처음에 1년 데이터를 매매DB에 넣어주기 위한 작업
	public void RepeatInqRealEstateTradeApiService(HttpServletRequest request, String date, int index)
			throws Exception {
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=pmqdGOgIO64BfpKzKRzwW5SBXPyaqD9rn6I5GRHSiiwNZTcQEurKQotrwONTQkGXUKBgMwVWJaNKM5udCe5zOA%3D%3D"); /*
																													 * Service
																													 * Key
																													 */
		urlBuilder.append("&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "="
				+ URLEncoder.encode("11680", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode(date, "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		String path = request.getRealPath("RealEstate/xmlFiles");
		System.out.println("path: " + path);

		String path3 = path + "/monthTrade" + index + ".xml";

		BufferedWriter bw = new BufferedWriter(new FileWriter(path3));

		String str = null;
		while ((str = rd.readLine()) != null) {
			bw.write(str);
		}

		rd.close();
		conn.disconnect();
		bw.close();
	}

	// xml 파일 파싱~
	public void XMLParserService(HttpServletRequest request) {

		String Folderpath = request.getRealPath("RealEstate/xmlFiles");
		System.out.println("path2: " + Folderpath);

		String day = (String) request.getAttribute("day");

		// 처음에만 하는 설정

		/*
		 * for (int i = 1; i <= 12; i++) { String rentPath = Folderpath +
		 * "/monthRent"+i+".xml"; ReadRentXMLFile(rentPath, day);
		 * 
		 * String tradePath = Folderpath + "/monthTrade"+i+".xml";
		 * ReadTradeXMLFile(tradePath, day); }
		 */

		String rentPath = Folderpath + "/monthRent.xml";
		ReadRentXMLFile(rentPath, day);

		String tradePath = Folderpath + "/monthTrade.xml";
		ReadTradeXMLFile(tradePath, day);

	}

	// 전세 XML 파일 -> 객체 -> DB
	public void ReadRentXMLFile(String path, String day) {

		String searchDay = "^" + day + "*";
		Pattern p = Pattern.compile(searchDay);
		Matcher m = null;
		try {

			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					m = p.matcher(getTagValue("월", eElement).trim());

					if (getTagValue("법정동", eElement).trim().equals("삼성동")) {
						if (m.find()) {
							if (getTagValue("월세금액", eElement).trim().equals("0")) {

								String a_name = getTagValue("아파트", eElement).trim();

								int rr_year = Integer.parseInt(getTagValue("년", eElement).trim());
								int rr_month = Integer.parseInt(getTagValue("월", eElement).trim());

								String str_deposit = getTagValue("보증금액", eElement).replaceAll("[^0-9]", "");
								int rr_deposit = Integer.parseInt(str_deposit);

								String str_m_price = getTagValue("월세금액", eElement).replaceAll("[^0-9]", "");
								int rr_m_price = Integer.parseInt(str_m_price);

								int rr_area = (int) Double.parseDouble(getTagValue("전용면적", eElement).trim());

								RealEstate_rent rr = new RealEstate_rent(a_name, rr_year, rr_month, rr_deposit,
										rr_m_price, rr_area);

								rDao.insertRealEstate_Rent(rr);

								// rent_list.add(rr);
							}
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 매매 XML 파일 -> 객체 -> DB
	public void ReadTradeXMLFile(String path, String day) {

		String searchDay = "^" + day + "*";
		Pattern p = Pattern.compile(searchDay);
		Matcher m = null;
		try {

			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					m = p.matcher(getTagValue("월", eElement).trim());

					if (getTagValue("법정동", eElement).trim().equals("삼성동")) {
						if (m.find()) {

							String a_name = getTagValue("아파트", eElement).trim();

							int rt_year = Integer.parseInt(getTagValue("년", eElement).trim());
							int rt_month = Integer.parseInt(getTagValue("월", eElement).trim());

							String str_price = getTagValue("거래금액", eElement).replaceAll("[^0-9]", "");
							int rt_price = Integer.parseInt(str_price);

							int rt_area = (int) Double.parseDouble(getTagValue("전용면적", eElement).trim());

							RealEstate_trade real_trade = new RealEstate_trade(a_name, rt_year, rt_month, rt_price,
									rt_area);

							System.out.println(real_trade.toString());
							rDao.insertRealEstate_Trade(real_trade);

							// rent_list.add(rr);
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

	// 오래된달의 전세 내역 지우기
	public void deleteOldestRealStateService(int month) {

		rDao.deleteOldestRealEstate(month);
	}

	// 삼성동 힐스테이트 1단지 지난달 전세
	public RealEstate_rent showMyAptRentService() {

		return rDao.showMyAptRent();

	}

	// 삼성동 힐스테이트 1단지 지난달 매매
	public RealEstate_trade showMyAptTradeService() {

		return rDao.showMyAptTrade();

	}

	// 내 아파트 매년 전세 내역
	public List<RealEstate_rent> showMyAptRentAnnualService() {

		return rDao.showMyAptRentAnnual();

	}

	// 내 아파트 매년 매매 내역
	public List<RealEstate_trade> showMyAptTradeAnnualService() {

		return rDao.showMyAptTradeAnnual();

	}

}
