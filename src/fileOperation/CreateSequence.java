package fileOperation;

import java.util.Random;

import com.gm99.common.util.StringUtil;

public class CreateSequence {
	
	
	
	public static String generatorSequence(int id) {
		String prefix = "0X";
		Random rand = new Random();
		int randInt = (int)(rand.nextDouble() * 1000000);
		String md5Str = StringUtil.toMd5(System.currentTimeMillis() + "" + randInt).toLowerCase();
		md5Str = md5Str.substring(0, 8);
		return prefix + md5Str + id;
	}
	
	
	
	public static void main(String[] args) {
		for(int i = 0; i < 1; i++){
			System.out.println(generatorSequence(20));
		}
	}
	
}
