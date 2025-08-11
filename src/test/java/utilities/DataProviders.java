package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

/**
 * DataProviders class to supply test data from Excel sheets for TestNG tests.
 */
public class DataProviders {

    @DataProvider(name = "ContactData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\LoginDetails.xlsx";
        ExcelUtil xlutil = new ExcelUtil(path);

        int totalRows = xlutil.getRowCount("Sheet1");
        System.out.println("RowCount: " + totalRows);

        int totalCols = xlutil.getColumnCount("Sheet1", 1);
        System.out.println("ColumnCount: " + totalCols);

        String[][] loginData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return loginData;
    }

    @DataProvider(name = "ContactData1")
    public String[][] getData1() throws IOException {

        String path = ".\\testData\\LoginDetails.xlsx";
        ExcelUtil xlutil = new ExcelUtil(path);

        int totalRows = xlutil.getRowCount("Sheet2");
        System.out.println("RowCount: " + totalRows);

        int totalCols = xlutil.getColumnCount("Sheet2", 1);
        System.out.println("ColumnCount: " + totalCols);

        String[][] loginData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet2", i, j);
            }
        }
        return loginData;
    }
}


        
 


