package fileOperation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileMove {
	
	public static void main(String[] args) throws IOException {
		String path = "D:\\APP聚汇-切图";
		List<File> fileList = new ArrayList<File>(); 
		List<File> list = readFile(new File(path), fileList);
		for(File f : list){
			if("480".equals(f.getName()) ||
			   "720".equals(f.getName()) ||
			   "1080".equals(f.getName())){
				System.out.println(f);
			}
			System.out.println("other: " + f);
		}
	}
	
	/**
	 * 直接读取硬盘上的序列号文件来生成sql
	 * @param filePath
	 * @throws IOException
	 */
	public static List<File> readFile(File file, List<File> fileList) throws IOException{
		
		if(file != null){
			fileList.add(file);
			if(file.isDirectory()){
				File[] fileArray = file.listFiles();
				for(File f : fileArray){
					readFile(f, fileList);
				}
				
			}
		}
		return fileList;
	}
	
	
}
