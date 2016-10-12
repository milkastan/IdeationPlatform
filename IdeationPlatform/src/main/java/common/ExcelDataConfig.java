package common;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet 	sh1;
	
	public ExcelDataConfig(String excelPath)
	{
		 try {
			File src=new File(excelPath);
			  // load file
			 FileInputStream fis=new FileInputStream(src);
			 
			// Load workbook
			 wb=new XSSFWorkbook(fis);
			 
			 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetNumber, int row, int column)
	{
		sh1= wb.getSheetAt(sheetNumber);
		
		String data = sh1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
}
