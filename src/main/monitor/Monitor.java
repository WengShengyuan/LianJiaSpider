package main.monitor;

import java.util.ArrayList;
import java.util.List;

import main.metadata.metadata.LianJiaHouse;
import main.metadata.metadata.LianJiaParams;
import main.metadata.parser.LianJiaDocParser;
import main.metadata.parser.LianJiaURLParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import util.database.LianJiaDataHelper;
import util.net.NetUtils;

public class Monitor {

	public static void main(String[] args) throws Exception {
		

		List<String> locations = new ArrayList<String>();
		locations.add("chaoyang");
		locations.add("haidian");
		LianJiaDataHelper dh = new LianJiaDataHelper();
		
		List<String> directions = new ArrayList<String>();
//		directions.add(LianJiaParams.roomDirectionKey_SN);

		List<String> URLS = LianJiaURLParser.genURL(locations, 0, 450, -1,
				-1, LianJiaParams.roomCountKey_THREE, null, directions, true,
				true, false);
		
		URLPool.getInstance().batchPush(URLS);
		
		List<Document> docs = new ArrayList<Document>();
		
		while(URLPool.getInstance().hasNext()){
			String URL = URLPool.getInstance().popURL();
			System.out.println("--------------URL------------------------------");
			System.out.println(URL);
			System.out.println("--------------HouseList--------------------------");
			String content = NetUtils.httpGet(URL);
			Document doc = Jsoup.parse(content);
			List<LianJiaHouse> list = LianJiaDocParser.getHouseList(doc);
			for(LianJiaHouse house : list){
				String s = house.getHouseTitle() + "\t" + house.getHouseLocation() + "\t" + house.getHousePrice() + "\t" + house.getPricePerSquare() + "\t" + "\t降价:" + house.isDown();
				System.out.println(s);
			}
			
			dh.batchSaveHouse(list);
			
			System.out.println("");
		}

		

	}

}
