package main.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import main.metadata.metadata.LianJiaHouse;
import main.metadata.metadata.LianJiaParams;
import main.metadata.parser.LianJiaDocParser;
import main.metadata.parser.LianJiaURLParser;
import util.database.LianJiaDataHelper;
import util.net.NetUtils;

public class Client {

	public static void main(String[] args) throws Exception {
		line();
		con("链家房产获取系统");
		line();
		con("");

		String locationStr = getStr("输入搜索区域拼音，以英文逗号分隔");
		String[] locations = locationStr.trim().split(",");
		List<String> locationList = new ArrayList<String>();

		con("搜索区域" + locations.length + "个");

		int lowerPrice = getInt("输入最低房价");
		int upperPrice = getInt("输入最高房价");

		int lowerArea = getInt("输入最低房屋面积");
		int upperArea = getInt("输入最高房屋面积");

		String nearSub = getStr("是否地铁房【Y/N】:");
		String nearSchool = getStr("是否学区房【Y/N】:");
		String fiveYears = getStr("是否满五唯一【Y/N】:");

		boolean nearSubBool = nearSub.toLowerCase().contains("y");
		boolean nearSchoolBool = nearSchool.toLowerCase().contains("y");
		boolean fiveYearsBool = fiveYears.toLowerCase().contains("y");

		StringBuilder conclusion = new StringBuilder();
		conclusion.append("搜索地区：");
		for (String location : locations) {
			locationList.add(location);
			conclusion.append(location);
		}
		conclusion.append("\n");
		conclusion.append("价格区间:").append(lowerPrice).append("-")
				.append(upperPrice).append("\n");
		conclusion.append("面积区间:").append(lowerArea).append("-")
				.append(upperArea).append("\n");
		if (nearSubBool)
			conclusion.append("地铁房\t");
		if (nearSchoolBool)
			conclusion.append("学区房\t");
		if (fiveYearsBool)
			conclusion.append("满五唯一\t");

		con(conclusion.toString());

		// LianJiaDataHelper dh = new LianJiaDataHelper();
		// dh.createTable();

		List<String> URLS = LianJiaURLParser.genURL(locationList, lowerPrice,
				upperPrice, lowerArea, upperArea,
				LianJiaParams.roomCountKey_THREE, null,
				new ArrayList<String>(), fiveYearsBool, nearSubBool,
				nearSchoolBool);

		URLPool.getInstance().batchPush(URLS);

		List<Document> docs = new ArrayList<Document>();

		while (URLPool.getInstance().hasNext()) {
			String URL = URLPool.getInstance().popURL();
			try {
				System.out
						.println("--------------URL------------------------------");
				System.out.println(URL);
				System.out
						.println("--------------HouseList--------------------------");
				String content = NetUtils.httpGet(URL);
				Document doc = Jsoup.parse(content);
				List<LianJiaHouse> list = LianJiaDocParser.getHouseList(doc);
				for (LianJiaHouse house : list) {
					String s = house.getHouseTitle() + "\t"
							+ house.getHouseLocation() + "\t"
							+ house.getHousePrice() + "\t"
							+ house.getPricePerSquare() + "\t" + "\t降价:"
							+ house.isDown();
					con(s);
				}

				// dh.batchSaveHouse(list);

				System.out.println("");
			} catch (Exception e) {
				URLPool.getInstance().pushURL(URL);
				e.printStackTrace();
			}
		}

		con("抓取结束");

	}

	private static void con(String line) {
		System.out.println(line);
	}

	private static void line() {
		System.out.println("--------------------");
	}

	private static String getStr(String request) {
		Scanner sc = new Scanner(System.in);
		System.out.print(request);
		return sc.nextLine();
	}

	private static int getInt(String request) {
		Scanner sc = new Scanner(System.in);
		System.out.print(request);
		return sc.nextInt();
	}

}
