package fileOperation;

import java.io.File;
import java.io.IOException;

public class FileRename {
	
	public static void main(String[] args) throws IOException {
		String path = "D:\\APP聚汇-切图";
		readFile(new File(path));
	}
	
	/**
	 * 直接读取硬盘上的序列号文件来生成sql
	 * @param filePath
	 * @throws IOException
	 */
	public static void readFile(File file) throws IOException{
		if(file != null){
			if(file.isDirectory()){
				File[] fileList = file.listFiles();
				for(File f : fileList){
					readFile(f);
				}
			}else{
				String parentPath = file.getParent();
				System.out.println("parentPath : " + parentPath);
				String fileName = file.getName().substring(0, file.getName().indexOf("."));
				String backName = file.getName().substring(file.getName().indexOf("."));
				if("720".equals(file.getParentFile().getName())){
					String fullFileName =  parentPath + File.separator + fileName + "@2x" + backName;
					file.renameTo(new File(fullFileName));
					System.out.println(fullFileName);
				}else if("1080".equals(file.getParentFile().getName())){
					String fullFileName =  parentPath + File.separator + fileName + "@3x" + backName;
					file.renameTo(new File(fullFileName));
					System.out.println(fullFileName);
				}
			}
		}
	}
	
	
}
