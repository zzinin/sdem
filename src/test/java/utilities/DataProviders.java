package utilities;

import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DataProviders {

   @DataProvider(name ="ContactData")
    public String [][] getData() throws IOException {

        String path=".\\testData\\LoginDetails.xlsx";
 //      String sheetName="Sheet1";
     ExcelUtil xlutil=new ExcelUtil(path);
        int totalrows=xlutil.getRowCount("Sheet1");
        System.out.println("RowCount:"+totalrows);
        int totalcols=xlutil.getColumnCount("Sheet1",1);
        System.out.println("ColoumnCount:"+totalcols);
        String[][] logindata=new String[totalrows][totalcols];
        for(int i=1;i<=totalrows;i++)
        {
        	for (int j=0;j<totalcols;j++)
        	{
        		logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
        		//System.out.println("Data:"+s);
        		
        	}
        	
 //       	System.out.println("Row " + i + ": " + Arrays.toString(logindata[i - 1]));
        }
       
        return logindata;
    }
   
   
   @DataProvider(name ="ContactData1")
   public String [][] getData1() throws IOException {

       String path=".\\testData\\LoginDetails.xlsx";
//      String sheetName="Sheet1";
    ExcelUtil xlutil=new ExcelUtil(path);
       int totalrows=xlutil.getRowCount("Sheet2");
       System.out.println("RowCount:"+totalrows);
       int totalcols=xlutil.getColumnCount("Sheet2",1);
       System.out.println("ColoumnCount:"+totalcols);
       String[][] logindata=new String[totalrows][totalcols];
       for(int i=1;i<=totalrows;i++)
       {
       	for (int j=0;j<totalcols;j++)
       	{
       		logindata[i-1][j]=xlutil.getCellData("Sheet2", i, j);
       		//System.out.println("Data:"+s);
       		
       	}
       	
//       	System.out.println("Row " + i + ": " + Arrays.toString(logindata[i - 1]));
       }
      
       return logindata;
   }   
   
   
   
}

        
 


