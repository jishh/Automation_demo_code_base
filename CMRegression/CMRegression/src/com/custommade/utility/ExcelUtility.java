package com.custommade.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.custommade.configure.General;

/**
 * 
 * @author anokh ClassName: ExcelUtility Description: This class is to interact
 *         with the excel sheet such as reading from an excel file, writing to
 *         an excel file
 */
public class ExcelUtility {
	private static int counter;
	private static ArrayList<String> searchKeywordArrayList = new ArrayList<String>();
	private static String keywordValue = null;

	/*
	 * Method Name: excelReadMethodForDataProvider() Description: This function
	 * returns an arraylist of data by passing the filename and the keyword
	 */
	public ArrayList<String> getDataProvider(String fileName,
			String testCaseCellLabel) {
		try {
			Workbook workBook = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = workBook.getSheet("Keywords");
			testCaseCellLabel = "Search keywords";
			LabelCell cellLabelObj = sheet.findLabelCell(testCaseCellLabel);
			int columnNumber = cellLabelObj.getColumn();
			int rowNumber = cellLabelObj.getRow();
			rowNumber++;
			for (counter = 1; counter < sheet.getRows(); counter++) {
				Cell keywordHeadingCell = sheet
				.getCell(columnNumber, rowNumber);
				String keyword = keywordHeadingCell.getContents();
				rowNumber = counter + 1;
				searchKeywordArrayList.add(keyword);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchKeywordArrayList;
	}

	/*
	 * Method Name: excelReadMethodForUtility() Description: This function
	 * returns a string data (keyword value) the keyword
	 */
	public static String getValueForKeyword(String keyword,
			String excelSheetName) throws BiffException, IOException {
		if (General.workbook != null) {
			int count = 0;
			keywordValue = null;
			while (keywordValue == null) {
				try {
					Sheet sheet = General.workbook.getSheet(excelSheetName);
					LabelCell cellLabelObj = sheet.findLabelCell(keyword);
					int columnNumber = cellLabelObj.getColumn();
					int rowNumber = cellLabelObj.getRow();
					int columnNumberNew = columnNumber + 1;
					Cell keywordHeadingCell = sheet.getCell(columnNumberNew, rowNumber);
					keywordValue = keywordHeadingCell.getContents();
					count++;
					if (count >= 20) {
						break;
					}
				} catch (Exception e) {
					keywordValue = null;
				}
			}
		}
		return keywordValue;
	}

	public static Workbook getWorkbook() {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(PropertyUtility.getProperty("Inputexcelfile")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

}
