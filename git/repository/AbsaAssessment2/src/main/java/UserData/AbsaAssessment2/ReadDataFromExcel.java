
/*##########################################################################################
'Class Name: ReadDataFromExcel.java
'Description: This class has methods for reading User Data from Excel 
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/


package UserData.AbsaAssessment2;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel 
{
	public static String Read() throws Exception
	//This method user reads data from Excel and returns in form of STring
	{
		try
		{
		
		 String FilePath="TestData/UserData.xlsx";
	
	     File src=new File(FilePath);
	     
	     FileInputStream fis=new FileInputStream(src);
	     
	     XSSFWorkbook wb=new XSSFWorkbook(fis);
	     
	     XSSFSheet sheet1=wb.getSheetAt(0);
	    // XSSFRow nRow=sheet1.getRow(0);
	     //int nCol=nRow.getLastCellNum();
	     
	     String FName=sheet1.getRow(1).getCell(0).getStringCellValue();
	     
	     String LName=sheet1.getRow(1).getCell(1).getStringCellValue();
	     
	    
	     String UName=sheet1.getRow(1).getCell(2).getStringCellValue();
	     
	     
	     String Password=sheet1.getRow(1).getCell(3).getStringCellValue();
	     
	     
	     String RoleId=sheet1.getRow(1).getCell(4).getStringCellValue();
	     
	     
	     String Email=sheet1.getRow(1).getCell(5).getStringCellValue();
	     
	     
	     String MobNo=sheet1.getRow(1).getCell(6).getStringCellValue();
	     
	     String Output;
	     Output=FName+";"+LName+";"+UName+";"+Password+";"+RoleId+";"+Email+";"+MobNo;
		 return Output;
		}
		
		catch(Exception e)
		{
		System.out.println(e);
		}
		return null;
	      
	}
     
}
