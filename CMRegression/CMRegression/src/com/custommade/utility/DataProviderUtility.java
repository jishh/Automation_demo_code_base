package com.custommade.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * 
 * @author anokh ClassName: DataProviderUtility Description: This class is for
 *         providing the data for the corresponding test method of testng.
 */
public class DataProviderUtility {
	static String fileName;
	static String keyword;

	/*
	 * Method Name: fileDataProvider() Description: This method reads the excel
	 * file and returns an arraylist to the corresponding testng method
	 */
	@DataProvider
	public static Iterator<Object[]> fileDataProvider(ITestContext context) {
		PropertyUtility propertyUtilityObj = new PropertyUtility();
		fileName = propertyUtilityObj.getProperty("Inputexcelfile");
		keyword = "Search keywords";
		ExcelUtility excelReadObj = new ExcelUtility();
		ArrayList<String> keywordArrayList = new ArrayList<String>();
		keywordArrayList = excelReadObj.getDataProvider(
				fileName, keyword);
		List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
		for (String userData : keywordArrayList) {
			dataToBeReturned.add(new Object[] { userData });
		}
		return dataToBeReturned.iterator();
	}
}
