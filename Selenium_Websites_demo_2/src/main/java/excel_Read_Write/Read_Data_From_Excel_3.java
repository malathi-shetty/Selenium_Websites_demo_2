package excel_Read_Write;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data_From_Excel_3 {

	public static void main(String[] args) {
		 String filePath = System.getProperty("user.dir") + "/src/test/java/excel_Read_Write/Cell.xlsx"; // Update the path to your file

	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                         //   System.out.print("String cell: " + cell.getStringCellValue() + "\t");
	                            System.out.print(cell.getStringCellValue() + "\t");
	                            break;
	                        case NUMERIC:
	                            if (DateUtil.isCellDateFormatted(cell)) {
	                          //      System.out.print("Date cell: " + cell.getDateCellValue() + "\t");
	                                System.out.print(cell.getDateCellValue() + "\t");
	                            } else {
	                            //    System.out.print("Numeric cell: " + cell.getNumericCellValue() + "\t");
	                                System.out.print( cell.getNumericCellValue() + "\t");
	                            }
	                            break;
	                        case BOOLEAN:
	                        //    System.out.print("Boolean cell: " + cell.getBooleanCellValue() + "\t");
	                        	 System.out.print(cell.getBooleanCellValue() + "   \t");
	                            break;
	                        case FORMULA:
	                         //   System.out.print("Formula cell: " + cell.getCellFormula() + "\t");
	                            System.out.print( cell.getCellFormula() + "    \t");
	                            break;
	                        default:
	                            System.out.print("Other cell type: " + "    \t");
	                            break;
	                    }
	                    
	                }
	                System.out.println();
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}



/*
File Input: FileInputStream is used to open the Excel file.

Workbook and Sheet: The XSSFWorkbook class is used for .xlsx files. Use HSSFWorkbook for .xls files. The code retrieves the first sheet of the workbook.

Iteration: The code iterates through each row and cell in the sheet.

Cell Type Handling:

STRING: Retrieves and prints the string value of the cell.

NUMERIC: Checks if the numeric cell is a date and handles it accordingly. Otherwise, it prints the numeric value.

BOOLEAN: Retrieves and prints the boolean value.

FORMULA: Prints the formula contained in the cell.

Exception Handling: Catches and prints any IOException that may occur during file operations.
 */
