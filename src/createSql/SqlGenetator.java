package createSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class SqlGenetator {

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
		String sql1 = "INSERT INTO t_game_pay_blacklist(userid, userName, payEmail, channelType, createTime, modifiedTime, flag, ip) VALUES";
		String sql2 = "(userid, 'userName', 'payEmail', 'channelType', 'createTime', 'modifiedTime', 'flag', 'ip'),";

		File tof = new File("D:\\创建sql语句\\" + "sql语句" + ".sql");
		if(!tof.getParentFile().exists()){
			tof.getParentFile().mkdirs();
		}
		if (!tof.exists()) {
			tof.createNewFile();
		}
		
		PrintStream ps = new PrintStream(tof);
		ps.println(sql1);
		readFile(file, ps, sql2);
		ps.close();
		
		
	}
	
	public static void readFile(File file, PrintStream ps, String sql2) throws IOException{
		if(file != null){
			if(file.isDirectory()){
				File[] fileList = file.listFiles();
				for(File f : fileList){
					readFile(f, ps, sql2);
				}
			}else{
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				String fileName = file.getName().substring(0, file.getName().indexOf("."));
				String str[] = fileName.split("-");
				System.out.println(fileName);
				Map<String, String> map = new HashMap<String, String> ();
				while ((line = br.readLine()) != null) {
					map.put(str[0]+line, line);
				}
				for(Map.Entry<String, String> entry : map.entrySet()){
					String mySql = sql2;
					mySql = mySql.replace("userid", str[0]);
					mySql = mySql.replace("userName", str[1]);
					mySql = mySql.replace("payEmail", entry.getValue());
					mySql = mySql.replace("channelType", "paypal");
					mySql = mySql.replace("createTime", "2015-08-28 18:00:00");
					mySql = mySql.replace("modifiedTime", "2015-08-28 18:00:00");
					mySql = mySql.replace("flag", "是");
					mySql = mySql.replace("ip", "NULL");
					ps.println(mySql);
				}
			}
		}
	}
	
}
