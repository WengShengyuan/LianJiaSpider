package main.metadata.metadata;

import java.util.HashMap;

public class LianJiaParams {
	
	
	public static String BaseURL = "http://bj.lianjia.com";
	public static String URLSlash = "/";
	public static String SecondHanded = "ershoufang";
	

	public static HashMap<String, String> roomCountMap;
	public static String roomCountKey_NONE = "不限";
	public static String roomCountKey_ONE = "一室";
	public static String roomCountKey_TWO = "二室";
	public static String roomCountKey_THREE = "三室";
	public static String roomCountKey_FOUR = "四室";
	public static String roomCountKey_FIVE = "五室";
	public static String roomCountKey_MORE = "五室以上";
	
	public static HashMap<String, String> roomAgeMap;
	public static String roomAgeKey_NONE = "不限";
	public static String roomAgeKey_FIVE = "5年内";
	public static String roomAgeKey_TEN = "10年内";
	public static String roomAgeKey_TEN2TWENTY = "10-20年";
	public static String roomAgeKey_MORE = "20年以上";
	
	
	public static HashMap<String, String> roomDirectionMap;
	public static String roomDirectionKey_NONE = "不限";
	public static String roomDirectionKey_EAST = "朝东";
	public static String roomDirectionKey_WEST = "朝西";
	public static String roomDirectionKey_SOUTH = "朝南";
	public static String roomDirectionKey_NORTH = "朝北";
	public static String roomDirectionKey_SN = "南北";
	
	
	static{
		roomCountMap = new HashMap<String, String>();
		roomCountMap.put(roomCountKey_NONE, "");
		roomCountMap.put(roomCountKey_ONE, "l1");
		roomCountMap.put(roomCountKey_TWO, "l2");
		roomCountMap.put(roomCountKey_THREE, "l3");
		roomCountMap.put(roomCountKey_FOUR, "l4");
		roomCountMap.put(roomCountKey_FIVE, "l5");
		roomCountMap.put(roomCountKey_MORE, "l6");
		
		roomAgeMap = new HashMap<String, String>();
		roomAgeMap.put(roomAgeKey_NONE, "");
		roomAgeMap.put(roomAgeKey_FIVE, "y1");
		roomAgeMap.put(roomAgeKey_TEN, "y2");
		roomAgeMap.put(roomAgeKey_TEN2TWENTY, "y3");
		roomAgeMap.put(roomAgeKey_MORE, "y4");
		
		roomDirectionMap = new HashMap<String, String> ();
		roomDirectionMap.put(roomDirectionKey_NONE, "");
		roomDirectionMap.put(roomDirectionKey_EAST, "f1");
		roomDirectionMap.put(roomDirectionKey_WEST, "f3");
		roomDirectionMap.put(roomDirectionKey_SOUTH, "f2");
		roomDirectionMap.put(roomDirectionKey_NORTH, "f4");
		roomDirectionMap.put(roomDirectionKey_SN, "f5");
		
	}
	
}
