package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {

    public String path;
    public FileInputStream fis = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public ExcelUtil(String path) {
        this.path = path;
    }

    /**
     * Returns the last row index in a sheet (0-based).
     */
    public int getRowCount(String sheetName) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            fis.close();
            throw new IOException("Sheet " + sheetName + " does not exist");
        }
        int lastRowIndex = sheet.getLastRowNum(); // 0-based last row index
        fis.close();
        workbook.close();
        return lastRowIndex;
    }

    /**
     * Returns the number of columns in a specified row.
     * (Usually header row index 0)
     */
    public int getColumnCount(String sheetName, int rowNum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            fis.close();
            workbook.close();
            throw new IOException("Sheet " + sheetName + " does not exist");
        }
        row = sheet.getRow(rowNum);
        if (row == null) {
            fis.close();
            workbook.close();
            throw new IOException("Row " + rowNum + " does not exist");
        }
        int cellCount = row.getLastCellNum(); // number of cells (1-based)
        fis.close();
        workbook.close();
        return cellCount;
    }

    /**
     * Returns the data from a cell as String.
     * Note: colNum and rowNum are 0-based indices here.
     */
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            fis.close();
            workbook.close();
            throw new IOException("Sheet " + sheetName + " does not exist");
        }
        row = sheet.getRow(rowNum);
        if (row == null) {
            fis.close();
            workbook.close();
            return "";
        }
        cell = row.getCell(colNum);
        if (cell == null) {
            fis.close();
            workbook.close();
            return "";
        }

        DataFormatter formatter = new DataFormatter();
        String cellValue = formatter.formatCellValue(cell);

        fis.close();
        workbook.close();

        return cellValue;
    }
}
