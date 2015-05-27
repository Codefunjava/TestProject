package createSql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class SqlAhlm_2006 {

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
		String activity = "2009";
		String gameCode = "ahlm";
		
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
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";
				String fileName = file.getName().substring(0, file.getName().indexOf("."));
				String fileNames[] = fileName.split("-");
				fileName = fileNames[0];
				//String sequenceType = getType(fileName) + "";
				String sequenceType = fileNames[1];
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
	
}
