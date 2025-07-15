package excel_Read_Write;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data_From_Excel_3_1_differentFormats {

	public static void main(String[] args) {
		 String filePath = System.getProperty("user.dir") + "/src/test/java/excel_Read_Write/Cell.xlsx"; // Update the path to your file

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print("String cell: " + cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print("Date cell: " + cell.getDateCellValue());
                            } else {
                                System.out.print("Numeric cell: " + cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.print("Boolean cell: " + cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            CellValue cellValue = formulaEvaluator.evaluate(cell);
                            switch (cellValue.getCellType()) {
                                case STRING:
                                    System.out.print("Formula cell (evaluated as string): " + cellValue.getStringValue());
                                    break;
                                case NUMERIC:
                                    System.out.print("Formula cell (evaluated as numeric): " + cellValue.getNumberValue());
                                    break;
                                case BOOLEAN:
                                    System.out.print("Formula cell (evaluated as boolean): " + cellValue.getBooleanValue());
                                    break;
                                default:
                                    System.out.print("Formula cell (evaluated as other type)");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Other cell type");
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
