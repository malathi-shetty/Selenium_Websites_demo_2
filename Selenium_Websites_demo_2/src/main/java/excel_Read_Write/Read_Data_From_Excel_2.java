package excel_Read_Write;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data_From_Excel_2 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rows = sheet.getLastRowNum(); // Get the number of rows in the sheet
		System.out.println("Rows: " + rows);

		int columns = sheet.getRow(0).getLastCellNum(); // Get the number of columns in the first row
		System.out.println("Columns: " + columns);

		for (int i = 0; i <= rows; i++) {
			XSSFRow CurrentRow = sheet.getRow(i); // Access each row
			for (int j = 0; j < columns; j++) {
				String value = CurrentRow.getCell(j).toString(); // Get the cell value as a string
				System.out.print(value + "  \t"); // Print the cell value

			}
			System.out.println(); // Move to the next line after each row
		}
		workbook.close(); // Close the workbook to release resources
		fis.close(); // Close the file input stream
	}

}

/*
 * Open Excel File: FileInputStream is used to open the Excel file.
 * 
 * Read Workbook: XSSFWorkbook reads the workbook.
 * 
 * Access Sheet: getSheet("Sheet1") gets the specified sheet from the workbook.
 * 
 * Get Rows and Columns: getLastRowNum() and getRow(0).getLastCellNum() are used
 * to determine the number of rows and columns.
 * 
 * Read Data: Nested loops iterate over rows and columns to read and print cell
 * values.
 * 
 * 
 * 
 * 
 * 
 *
 * toString: Read Data in the form of String
 * 
 * asString(): Whenever we trying to print it will print into the String but not
 * convert into the string
 * 
 * toString(): The toString() method is used to get a string representation of
 * an object. It's like saying,
 * "Tell me something about this object in the form of a string." Every class in
 * Java inherits this method from the Object class, and it's often overridden to
 * provide a meaningful description of the object's state.
 * 
 * asString(): As Specific String Explanation: The asString() method is less
 * common in Java and not part of the standard library. It might be used in
 * certain libraries or custom code to convert an object to its string
 * representation, often implying that the conversion is done in a specific way
 * or context. Think of it as converting to a string in a particular format or
 * context.
 */