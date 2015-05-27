package createSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gm99.activity.bean.ayxj.LotteryGift;

public class SqlGenerator {
	public static final String ROOT = System.getProperty("user.dir") + "\\src\\main\\java\\com\\gm99\\";
	public static void main(String[] args) throws IOException {
//		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\gm99\\";
		//generateBookCode(filePath + "bookcode.txt");
		//generateGift(filePath + "gift.txt");
//		generateDiamond(filePath+"text1.txt");
//		File f = new File("d\\13232.txt");
//		System.out.println(f.getName().substring(0,f.getName().indexOf(".")));
		String path = "D:\\读取sql文本";
		read(path);
		//getType("4星菇生命菇");
	}
	
	public static void generateBookCode(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String sql1 = "INSERT INTO t_book_code(bookType,isDispatcher,isUse,gameCode,dispatcherTime,useTime,expire,activity,userId,bookCode) ";
		String sql2 = "VALUES(bookType,isDispatcher,isUse,'gameCode','dispatcherTime','useTime', 'expire', activity, userId, 'bookCode');";
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] data = line.split("\\s+");
			String mySql = sql2;
			String bookType = "1";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (!data[2].equals("豪华礼包")) {
				bookType = "2";
			}
			mySql = mySql.replace("bookType", bookType);
			mySql = mySql.replace("isDispatcher", "0");
			mySql = mySql.replace("isUse", "0");
			mySql = mySql.replace("gameCode", "bwenplay");
			mySql = mySql.replace("'dispatcherTime'", "null");
			mySql = mySql.replace("'useTime'", "null");
			mySql = mySql.replace("expire", "2050-12-31 00:00:00");//data[8]);
			mySql = mySql.replace("activity", "1001");
			mySql = mySql.replace("userId", "0");
			mySql = mySql.replace("bookCode", data[0]);
			System.out.println(sql1 + mySql);
		}
		br.close();
	}
	
	public static void generateGift(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String sql = "INSERT INTO t_lottery_gift VALUES(giftId, 'giftName', probability, 'gameCode','activity');";
		String line = "";
		int index =0 ;
		while ((line = br.readLine()) != null) {
			String[] data = line.split("\\s+");
			String mySql = sql;
			if (data.length == 2) {
				mySql = mySql.replace("probability", data[1].replace("%", ""));
			} else {
				mySql = mySql.replace("probability", data[3].replace("%", ""));
			}
			mySql = mySql.replace("giftId", ++index + "");
			mySql = mySql.replace("giftName", data[0]);
			mySql = mySql.replace("gameCode", "xz");
			mySql = mySql.replace("'activity'", 1002 + "");
			System.out.println(mySql);
		}
		br.close();
	}
	
	public static List<LotteryGift> generateGift() throws IOException {
		List<LotteryGift> gifts = new ArrayList<LotteryGift>();
		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\gm99\\";
		BufferedReader br = new BufferedReader(new FileReader(filePath + "gift.txt"));
		String line = "";
		int index =0 ;
		while ((line = br.readLine()) != null) {
			String[] data = line.split("\\s+");
			double probability = 0.0D;
			if (data.length == 2) {
				probability = Double.parseDouble(data[1].replace("%", ""));
			} else {
				probability = Double.parseDouble(data[3].replace("%", ""));
			}
//			LotteryGift l = new LotteryGift(++index, data[0], probability / 100.0);
//			gifts.add(l);
		}
		br.close();
		return gifts;
	}
	
	/**
	 * 直接读取硬盘上的序列号文件来生成sql
	 * @param filePath
	 * @throws IOException
	 */
	public static void read(String filePath) throws IOException {
		File file = new File(filePath);
		File[] files = file.listFiles();
		String sql1 = "INSERT INTO t_activity_sequence(serialNumber, sequenceType, gameCode, activity, msg) VALUES";
		String sql2 = "('serialNumber', 'sequenceType', 'gameCode', activity, 'msg'),";
		String activity = "2005";
		String gameCode = "xz";
		
		File tof = new File("D:\\创建sql语句\\" + "sql语句" + ".sql");
		if (!tof.exists()) {
			tof.createNewFile();
		}
		
		PrintStream ps = new PrintStream(tof);
		ps.println(sql1);
		
		for (File f : files) {
			if (f.isFile()) {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line = "";
				
				String fileName_type = f.getName().substring(0, f.getName().indexOf("."));
				String file_array[] = fileName_type.split("-");
				String fileName = file_array[0];
				String sequenceType = file_array[1];;
				
				System.out.println(fileName + "_" + sequenceType);
				
				while ((line = br.readLine()) != null) {
					String mySql = sql2;
					String s = line.trim();
					mySql = mySql.replace("serialNumber", s);
					mySql = mySql.replace("sequenceType", sequenceType);
					mySql = mySql.replace("gameCode", gameCode);
					mySql = mySql.replace("activity", activity);
					mySql = mySql.replace("msg", fileName);
					ps.println(mySql);
				}
			}
//			if(f.isDirectory()){  //读当前目录下的文件
//				File[] subFiles = f.listFiles();
//				for (File ff : subFiles) {
//					if (ff.isFile()) {
//						BufferedReader br = new BufferedReader(new FileReader(ff));
//						String line = "";
//						
//						String fileName = ff.getName().substring(0, ff.getName().indexOf("."));
//						String sequenceType = getType(fileName) + "";
//						
//						System.out.println(fileName);
//
//						while ((line = br.readLine()) != null) {
//							String mySql = sql2;
//							String s = line.trim();
//							mySql = mySql.replace("serialNumber", s);
//							mySql = mySql.replace("sequenceType", sequenceType);
//							mySql = mySql.replace("gameCode", gameCode);
//							mySql = mySql.replace("activity", activity);
//							mySql = mySql.replace("msg", fileName);
//							ps.println(mySql);
//						}
//					}
//				}
//			}
		}
		ps.close();
	}
	
	/**
	 * 生成t_activity_sequence表中的插入語句
	 * @param file
	 * @throws IOException
	 */
	public static void generateDiamond(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(ROOT + "text1.txt"));
		String sql1 = "INSERT INTO t_activity_sequence(serialNumber, sequenceType, gameCode, activity, msg) VALUES";
		String sql2 = "('serialNumber', 'sequenceType', 'gameCode', activity, 'msg'),";
		String line = "";
		String msg = "1000鑽石";
		String sequenceType = "3";
		String activity = "2004";
		String gameCode = "xz";
		//生成的文件名
		String fileName = sequenceType;
		File f = new File("D:" + File.separator + "createSql"+File.separator + fileName + ".txt");
		if (!f.exists()) {
			f.createNewFile();
		}
		PrintStream ps = new PrintStream(f);
		ps.println(sql1);
		while ((line = br.readLine()) != null) {
//			String[] da = data[1].split("\\s+");
			String mySql = sql2;
			String s = line.trim();
			mySql = mySql.replace("serialNumber", s);
			mySql = mySql.replace("sequenceType", sequenceType);
			mySql = mySql.replace("gameCode", gameCode);
			mySql = mySql.replace("activity", activity);
			mySql = mySql.replace("msg", msg);
			ps.println(mySql);
		}
		br.close();
		ps.close();
	}
	
	public static void generateInsert(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String sql1 = "INSERT INTO t_activity_sequence(serialNumber, sequenceType, gameCode, activity, msg) VALUES";
		String sql2 = "('serialNumber', 'sequenceType', 'gameCode', activity, 'msg'),";
		String url = "http://play.gm99.com/sms_send.do?mobile=MOBILE&content=CONTENT";
		String line = "";
		PrintStream ps = new PrintStream(new File("D:\\url.txt"));
		//ps.println(url);
		System.out.println(url);
		while ((line = br.readLine()) != null) {
			String[] data = line.split("\\\"");
			url = "http://play.gm99.com/sms_send.do?mobile=MOBILE&content=CONTENT";
			url = url.replace("CONTENT", data[1].trim());
			url = url.replace("MOBILE", data[2].trim());
			ps.println(url);
			//System.out.println(url);
		}
		br.close();
	}
	
	public static int getType(String name) {
		int code = 0;
		/*if ("50鑽石".equals(name)) {
			code = 1;
		}else if ("100鑽石".equals(name)) {
			code = 2;
		}else if ("1000鑽石".equals(name)) {
			code = 3;
		}else if ("金幣10000".equals(name)) {
			code = 6;
		}else if ("能量1000".equals(name)) {
			code = 7;
		}else if ("水晶3".equals(name)) {
			code = 11;
		}else if ("能量500".equals(name)) {
			code = 12;
			
		}else if ("海洋菇".equals(name) || "生命菇".equals(name)) {
			code = 9;
		}else if ("海洋盾菇".equals(name) || "生命盾菇".equals(name)) {
			code = 5;
		}//随机3星卡
		else if ("墮天使洛林".equals(name) || "厄運騎士賽斯".equals(name) || "劍士曉".equals(name) || "歌姬安琪兒".equals(name)
			   ||"精靈弓箭手凜".equals(name) || "龍女靈漪".equals(name) || "旅行者安娜".equals(name) || "女僕·靈兒".equals(name)
			   ||"人形少女玲玲".equals(name) || "少女•幻天姬".equals(name) || "死亡使者".equals(name) || "巫師維那".equals(name)
			   ||"武姬飛鳥".equals(name) || "學徒·灰者".equals(name) || "櫻之聲•友美".equals(name) || "戰修女綾三".equals(name)
			   ||"中忍·春日".equals(name) ) {
			code = 10;
		}//随机4星卡
		else if ("暗黑天使洛林".equals(name) || "惡靈騎士賽斯".equals(name) || "海之歌•友美".equals(name) || "河伯靈漪".equals(name)
				   ||"火武姬飛鳥".equals(name) || "火焰大師安娜".equals(name) || "劍俠曉".equals(name) || "精靈神射手凜".equals(name)
				   ||"刻印巫師維那".equals(name) || "人形殺手玲玲".equals(name) || "上忍·春日".equals(name) || "聖詩·安琪兒".equals(name)
				   ||"聖徒·輝者".equals(name) || "聖徒教官綾三".equals(name) || "死神".equals(name) || "銀瞳•幻天姬".equals(name)
				   ||"戰鬥·靈兒".equals(name)) {
			code = 8;
		}//随机5星卡
		else if ("大劍豪·曉".equals(name) || "地獄死神".equals(name) || "復仇天使洛林".equals(name) || "灰星".equals(name)
				   ||"火姬神·飛鳥".equals(name) || "覺醒·靈兒".equals(name) || "淩光•幻天姬".equals(name) || "龍王靈漪".equals(name)
				   ||"夢魘騎士賽斯".equals(name) || "夢之舞•友美".equals(name) || "魔劍封印·維那".equals(name) || "木影·春日".equals(name)
				   ||"惹事人安娜".equals(name) || "閃耀爐心".equals(name) || "神弓·凜".equals(name) || "聖詠詩·安琪兒".equals(name)
				   ||"雙刃騎士·輝者".equals(name) ||"屠夫修女綾三".equals(name) || "最終兵器玲玲".equals(name)) {
			code = 4;
		}
		*/
		
		if ("强化礼包（小）".equals(name)) {
			code = 8;
		}else if ("真气礼包（小）".equals(name)) {
			code = 7;
		}else if ("精魄礼包（小）".equals(name)) {
			code = 6;
		}else if ("强化礼包（中）".equals(name)) {
			code = 5;
		}else if ("真气礼包（中）".equals(name)) {
			code = 4;
		}else if ("精魄礼包（中）".equals(name)) {
			code = 3;
		}else if ("真气礼包（大）".equals(name)) {
			code = 2;
		}else if ("精魄礼包（大）".equals(name)) {
			code = 1;
		}else if ("银币礼包".equals(name)) {
			code = 9;
		}
		
		System.out.println(code);
		return code;
	}
	
}
