package com.joom.automation.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityForAdmin {
	public String getDataFromExcel(String sheetName, int rowNum, int celNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\priya\\git\\JoomProjectFramework\\JoomProject\\src\\test\\resources\\TestScriptData\\CategoryFields.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();

		return data;
	}

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\priya\\git\\JoomProjectFramework\\JoomProject\\src\\test\\resources\\TestScriptData\\CategoryFields.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return lastRowNum;

	}
	
		

}
