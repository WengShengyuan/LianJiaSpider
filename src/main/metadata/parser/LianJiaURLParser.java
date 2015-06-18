package main.metadata.parser;

import main.metadata.metadata.LianJiaParams;

import java.util.ArrayList;
import java.util.List;

public class LianJiaURLParser {

	

	/**
	 * 生成URL列表， 地点和朝向组合
	 * 
	 * @param locations
	 *            地点 ： 拼音
	 * @param lowerPrice
	 *            价格下限
	 * @param upperPrice
	 *            价格上限
	 * @param lowerArea
	 *            面积下限
	 * @param upperArea
	 *            面积上限
	 * @param roomCount
	 *            几室
	 * @param roomAge
	 *            房龄
	 * @param roomDirection
	 *            房屋朝向
	 * @param fiveYears
	 *            是否满五唯一
	 * @param nearSub
	 *            是否近地铁
	 * @param nearSchool
	 *            是否学区房
	 * @return
	 */
	public static List<String> genURL(List<String> locations, int lowerPrice,
			int upperPrice, int lowerArea, int upperArea, String roomCount,
			String roomAge, List<String> roomDirections, boolean fiveYears,
			boolean nearSub, boolean nearSchool) {

		List<String> URLList = new ArrayList<String>();
		String prefixURL = LianJiaParams.BaseURL + LianJiaParams.URLSlash + LianJiaParams.SecondHanded + LianJiaParams.URLSlash;
		
		
		StringBuilder restParams = new StringBuilder();
		if(nearSub)
			restParams.append("su1");
		if(nearSchool)
			restParams.append("sc1");
		if(fiveYears)
			restParams.append("tf1");
		if(!(roomAge == null || roomAge.isEmpty()))
			restParams.append(LianJiaParams.roomAgeMap.get(roomAge));
		if(!(roomCount == null || roomCount.isEmpty()))
			restParams.append(LianJiaParams.roomCountMap.get(roomCount));
		if(upperArea >= 0 && lowerArea >= 0)
			restParams.append("ba").append(lowerArea).append("ea").append(upperArea);
		if(upperPrice >=0 && lowerPrice >=0)
			restParams.append("bp").append(lowerPrice).append("ep").append(upperPrice);
			
		
		

		if(!(locations == null) || (locations.size()==0)){
			if(!(roomDirections == null) || (roomDirections.size() ==0)){
				for(String location : locations){
					for(String direction : roomDirections){
						StringBuilder ub = new StringBuilder(prefixURL);
						ub.append(location).append(LianJiaParams.URLSlash)
						.append(LianJiaParams.roomDirectionMap.get(direction))
						.append(restParams);
						URLList.add(ub.toString());
					}
				}
			} else {
				for(String location : locations){
					StringBuilder ub = new StringBuilder(prefixURL);
					ub.append(location).append(LianJiaParams.URLSlash)
					.append(restParams);
					URLList.add(ub.toString());
				}
			}
		} else {
			if(!(roomDirections == null) || (roomDirections.size() ==0)){
					for(String direction : roomDirections){
						StringBuilder ub = new StringBuilder(prefixURL);
						ub.append(LianJiaParams.roomDirectionMap.get(direction))
						.append(restParams);
						URLList.add(ub.toString());
					}
			} else {
					StringBuilder ub = new StringBuilder(prefixURL);
					ub.append(restParams);
					URLList.add(ub.toString());
			}
		}
		
		

		return URLList;
	}

}
