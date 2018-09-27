/*##########################################################################################
'Class Name: DogApi.java
'Description: This class contains all methods for testing Dog-Api
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/

package Dog_Api.AbsaAssessment;

import org.testng.Assert;
import Reports.ExtentReport;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class  DogApi
 
{

	public static void Verify_StatusCode(String url)
	//This method will verify if the API request is successful or not
	{
		Response rep =RestAssured.get(url);
		int StatusCode=rep.statusCode();
		System.out.println(StatusCode);	
		Assert.assertEquals(StatusCode, 200,"ERROR:The requested Dog-Api cannot be reached");
		if(StatusCode==200)
		{ 
			ExtentReport.HTMLReporter("PASS", "The requested Dog-Api is reached successfully");
		}
		else
		{
			ExtentReport.HTMLReporter("FAIL", "ERROR:The requested Dog-Api cannot be reached");
		}
		
	}

	public static  void Display_AllBreeds(String url,String BreedName)
	// This method will perform an API request to produce a list of all dog breeds. (Diagram 1) AND
	// Verify “retriever” breed is within the list. (Diagram 2)
	{
		
		Response rep =RestAssured.get(url);
		String AllBreeds=rep.jsonPath().getString("message");
		System.out.println(AllBreeds);
		
		int leng=AllBreeds.length();
	
		if(leng>0)
		{
			ExtentReport.HTMLReporter("PASS","List of Dog Breeds" + AllBreeds);
		}
		else
		{
			ExtentReport.HTMLReporter("FAIL","No Dogs found on the List");
		}
			
			
		Assert.assertTrue(AllBreeds.contains(BreedName),"FAIL:Retriever is not present in the Dog Breed List");
		
		if(AllBreeds.contains(BreedName))
		{
			ExtentReport.HTMLReporter("PASS","Retriever is present in the Dog Breed List");
		}
		else
		{
			ExtentReport.HTMLReporter("FAIL","Retriever is NOT present in the Dog Breed List");	
		}
	
	}
	
	
	public static void Display_SubBreed(String url)
	// This method will Perform an API request to produce a list of sub-breeds for “retriever”. (Diagram 3)
	{
		Response respon=RestAssured.get(url);
		String SubBreed=respon.jsonPath().getString("message");
		
		System.out.println(SubBreed);
		int leng=SubBreed.length();
		if(leng>0)
		{
			ExtentReport.HTMLReporter("PASS","List of Dog Sub-Breeds" + SubBreed);
		}
		else
		{
			ExtentReport.HTMLReporter("FAIL","No Dogs found on the Dog Sub-Breed List");
		}		
			
	}
	
	public static void Display_RandomImage(String url)
	//This method will perform an API request to produce a random image / link for the sub-breed “golden”(Diagram4)
	{
		Response respon=RestAssured.get(url);
		String RandomImage=respon.jsonPath().getString("message");
		
		System.out.println(RandomImage);
		int leng=RandomImage.length();
		if(leng>0)
		{
			ExtentReport.HTMLReporter("PASS","Random Image/Link for Sub-Breed Golden" + RandomImage);
		}
		else
		{
			ExtentReport.HTMLReporter("FAIL","No Random Image/Link found for Sub-Breed Golden");
		}		
	}


}
