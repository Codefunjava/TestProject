package test.fbShareInvite;

import java.util.Random;

import org.junit.Test;

import com.common.utils.HttpClientUtils;

public class TestProject {
	
	public final String URL_PREFIX = "http://activity.gm99.com";
	public final String COM = "&language=zh&country=TW&gameCode=ahlm&serverCode=112&imei=22144&mac=1556445";
	//public final String facebookId = "322375484592161";
	//public final String facebookId = "419401101552283";
	public final String facebookId = "1469362886687698";
	//public final String facebookId = "1531741403772477";
	//public final String facebookId = "4194333333";
	public final String userId = "123456";
	public final String roleId = "roleID";
	public String invitedfacebookId_list = "8548141|8814779|9617642|4474644|3484441|1653655|4189007|6973086|7404333|4706391|7680730|2970639|806425|3499445|6935424|2898072|2111328|7076668|8861900|2634175|9230379|6026909|4542469|3391553|1781117|7376697|9889141|6018254|4569005|4647273|3845177|7594678|4383398|7815199|7372333|3743979|7443491|9992072|8418395|1635034|3615095|9444667|7473085|717512|3206695|6831962|94426|380483|3157492|3116903|5020880|5307307";
	public  long fb_list[] = {8548141, 8814779, 9617642, 4474644, 3484441, 1653655, 4189007, 6973086, 7404333, 4706391, 7680730, 2970639, 806425, 3499445, 6935424, 2898072, 2111328, 7076668, 8861900, 2634175, 9230379, 6026909, 4542469, 3391553, 1781117, 7376697, 9889141, 6018254, 4569005, 4647273, 3845177, 7594678, 4383398, 7815199, 7372333, 3743979, 7443491, 9992072, 8418395, 1635034, 3615095, 9444667, 7473085, 717512, 3206695, 6831962, 94426, 380483, 3157492, 3116903, 5020880, 5307307};
	@Test
	public void testAddFBInvite() throws Exception{
		long start = System.currentTimeMillis();
		String tyURL= URL_PREFIX + "/fBInvite/addFBInvite.do?facebookId=%s&invitedfacebookId_list=%s&userId=19052017&ip=202.39.241.99&imei=AC1284C7-5329-446C-AA35-2BAA5D708684&releId=瘋狂牛大力&mac=020000000000&serverCode=11&country=TW&language=zh&gameCode=ahlm";
		tyURL = String.format(tyURL, facebookId, invitedfacebookId_list); 
		System.out.println("url: " + tyURL);
		//String result = HttpClientUtils.callServer(tyURL);
		//System.out.println("--result: " +result);
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void testCountInviteNum() throws Exception {
		String url = URL_PREFIX + "/fBInvite/countInviteNum.do?userId=%s&facebookId=%s&roleId=%s" + COM;
		url = String.format(url, userId, facebookId, roleId);
		System.out.println("url: " + url);
		long start = System.currentTimeMillis();
		String result = HttpClientUtils.callServer(url);
		System.out.println("--result: " +result);
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	
	@Test
	public void testCreateFBOperator() throws Exception {
		long start = System.currentTimeMillis();
//		String operator = "1";
//		String url = URL_PREFIX + "/fBOperator/createFBOperator.do?userId=%s&facebookId=%s&roleId=%s&operator=%s" + COM;
//		url = String.format(url, userId, facebookId, roleId, operator);
//		String result = HttpClientUtils.callServer(url);
//		System.out.println("--result: " +result + "operator:" + operator);
		
		String operator = "2";
		for(long fb : fb_list){
			String url = URL_PREFIX + "/fBOperator/createFBOperator.do?userId=%s&facebookId=%s&roleId=%s&operator=%s" + COM;
			url = String.format(url, userId, fb, roleId, operator);
			System.out.println("url: " + url);
			//Thread.sleep(5100);
			String result = HttpClientUtils.callServer(url);
			System.out.println("--result: " +result + "operator:" + operator);
		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void testFetchFBGiftList() throws Exception {
		String url = URL_PREFIX + "/fBGift/fetchFBGiftList.do?userId=%s&facebookId=%s&roleId=%s&giftType=2" + COM;
		url = String.format(url, userId, facebookId, roleId);
		System.out.println("url: " + url);
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10; i++){
			String result = HttpClientUtils.callServer(url);
			System.out.println(i + "--result: " +result);
		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void testCreateFBGiftDonate() throws Exception {
		//int giftId = r.nextInt(11) + 1;
		long start = System.currentTimeMillis();
		//String tyURL = "/fBGiftDonate/createFBGiftDonate.do?facebookId=%s&userId=13865889&ip=202.39.241.99&imei=864644026415984&donateType=2&giftId=4&mac=14:f6:5a:a2:05:44&serverCode=0&facebookName=ByeMo&roleId=TianPeng&country=CN&donatedFacebookId=1531741403772477&language=zh&gameCode=ahlm";
		String lwURL = "/fBGiftDonate/createFBGiftDonate.do?facebookId=%s&userId=19052017&ip=202.39.241.99&imei=AC1284C7-5329-446C-AA35-2BAA5D708684&donateType=2&releId=瘋狂牛大力&giftId=%s&mac=020000000000&serverCode=11&facebookName=李威&country=TW&donatedFacebookId=%s&language=zh&gameCode=ahlm";
		long giftId[] = {70729, 70730, 70731, 70732, 70733};
		
		int i = 0;
		for(long fb : fb_list){
			String url = URL_PREFIX + lwURL;
			url = String.format(url, fb, facebookId, giftId[i]);
			System.out.println("url: " + url);
			Thread.sleep(3000);
			String result = HttpClientUtils.callServer(url);
			System.out.println("--result: " +result);
			i++;
			if(i >= giftId.length - 1){
				i = 0;
			}
		}
		
//		String url = URL_PREFIX + lwURL;
//		url = String.format(url, facebookId, invitedfacebookId_list);
//		System.out.println("url: " + url);
//		Thread.sleep(3000);
//		String result = HttpClientUtils.callServer(url);
//		System.out.println("--result: " +result);
		
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void testCreateFBGiftDonateReturn() throws Exception {
		long start = System.currentTimeMillis();
		for(long fb : fb_list){
			String url = URL_PREFIX + "/fBGiftDonate/createFBGiftDonate.do?facebookId=%s&userId=13865889&ip=202.39.241.99&imei=864644026415984&donateType=3&giftId=4&mac=14:f6:5a:a2:05:44&serverCode=0&facebookName=BM&roleId=qian&country=CN&donatedFacebookId=%s&language=zh&donateTime=2015-05-08 00:00:00&gameCode=ahlm";
			url = String.format(url, fb, facebookId);
			System.out.println(url);
//			String result = HttpClientUtils.callServer(url);
//			System.out.println("--result: " +result);
		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void testFetchFBGetAwardList() throws Exception {
		String giftStatus = "1";
		String url = URL_PREFIX + "/fBGetAward/fetchFBGetAwardList.do?userId=%s&facebookId=%s&roleId=%s&giftStatus=%s&pageSize=1000" + COM;
		url = String.format(url, userId, facebookId, roleId, giftStatus);
		System.out.println("url: " + url);
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++){
			String result = HttpClientUtils.callServer(url);
			System.out.println(i + "--result: " +result);
		}
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void testGetAwardOrderId() throws Exception {
		String url = URL_PREFIX + "/fBGetAward/getGetAwardOrderId.do?facebookId=7819908&stone=1&userId=19&ip=202.39.241.99&imei=356567054218381&giftType=1&giftId=70868&mac=40:0E:85:13:8B:04&serverCode=0&roleId=000&country=CN&language=zh&id=60&gameCode=ahlm&id=1319";
		System.out.println("url: " + url);
		long start = System.currentTimeMillis();
		//for(int i = 0; i < 100; i++){
			String result = HttpClientUtils.callServer(url);
			System.out.println("--result: " +result);
		//}
		long end = System.currentTimeMillis();
		System.out.println("所用时间：" + (end - start));
	}
	
	@Test
	public void test() throws Exception {
		StringBuilder sb = new StringBuilder();
		for(long fb : fb_list){
			sb.append(fb+"|");
		}
		System.out.println(sb.toString());
	}
	
	@Test
	public void crateRandom() throws Exception{
		String lwURL = "/fBGiftDonate/createFBGiftDonate.do?facebookId=%s&userId=19052017&ip=202.39.241.99&imei=AC1284C7-5329-446C-AA35-2BAA5D708684&donateType=2&releId=瘋狂牛大力&giftId=5&mac=020000000000&serverCode=11&facebookName=李威&country=TW&donatedFacebookId=%s&language=zh&gameCode=ahlm";
		for(int i = 0; i < 100; i++){
			Random random = new Random();
			int rand = (int)(random.nextDouble() * 10000000);
			System.out.println(rand);
			String url = URL_PREFIX + lwURL;
			url = String.format(url, rand, facebookId);
			System.out.println("url: " + url);
			String result = HttpClientUtils.callServer(url);
			System.out.println(result);
		}
	}
	
	@Test
	public void crateRand() throws Exception{
		for(int i = 0; i < 52; i++){
			Random random = new Random();
			int rand = (int)(random.nextDouble() * 10000000);
			System.out.print(rand + ", ");
		}
	}
	
	@Test
	public void addShareGift() throws Exception{
		String url = "http://activity.gm99.com/fBOperator/createFBOperator.do?userId=123456&facebookId=%s&roleId=roleID&operator=1&language=zh&country=TW&gameCode=ahlm&serverCode=112&imei=22144&mac=1556445";
		url = String.format(url, facebookId);
		String result = HttpClientUtils.callServer(url);
		System.out.println(result);
	}
}
