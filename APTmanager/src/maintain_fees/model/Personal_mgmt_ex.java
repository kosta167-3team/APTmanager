package maintain_fees.model;

import java.io.Serializable;

public class Personal_mgmt_ex implements Serializable{
	private int input_num;
	private String p_month;
	private String u_id;
	private int general_mgmt;
	private int clean;
	private int fumigate;
	private int elevator_maintain;
	private int repair;
	private int long_term_repair;
	private int building_insurance;
	private int security;
	private int consignment;
	private int personal_elec;
	private int public_elec;
	private int tv;
	private int personal_water;
	private int personal_heat_water;
	private int trash_pick_up;
	private int resident_repre;
	private int emc;
	private String pay_check;
	
	public Personal_mgmt_ex(){};
	
	public Personal_mgmt_ex(int input_num, String p_month, String u_id, int general_mgmt, int clean, int fumigate,
			int elevator_maintain, int repair, int long_term_repair, int building_insurance, int security,
			int consignment, int personal_elec, int public_elec, int tv, int personal_water, int personal_heat_water,
			int trash_pick_up, int resident_repre, int emc, String pay_check) {
		super();
		this.input_num = input_num;
		this.p_month = p_month;
		this.u_id = u_id;
		this.general_mgmt = general_mgmt;
		this.clean = clean;
		this.fumigate = fumigate;
		this.elevator_maintain = elevator_maintain;
		this.repair = repair;
		this.long_term_repair = long_term_repair;
		this.building_insurance = building_insurance;
		this.security = security;
		this.consignment = consignment;
		this.personal_elec = personal_elec;
		this.public_elec = public_elec;
		this.tv = tv;
		this.personal_water = personal_water;
		this.personal_heat_water = personal_heat_water;
		this.trash_pick_up = trash_pick_up;
		this.resident_repre = resident_repre;
		this.emc = emc;
		this.pay_check = pay_check;
	}
	public int getInput_num() {
		return input_num;
	}
	public void setInput_num(int input_num) {
		this.input_num = input_num;
	}
	public String getP_month() {
		return p_month;
	}
	public void setP_month(String p_month) {
		this.p_month = p_month;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getGeneral_mgmt() {
		return general_mgmt;
	}
	public void setGeneral_mgmt(int general_mgmt) {
		this.general_mgmt = general_mgmt;
	}
	public int getClean() {
		return clean;
	}
	public void setClean(int clean) {
		this.clean = clean;
	}
	public int getFumigate() {
		return fumigate;
	}
	public void setFumigate(int fumigate) {
		this.fumigate = fumigate;
	}
	public int getElevator_maintain() {
		return elevator_maintain;
	}
	public void setElevator_maintain(int elevator_maintain) {
		this.elevator_maintain = elevator_maintain;
	}
	public int getRepair() {
		return repair;
	}
	public void setRepair(int repair) {
		this.repair = repair;
	}
	public int getLong_term_repair() {
		return long_term_repair;
	}
	public void setLong_term_repair(int long_term_repair) {
		this.long_term_repair = long_term_repair;
	}
	public int getBuilding_insurance() {
		return building_insurance;
	}
	public void setBuilding_insurance(int building_insurance) {
		this.building_insurance = building_insurance;
	}
	public int getSecurity() {
		return security;
	}
	public void setSecurity(int security) {
		this.security = security;
	}
	public int getConsignment() {
		return consignment;
	}
	public void setConsignment(int consignment) {
		this.consignment = consignment;
	}
	public int getPersonal_elec() {
		return personal_elec;
	}
	public void setPersonal_elec(int personal_elec) {
		this.personal_elec = personal_elec;
	}
	public int getPublic_elec() {
		return public_elec;
	}
	public void setPublic_elec(int public_elec) {
		this.public_elec = public_elec;
	}
	public int getTv() {
		return tv;
	}
	public void setTv(int tv) {
		this.tv = tv;
	}
	public int getPersonal_water() {
		return personal_water;
	}
	public void setPersonal_water(int personal_water) {
		this.personal_water = personal_water;
	}
	public int getPersonal_heat_water() {
		return personal_heat_water;
	}
	public void setPersonal_heat_water(int personal_heat_water) {
		this.personal_heat_water = personal_heat_water;
	}
	public int getTrash_pick_up() {
		return trash_pick_up;
	}
	public void setTrash_pick_up(int trash_pick_up) {
		this.trash_pick_up = trash_pick_up;
	}
	public int getResident_repre() {
		return resident_repre;
	}
	public void setResident_repre(int resident_repre) {
		this.resident_repre = resident_repre;
	}
	public int getEmc() {
		return emc;
	}
	public void setEmc(int emc) {
		this.emc = emc;
	}
	public String getPay_check() {
		return pay_check;
	}
	public void setPay_check(String pay_check) {
		this.pay_check = pay_check;
	}
	
	
	
	}
