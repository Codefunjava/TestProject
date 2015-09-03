package com.fcy.excel.test01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {
	public static void exportFromObjectData(List<Object[]> data,OutputStream out) throws IOException, ParseException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		XSSFCellStyle cellStyle = (XSSFCellStyle) wb.createCellStyle();
		XSSFDataFormat format = (XSSFDataFormat) wb.createDataFormat();
		Row r;
		for (int i = 0; i < data.size(); i++) {
			r = sheet.createRow(i);
			for (int j = 0; j < data.get(i).length; j++) {
				Cell cell = r.createCell(j);
				if (data.get(i)[j] instanceof String) {
					cell.setCellValue((String) data.get(i)[j]);
				}
				if (data.get(i)[j] instanceof Double
						|| data.get(i)[j] instanceof Float
						|| data.get(i)[j] instanceof Integer
						|| data.get(i)[j] instanceof Long)
				{
					cell.setCellValue(Double.valueOf(data.get(i)[j].toString()));
				}
				if (data.get(i)[j] instanceof Date) {
					cell.setCellValue((Date)data.get(i)[j]);
					cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
					cell.setCellStyle(cellStyle);
				}
			}
		}
		wb.write(out);
	}
	
	public static List<Object[]> generatorData() {
		List<Object[]> list = new ArrayList<Object[]> ();
		Object[] head = {"int","long","float","doult","String","char","String", "date"};
		list.add(head);
		for(int i = 0; i < 6; i++) {
			Object[] obj = {1, 2L, 3F, 4D, "5", '6', "abc", new Date()};
			list.add(obj);
		}
		return list;
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		File file = new File("D:\\创建sql语句\\hehe.xls");
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		OutputStream out = null;
		try{
			//out = new FileOutputStream(file, true);
			out = new FileOutputStream(file);
			exportFromObjectData(generatorData(), out);
		}finally{
			out.flush();
			out.close();
		}
		System.out.println("运行完成！");
		
	}
	
	
}
