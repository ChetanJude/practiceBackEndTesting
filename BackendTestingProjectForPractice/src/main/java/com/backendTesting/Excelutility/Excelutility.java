package com.backendTesting.Excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * read data from Excel baed on row and column index
 * @author chandan
 * @param sheetName
 * @param row
 * @param cell
 * @return
 * @throws Throwable
 */
public class Excelutility {

	String testDataPath = "C:\\Users\\chetan\\OneDrive\\Desktop\\testscript.xlsx";
	
	public String getDataFromExcelFile(String sheetName,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * get the used row count based on sheetName
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDatatoExcel(String sheetName,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell);
		FileOutputStream fos=new FileOutputStream(testDataPath);
		wb.write(fos);
		wb.close();
	}

	
}
