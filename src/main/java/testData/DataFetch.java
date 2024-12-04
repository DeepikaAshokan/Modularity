package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFetch {

	String FileLocation = "C:\\Users\\admin\\eclipse-workspace\\demoWebShop\\target\\Studentsdetails.xlsx";
	List<String> UserData = new ArrayList<String>();
	String CellData;

	public List<String> fetchAllDataExcel(String Sheetname) throws IOException {

		FileInputStream fis = new FileInputStream(FileLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(Sheetname);
		System.out.println(sheet.getLastRowNum());

		Iterator<Row> rows = sheet.rowIterator();
		int counter = 1;
		while (rows.hasNext()) {
			Row row = rows.next();

			Iterator<Cell> cells = row.iterator();
			Cell cell = row.getCell(1);
			// String value = cell.getStringCellValue();
			while (cells.hasNext()) {
				Cell cellvalue = cells.next();
				CellData = cellvalue.getStringCellValue();
				System.out.println(CellData + "  ");
				UserData.add(CellData);
				counter++;
			}
			System.out.println(" ");
		}
		System.out.println(counter);
		workbook.close();
		return UserData;
	}

	public List<String> fetchSpecificDataExcel(String sheetname, int rowno) throws IOException {
		FileInputStream fis = new FileInputStream(FileLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();

		XSSFRow row = sheet.getRow(rowno);
		Iterator<Cell> cells = row.cellIterator();
		while (cells.hasNext()) {
			Cell cellvalue = cells.next();
			CellData = cellvalue.getStringCellValue();
			System.out.println(CellData + " ");
			UserData.add(CellData);
		}
		workbook.close();
		return UserData;

	}

	public void writeTOExcel(String sheetname, String Email) throws IOException {
		FileInputStream fis = new FileInputStream(FileLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		XSSFRow row = sheet.createRow(lastrow + 1);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(Email);
		FileOutputStream fos = new FileOutputStream(FileLocation);
		workbook.write(fos);

	}

	public List<String> readDataFromExcel(String sheetName) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Users\\admin\\eclipse-workspace\\demoWebShop\\target\\Studentsdetails.xlsx");

		XSSFSheet sheet = book.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();

		int columnCount = sheet.getRow(0).getLastCellNum();

		// String[][] data = new String[rowCount][columnCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < columnCount; j++) {

				XSSFCell cell = row.getCell(j);

				CellData = cell.getStringCellValue();

				System.out.println(CellData + " ");

				UserData.add(CellData);

			}
		}

		book.close();
		return UserData;
	}

}
