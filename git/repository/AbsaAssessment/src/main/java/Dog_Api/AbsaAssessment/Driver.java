
/*##########################################################################################
'Class Name: Driver.java
'Description: This class determines the execution flow for the test using the Main method
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/

package Dog_Api.AbsaAssessment;
import Reports.ExtentReport;

public class Driver {

	public static int StatusCode;
	public static String url_All="https://dog.ceo/api/breeds/list/all";
	public static String AllBreeds;
	public static String BreedName="retriever";
	public static String url_Breed="https://dog.ceo/api/breed/retriever/list";
	public static String url_SubBreed="https://dog.ceo/api/breed/retriever/golden/images/random";

	
	public static void main(String[] args)
	{
		//The first step will be to check if the API call is successful.
	    DogApi.Verify_StatusCode(url_All);
	    
	    //Test1&2
		DogApi.Display_AllBreeds(url_All, BreedName);
		
		//Test3
		DogApi.Display_SubBreed(url_Breed);
		
		//Test4
		DogApi.Display_RandomImage(url_SubBreed);
		
		//Publish Final Report
		ExtentReport.PublishReport();
		

	}

}
