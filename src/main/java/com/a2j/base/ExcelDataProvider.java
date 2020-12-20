package com.a2j.base;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utility.ExcelUtils;




public class ExcelDataProvider extends InitMethod
{
	@DataProvider(name="multiSheetExcelRead")
	public static Object[][] multiSheetExcelRead(Method method) throws Exception
	{
		File file = new File("./A2J-Bankruptcypro-ui-tests/TestData/Excelfiles/TestData.xlsx");
		String SheetName = method.getName();
		System.out.println(SheetName);
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
		return testObjArray;
	}
	
	@DataProvider(name="excelSheetNameAsMethodName")
	public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception
	{
		File file = new File("E:\\V2J-Auto\\Bankruptcypro\\TestData\\Excelfiles\\"+method.getName()+".xlsx");
		System.out.println("Opening Excel File:" +file.getAbsolutePath());
		Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath());
		return testObjArray;
	}
}