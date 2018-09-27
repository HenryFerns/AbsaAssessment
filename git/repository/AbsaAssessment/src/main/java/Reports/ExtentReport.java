
/*##########################################################################################
'Class Name: Reports.java
'Description: This class determines the execution flow for the test using the Main method
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/

package Reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport
//This method logs results to the given path

{
	//Set the result path
	static String path="Result/Dog-Api.html";
	
	static ExtentReports logger= new ExtentReports(path,true);
	static ExtentTest logtest=logger.startTest("Api");
	public static void HTMLReporter( String Test_Result,String Result_Description) 
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
