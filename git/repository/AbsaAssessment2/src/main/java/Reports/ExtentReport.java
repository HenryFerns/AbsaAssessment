
/*##########################################################################################
'Class Name: ExtentReport.java
'Description: This class has methods for generating results
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/


package Reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport {
	
	static String path="Result/UserData.html";
	static ExtentReports logger= new ExtentReports(path,true);
	static ExtentTest logtest=logger.startTest("UserData");

	public static void HTMLReporter( String Test_Result,String Result_Description) 
	//This method logs results to the given path
	{
		if(Test_Result=="PASS")		
		{
			logtest.log( LogStatus.PASS,Result_Description);
		}
		else
		{ 
			logtest.log( LogStatus.FAIL,Result_Description);
		}
			
	}
	
	public static void PublishReport()
	//This method publishes the logged results
	{
		logger.endTest(logtest);
		logger.flush();
	}
	
}

