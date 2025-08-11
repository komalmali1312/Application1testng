package com.orange.hrm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static List<Map<String, String>> ReadExcelDatausingCollection(String fileName, String sheetName) {
		// Declare one List in which we are Storing all Maps Data.
		List<Map<String, String>> Exceldata1 = new ArrayList<>();

		try {
			// Read Excel File
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);
			// Load file in Excel
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// Take data from Specific sheet
			XSSFSheet sh = wb.getSheet(sheetName);
			// Check Total Number of Rows and Total no.of columns
			int TotalRows = sh.getPhysicalNumberOfRows();
			int TotalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			// loop
			for (int r = 1; r < TotalRows; r++) {
				Map<String, String> Eachrowdata = new HashMap<>();
				for (int c = 0; c < TotalColumns; c++) {
					String ColumnName = sh.getRow(0).getCell(c).getStringCellValue();
					String ColumnValue = sh.getRow(r).getCell(c).getStringCellValue();

					Eachrowdata.put(ColumnName, ColumnValue);

				}
				Exceldata1.add(Eachrowdata);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return Exceldata1;

	}
	
//second way using 2 Dimensional Array
	public static String[][] ReadExcelDatausing2DArray(String fileName, String sheetName) {
		// Declare one List in which we are Storing all Maps Data.
		String[][]Exceldata2=null;

		try {
			// Read Excel File
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);
			// Load file in Excel
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// Take data from Specific sheet
			XSSFSheet sh = wb.getSheet(sheetName);
			// Check Total Number of Rows and Total no.of columns
			int TotalRows = sh.getPhysicalNumberOfRows();
			int TotalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			Exceldata2=new String[TotalRows][TotalColumns];
			//iterate thr 2d array using for loop
			for(int r=1;r<TotalRows;r++)
			{
				for(int c=0;c<TotalColumns;c++)
				{
					String CellValue=sh.getRow(r).getCell(c).getStringCellValue();
					Exceldata2[r-1][c]=CellValue;
				}
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
			return Exceldata2;
		
	}
}
