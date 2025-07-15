package excel_Read_Write;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data_From_Excel_1_learn {

	public static void main(String[] args) throws IOException {

		// filepath if inside the package
		// String excelFilePath =(System.getProperty("user.dir") +
		// "/src/test/java/excel_Read_Write/data.xlsx");

		// filepath if outside the package
		String excelFilePath = "data.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		/*
		 * int rows = sheet.getLastRowNum(); // Get the number of rows in the sheet
		 * System.out.println("Total Rows: " + rows);
		 * 
		 * int columns = sheet.getRow(0).getLastCellNum(); // Get the number of columns
		 * in the first row System.out.println("Total Columns: " + columns);
		 * 
		 * String data=sheet.getRow(3).getCell(0).getStringCellValue();
		 * System.out.println("Row_3 Column_0 Data in Excel Sheet: " + data);
		 * 
		 */
		DataFormatter dataFormatter = new DataFormatter();

		// Iterate through each row
		for (Row row : sheet) {
			// Iterate through each cell
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			}
			System.out.println(); // Move to the next line
		}

	}

}
