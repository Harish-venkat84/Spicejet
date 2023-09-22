package com.spicejet.excel_reader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	static XSSFWorkbook workbook;
	
	static XSSFSheet workSheet;
	
	static XSSFRow row;
	
	// This constructor is used to load the excel file	
	public ExcelFileReader() {
		
		try {
			
			workbook = new XSSFWorkbook(System.getProperty("user.dir")+"\\ExcelFiles\\Signup_TestData.xlsx");
		
			workSheet = workbook.getSheetAt(0);
			
		} catch (Exception e) {
			
			System.out.println("problem on Excel file loading to XSSFWorkbook class");
			
			e.printStackTrace();
		}
		
		
	}
	
	// This method is used to get values from the excel file
	public String getValueFromExcel(int rowIndex, int cellIndex) {
		
		XSSFCell cell = null;
		
		try {
			
			row = workSheet.getRow(rowIndex);
			
			cell = row.getCell(cellIndex);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return cell.toString();
	}
	
	public static void main(String[] args) {
		
		ExcelFileReader obj = new ExcelFileReader();
		
		System.out.println(obj.getValueFromExcel(5,1));
	}
}
