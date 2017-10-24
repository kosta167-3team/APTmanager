package real_estate.mapper;

import java.util.List;

import real_estate.model.RealEstate_rent;
import real_estate.model.RealEstate_trade;

public interface RealEstateMapper {
	 public int insertRealEstate_Rent(RealEstate_rent real_rent);
	 public int deleteRealEstate_Rent(int rr_month);
	 public int insertRealEstate_Trade(RealEstate_trade real_trade);
	 public int deleteNRealEstate_Trade(int rt_month);
	 
	 public RealEstate_rent showMyAptRent();
	 public RealEstate_trade  showMyAptTrade();
	 
	 public List<RealEstate_rent> showMyAptRentAnnual();
	 public List<RealEstate_trade> showMyAptTradeAnnual();
}
