package testActivity;

import org.junit.Test;

import com.gm99.common.util.BusinessException;
import com.gm99.common.util.ip.IPUtil;

public class TestIp {
	@Test
	public void testIp() throws BusinessException{
		String ip = "202.39.241.38";
		String address = IPUtil.getAddress(ip);
		System.out.println(address);
		
	}
	
}
