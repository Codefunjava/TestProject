package netRequest;

import java.util.HashMap;
import java.util.Map;

import com.common.utils.HttpClientUtils;

public class BossRequest {
	public static void main(String[] args) throws Exception {
		//String url = "https://ht.37wan.com/server_login.php?action=login&login_id=80";
		String url = "http://testmboss.gm99.com/j_spring_check/";
		Map<String, Object> param = new HashMap<String, Object> ();
		param.put("username", "fangchengyan");
		String encode = "utf-8";
		String result = HttpClientUtils.sendSimplePostRequest(url, param, encode);
		System.out.println("--result: " +result);
	}
}
