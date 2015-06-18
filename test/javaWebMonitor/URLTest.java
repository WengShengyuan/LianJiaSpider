package javaWebMonitor;

import util.net.NetUtils;

public class URLTest {
	
	
	public static void main(String[] args) throws Exception{
		String content = NetUtils.httpGet("http://www.taobao.com/market/sport/citiao/paobuxie.php");
		System.out.println(content);
	}

}
