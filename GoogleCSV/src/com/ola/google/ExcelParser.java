package com.ola.google;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Reference: https://gist.github.com/madan712/3912272

public class ExcelParser {
		
	public static List<String> readXLSXFile() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream("/Users/jayati.singhal/Downloads/GoogleInput.xlsx");
		List<String> list = new ArrayList<String>();
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook(); 
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		Iterator rows = sheet.rowIterator();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					list.add(cell.getStringCellValue());
				}
			}
		}
		return list;	
	}
	
	public static void writeXLSXFile(List<String> list) throws IOException {
		
		String excelFileName = "/Users/jayati.singhal/Downloads/GoogleOuput.xlsx";//name of excel file

		String sheetName = "Response";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
		
//	  for (int i = 0; i < list.size(); i++) {
//		  XSSFRow row = sheet.createRow(i);
//		  XSSFCell cell = row.createCell(1);
//		  String json = list.get(i);
//		  cell.setCellValue(json);
//	}
	  
	  for (int i = 0; i < list.size(); i++) {
		  String json = list.get(i);
		  XSSFRow row = sheet.createRow(i);
		  XSSFCell cell1 = row.createCell(1);
		  cell1.setCellValue(json);
	}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public static void writeXLSXFileLBS(List<LBSResponse> list) throws IOException {
		
		String excelFileName = "/Users/jayati.singhal/Downloads/LBSOuput.xlsx";//name of excel file

		String sheetName = "LBSResponse";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
		
	  for (int i = 0; i < list.size(); i++) {
		  LBSResponse json = list.get(i);
		  XSSFRow row = sheet.createRow(i);
		  XSSFCell cell0 = row.createCell(0);
		  XSSFCell cell1 = row.createCell(1);
		  XSSFCell cell2 = row.createCell(2);
		  XSSFCell cell3 = row.createCell(3);
		  cell0.setCellValue(json.getLatLong());
		  cell1.setCellValue(json.getFormatted_address());
		  if(json.getLandmark()!=null)
		  cell2.setCellValue((String)json.getLandmark().get("name"));
		  if(json.getLocality()!=null)
		  cell3.setCellValue((String)json.getLocality().get("name"));
	}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

}