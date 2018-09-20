package com.qa.PracticeAssessment;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet Sheet;
	private static XSSFWorkbook ExcelBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void setExcelFile() {
		try {
			FileInputStream ExcelFile = new FileInputStream(Constants.PATH_TESTDATA + Constants.FILE_TESTDATA);
			ExcelBook = new XSSFWorkbook(ExcelFile);
			Sheet = ExcelBook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static XSSFSheet getExcelSheet() {
		return Sheet;
	}

	public static String getCellData(int RowNum, int ColNum) {
		try {
			Cell = Sheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void setCellData(String Result, int RowNum, int ColNum) {
		try {
			Row = Sheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.PATH_TESTDATA + Constants.FILE_TESTDATA);
			ExcelBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
