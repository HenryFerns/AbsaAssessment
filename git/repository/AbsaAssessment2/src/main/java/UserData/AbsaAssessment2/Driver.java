
/*##########################################################################################
'Class Name: Driver.java
'Description: This class determines the execution flow for the test using the Main method
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/

package UserData.AbsaAssessment2;

import Reports.ExtentReport;

public class Driver {

	public static void main(String[] args) throws Exception 
	{
		//Read the UserData from Source
		String UData=ReadDataFromExcel.Read();
		
		//Pass the UserData and Add the New User
		UserData.SetUserData(UData);	
		
		ExtentReport.PublishReport();

	}

}
