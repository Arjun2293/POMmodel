package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtill {
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\Resources\\TestData.xlsx");

	@DataProvider(name = "dp1")
	public Object[][] getdata(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;

	}

}
