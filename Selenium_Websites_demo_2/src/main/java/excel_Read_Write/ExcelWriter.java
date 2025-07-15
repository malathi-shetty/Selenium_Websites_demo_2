package excel_Read_Write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String excelFilePath = "data1.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook(); //Creates a new Excel workbook (in .xlsx format for Excel 2007 and later).
		XSSFSheet sheet = workbook.createSheet("Sheet1");//Creates a new sheet named "Sheet1" in the workbook.
		
		// Create a header row
		Row headerRow = sheet.createRow(0); //Creates the header row at index 0.
		String[] columns = {"ID", "Name", "Age", "Email"};
		for(int i=0; i<columns.length; i++)
			{
			 Cell cell = headerRow.createCell(i);
			 cell.setCellValue(columns[i]);
			}
		
		//Create data rows
		Object[][] data = 
			{
					{1, "John Doe", 30, "john.doe@example.com"},
					{2, "Jane Smith", 25, "jane.smith@example.com"},
					{3, "Mike Wilson", 35, "mike.wilson@example.com"}
			};
		
		int rowNum =1;
		for(Object[] rowData : data)
		{
			Row row = sheet.createRow(rowNum++);
			
			int colNum = 0;
			for(Object field : rowData)
			{
				Cell cell = row.createCell(colNum++);
				if(field instanceof String)
				{
					cell.setCellValue((String)field) ;
				}
				else if (field instanceof Integer)
				{
					cell.setCellValue((Integer)field);
				}
			} 
			
		}
		
		//Write the output to a file
		try(FileOutputStream outputStream = new FileOutputStream(excelFilePath))
		{
			workbook.write(outputStream);
			System.out.println("Excel file written successfully.");
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
