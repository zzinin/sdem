package utilities;

import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Central location for all TestNG data‑providers that read from Excel.
 * 
 *  •  Uses the thread‑unsafe ExcelUtil, so each method opens / closes
 *     the workbook in the same thread that TestNG calls the provider.
 *  •  Skips rows whose **ToRun** column equals "false".
 */
public class DataProviders {

   @DataProvider(name ="ContactData")
    public String [][] getData() throws IOException {

        String path=".\\testData\\Contact.xlsx";
 //      String sheetName="Sheet1";
     ExcelUtil xlutil=new ExcelUtil(path);
        int totalrows=xlutil.getRowCount("Sheet1");
        System.out.println("RowCount:"+totalrows);
        int totalcols=xlutil.getColumnCount("Sheet1",1);
        System.out.println("ColoumnCount:"+totalcols);
        String logindata[][]=new String[totalrows][totalcols];
        for(int i=1;i<=totalrows;i++)
        {
        	for (int j=0;j<totalcols;j++)
        	{
        		logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
        		//System.out.println("Data:"+s);
        	}
        	
        
        }
       
        return logindata;
       
    }
}

        
 