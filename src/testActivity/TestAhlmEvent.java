package testActivity;

import org.junit.Test;

import com.common.utils.HttpClientUtils;

public class TestAhlmEvent {
	
	private String com = "language=zh&country=TW&gameCode=ahlm&activity=2006";
	private String prefix = "http://testactivity.gm99.com";
	
	private long userId = 1000000;
	private long inviteUId = 998899;
	
	private String thirdUId = "999999888888";
	
	public String getRequestResult(String requestPath) throws Exception{
		String requestURL = prefix + requestPath + com;
		System.out.println("url:" + requestURL);
		String result = HttpClientUtils.callServer(requestURL);
		return result;
	}
	
	@Test
	public void TestComeview() throws Exception{
		String requestPath = "/common/view.do";
		String result = this.getRequestResult(requestPath);
		System.out.println(result);
	}
	
	@Test
	public void TestPhoneBook() throws Exception{
		String requestPath = "/activityBook/phoneBookAhlm.do";
		requestPath = requestPath + "?userId=889988&phone=889988&";
		String result = this.getRequestResult(requestPath);
		System.out.println(result);
	}
	
	@Test
	public void TestGetBattleCount() throws Exception{
		String requestPath = "/fBInviteStatis/getBattleCount.do?";
		String result = this.getRequestResult(requestPath);
		System.out.println(result);
	}
	
	@Test
	public void TestOperations() throws Exception{
		String requestPath = "/activityOperation/hitOperationAhlm.do";
		requestPath = requestPath + "?userId=8899453&thirdUId=123232232&operation=2&"; 
		String result = this.getRequestResult(requestPath);
		System.out.println(result);
	}
	
	@Test
	public void TestLottery() throws Exception{
		String requestPath = "/activityLottery/lotteryAhlm.do";
		requestPath = requestPath + "?userId=" + userId + "&";
		for(int i = 0; i < 10000; i++){
			String result = this.getRequestResult(requestPath);
			System.out.println(i + "----" +result);
		}
	}
	
	@Test
	public void TestFetchSequence() throws Exception{
		String requestPath = "/activity/fetchSequence.do";
		String result = this.getRequestResult(requestPath);
		System.out.println(result);
	}
	
	
}
