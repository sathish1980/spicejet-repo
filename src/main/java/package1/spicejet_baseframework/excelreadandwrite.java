package package1.spicejet_baseframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class excelreadandwrite {

	public static String[][] excelreaddata(String filepath,String fileName,String sheetName ) throws IOException
	{
		int columncount = 0;
		
		String[][] excevaluedata=null;
        File file =    new File(filepath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        HSSFWorkbook guru99Workbook = null;
        
        guru99Workbook = new HSSFWorkbook(inputStream);
        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file
/*
        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        guru99Workbook = new HSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            guru99Workbook = new XSSFWorkbook(inputStream);
        }*/
            //Read excel sheet by sheet name    

            HSSFSheet sheet = guru99Workbook.getSheet(sheetName);

            //Get the current count of rows in excel file

            int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
            //Get the last used row count of rows in excel file
//This method will ignore empty rows, e.g. if a sheet last row is at row 7, but second row is empty, getPhysicalNumberOfRows()  will return 6.
            int las_rowCount = sheet.getPhysicalNumberOfRows();
           int columncount_1=sheet.getRow(0).getLastCellNum() ;
            excevaluedata=new String[las_rowCount][columncount_1];

            for(int i=0;i<las_rowCount;i++)
            {
            //Get the first row from the sheet

            	HSSFRow row = sheet.getRow(i);
            ///find totatl column
            columncount=row.getLastCellNum();
            
            for(int j=0;j<columncount;j++)
            {
            
            	HSSFCell cell =row.getCell(j);
            	cell.setCellType(CellType.STRING);
            	///converting the cell in to string
            	excevaluedata[i][j]=cell.toString();
            	System.out.println(excevaluedata[i][j]);
            	
            }

        }  
         
            inputStream.close();
            return excevaluedata;    
          
	}


}
