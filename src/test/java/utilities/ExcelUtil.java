package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

/**
 * Utility class for reading data from Excel files using Apache POI.
 */
public class ExcelUtil {

    private final String path;
    private FileInputStream fis;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    /**
     * Constructor to set the Excel file path.
     *
     * @param path Path to the Excel file
     */
    public ExcelUtil(String path) {
        this.path = path;
    }

    /**
     * Returns the total number of rows in the given sheet.
     *
     * @param sheetName Name of the sheet
     * @return Number of rows (1-based)
     * @throws IOException If the sheet doesn't exist or file can't be read
     */
    public int getRowCount(String sheetName) throws IOException {
        openSheet(sheetName);
        int lastRowIndex = sheet.getLastRowNum();
        closeWorkbook();
        return lastRowIndex;
    }

    /**
     * Returns the total number of columns in the given row of a sheet.
     *
     * @param sheetName Name of the sheet
     * @param rowNum    Row index (0-based)
     * @return Number of columns (1-based)
     * @throws IOException If the sheet or row doesn't exist
     */
    public int getColumnCount(String sheetName, int rowNum) throws IOException {
        openSheet(sheetName);
        row = sheet.getRow(rowNum);
        if (row == null) {
            closeWorkbook();
            throw new IOException("Row " + rowNum + " does not exist");
        }
        int cellCount = row.getLastCellNum();
        closeWorkbook();
        return cellCount;
    }

    /**
     * Retrieves cell data as a String from the given sheet, row, and column.
     *
     * @param sheetName Name of the sheet
     * @param rowNum    Row index (0-based)
     * @param colNum    Column index (0-based)
     * @return Cell value as String (empty if cell is blank)
     * @throws IOException If the sheet doesn't exist
     */
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        openSheet(sheetName);
        row = sheet.getRow(rowNum);
        if (row == null) {
            closeWorkbook();
            return "";
        }
        cell = row.getCell(colNum);
        if (cell == null) {
            closeWorkbook();
            return "";
        }

        String cellValue = new DataFormatter().formatCellValue(cell);
        closeWorkbook();
        return cellValue;
    }

    /**
     * Helper method to open an Excel sheet.
     */
    private void openSheet(String sheetName) throws IOException {
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            closeWorkbook();
            throw new IOException("Sheet " + sheetName + " does not exist");
        }
    }

    /**
     * Helper method to close workbook and input stream.
     */
    private void closeWorkbook() throws IOException {
        if (workbook != null) workbook.close();
        if (fis != null) fis.close();
    }
}
