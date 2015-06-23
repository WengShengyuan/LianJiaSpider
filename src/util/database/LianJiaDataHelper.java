package util.database;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import main.metadata.metadata.LianJiaHouse;

public class LianJiaDataHelper {

	static String tableName = "lianjia_table";
	static String houseIdCol = "house_id";
	static String houseTitleCol = "house_title";
	static String houseLocationCol = "house_location";
	static String houseRoomCol = "house_room";
	static String houseAreaCol = "house_area";
	static String houseDirectionCol = "house_direction";
	static String housePriceCol = "house_price";
	static String pricePerSquareCol = "price_per_square";
	static String houseURLCol = "house_url";
	static String regionURLCol = "region_url";
	static String isDownCol = "is_down";
	static String createDateCol = "create_date";

	Connection con = null;

	public boolean saveHouse(LianJiaHouse house) throws Exception {

		String insertSql = String
				.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s')",
						tableName, 
						houseIdCol, houseTitleCol, houseLocationCol,
						houseRoomCol, houseAreaCol, houseDirectionCol,
						housePriceCol, pricePerSquareCol, houseURLCol,
						regionURLCol, isDownCol, createDateCol, 
						house.getHouseId(),
						house.getHouseTitle(), house.getHouseLocation(),
						house.getHouseRoom(), house.getHouseArea(),
						house.getHouseDirection(), house.getHousePrice(),
						house.getPricePerSquare(), house.getHouseURL(),
						house.getRegionURL(), (house.isDown() ? 1 : 0),
						(new Date()).toString());
						
		try {
			con = MysqlPool.getInstance().getConnection();
			con.createStatement().execute(insertSql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}

	}
	
	public boolean batchSaveHouse(List<LianJiaHouse> houses) throws Exception {
		try{
			con = MysqlPool.getInstance().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		
			for(LianJiaHouse house : houses){
				String insertSql = String
						.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s')",
								tableName, 
								houseIdCol, houseTitleCol, houseLocationCol,
								houseRoomCol, houseAreaCol, houseDirectionCol,
								housePriceCol, pricePerSquareCol, houseURLCol,
								regionURLCol, isDownCol, createDateCol, 
								house.getHouseId(),
								house.getHouseTitle(), house.getHouseLocation(),
								house.getHouseRoom(), house.getHouseArea(),
								house.getHouseDirection(), house.getHousePrice(),
								house.getPricePerSquare(), house.getHouseURL(),
								house.getRegionURL(), (house.isDown() ? 1 : 0),
								(new Date()).toString());
				try{
					con.createStatement().execute(insertSql);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				} 
			}
			
			if(con != null){
				con.close();
			}
			
			return true;
		
		
	}

	public boolean createTable() throws Exception {
		String dropTable = "DROP TABLE IF EXISTS `lianjia_table`";
		String createTable = "CREATE TABLE `lianjia_table` (  `id` bigint(20) NOT NULL AUTO_INCREMENT,  `house_id` text,  `house_title` text,  `house_location` text,  `house_room` text,  `house_area` text,  `house_direction` text,  `house_price` text,  `price_per_square` text,  `house_url` longtext,  `region_url` longtext,  `is_down` tinyint(2) DEFAULT NULL,  `create_date` text,  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8";
		
		try {
			con = MysqlPool.getInstance().getConnection();
			con.createStatement().execute(dropTable);
			con.createStatement().execute(createTable);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
	}
	
	public static void main(String[] args) throws Exception{
		LianJiaDataHelper dh = new LianJiaDataHelper();
		dh.createTable();
	}
}
