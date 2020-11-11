package com.demo.datadrivenexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestExample {

	public static void main(String[] args) throws IOException {
		FileInputStream filePath = new FileInputStream("D://DataDrivenCheck.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(filePath);
		int countOfSheetInDocument = workBook.getNumberOfSheets();
		System.out.println(countOfSheetInDocument);
		for (int i = 0; i < countOfSheetInDocument; i++) {
			if (workBook.getSheetName(i).equalsIgnoreCase("data")) {
				XSSFSheet sheet = workBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("def")) {

					}
				}
			}
		}
	}
}
