package createSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Sql_2015npc_nd {
	
	public static void main(String[] args) throws IOException {
		String path = "D:\\读取sql文本";
		read(path);
	}
	
	/**
	 * 直接读取硬盘上的序列号文件来生成sql
	 * @param filePath
	 * @throws IOException
	 */
	public static void read(String filePath) throws IOException {
		File file = new File(filePath);
		String sql1 = "INSERT INTO t_activity_sequence(serialNumber, sequenceType, gameCode, activity, msg) VALUES";
		String sql2 = "('serialNumber', 'sequenceType', 'gameCode', activity, 'msg'),";
		String activity = "1004";
		String gameCode = "mlen";
		
		File tof = new File("D:\\创建sql语句\\" + "sql语句" + ".sql");
		if(!tof.getParentFile().exists()){
			tof.getParentFile().mkdirs();
		}
		if (!tof.exists()) {
			tof.createNewFile();
		}
		
		PrintStream ps = new PrintStream(tof);
		ps.println(sql1);
		readFile(file, ps, sql2, gameCode, activity);
		ps.close();
		
		
	}
	
	public static void readFile(File file, PrintStream ps, String sql2, String gameCode, String activity) throws IOException{
		if(file != null){
			if(file.isDirectory()){
				File[] fileList = file.listFiles();
				for(File f : fileList){
					readFile(f, ps, sql2, gameCode, activity);
				}
			}else{
				int lineNum = 0;
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				String fileName = file.getName().substring(0, file.getName().indexOf("."));
				String fileNames[] = fileName.split("-");
				fileName = fileNames[0];
				//String sequenceType = getType(fileName) + "";
				String sequenceType = "mlen";
				System.out.println(fileName + "_" + sequenceType);
				while ((line = br.readLine()) != null) {
					String mySql = sql2;
					String sequenceArray[] = line.split(",");
					String serialNumber = sequenceArray[0].trim();
					mySql = mySql.replace("serialNumber", serialNumber);
					mySql = mySql.replace("sequenceType", sequenceType);
					mySql = mySql.replace("gameCode", gameCode);
					mySql = mySql.replace("activity", activity);
					mySql = mySql.replace("msg", fileName);
					ps.println(mySql);
				}
			}
		}
	}
	
	public static int getType(String name) {
		int code = 0;
		if ("鑽石50".equals(name)) {
			code = 1;
		}else if ("鑽石100".equals(name)) {
			code = 2;
		}else if ("鑽石1000".equals(name)) {
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
			   ||"人形少女玲玲".equals(name) || "少女幻天姬".equals(name) || "死亡使者".equals(name) || "巫師維那".equals(name)
			   ||"武姬飛鳥".equals(name) || "學徒·灰者".equals(name) || "櫻之聲友美".equals(name) || "戰修女綾三".equals(name)
			   ||"中忍·春日".equals(name) ) {
			code = 10;
		}//随机4星卡
		else if ("暗黑天使洛林".equals(name) || "惡靈騎士賽斯".equals(name) || "海之歌友美".equals(name) || "河伯靈漪".equals(name)
				   ||"火武姬飛鳥".equals(name) || "火焰大師安娜".equals(name) || "劍俠曉".equals(name) || "精靈神射手凜".equals(name)
				   ||"刻印巫師維那".equals(name) || "人形殺手玲玲".equals(name) || "上忍·春日".equals(name) || "聖詩·安琪兒".equals(name)
				   ||"聖徒·輝者".equals(name) || "聖徒教官綾三".equals(name) || "死神".equals(name) || "銀瞳幻天姬".equals(name)
				   ||"戰鬥·靈兒".equals(name)) {
			code = 8;
		}//随机5星卡
		else if ("大劍豪·曉".equals(name) || "地獄死神".equals(name) || "復仇天使洛林".equals(name) || "灰星".equals(name)
				   ||"火姬神·飛鳥".equals(name) || "覺醒·靈兒".equals(name) || "淩光幻天姬".equals(name) || "龍王靈漪".equals(name)
				   ||"夢魘騎士賽斯".equals(name) || "夢之舞友美".equals(name) || "魔劍封印·維那".equals(name) || "木影·春日".equals(name)
				   ||"惹事人安娜".equals(name) || "閃耀爐心".equals(name) || "神弓·凜".equals(name) || "聖詠詩·安琪兒".equals(name)
				   ||"雙刃騎士·輝者".equals(name) ||"屠夫修女綾三".equals(name) || "最終兵器玲玲".equals(name) || "崇音".equals(name)
				   ||"米多利".equals(name) || "金獅子".equals(name)) {
			code = 4;
		}
		return code;
	}
	
}
