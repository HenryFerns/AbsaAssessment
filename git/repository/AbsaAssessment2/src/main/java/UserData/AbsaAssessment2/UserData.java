
/*##########################################################################################
'Class Name: ReadDataFromExcel.java
'Description: This class has methods for creating New User with the given Data
'Prepared By: Henrita Fernandes
'Prepared On: 26/9/2018
'###########################################################################################*/


package UserData.AbsaAssessment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import Reports.ExtentReport;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

import java.text.*;
import java.util.List;


public class UserData {

	public static void SetUserData(String UData) throws InterruptedException
	//This Method reads the input data and creates the user with the given data
	{
		//Set the Variables
		String url="http://www.way2automation.com/angularjs-protractor/webtables/";
		String ChromeDriver ="Plugin/chromedriver.exe";
		
	    String[] UserData=UData.split(";");
		System.setProperty("webdriver.chrome.driver",ChromeDriver );
		WebDriver driver=new ChromeDriver();
		
		driver.get(url);
		Thread.sleep(2000);
		
		Boolean isDisplayed=driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']")).isDisplayed();
		if(isDisplayed=true)
		{
			ExtentReport.HTMLReporter("PASS","Validated that you are on User Table page");
		}
		else
		{
			ExtentReport.HTMLReporter("FAIL","Validated that you are NOT on User Table Page");
		}
		driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']")).click();
		
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(UserData[0]);
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(UserData[1]);
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(UserData[2]);
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(UserData[3]);
		
		driver.findElement(By.xpath("//input[@type='radio' and @value=15]")).click();
		
		WebElement Sel_RoleId=driver.findElement(By.xpath("//select[@name='RoleId']"));
		Select RoleId=new Select(Sel_RoleId);
		RoleId.selectByVisibleText(UserData[4]);
		
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(UserData[5]);
		Thread.sleep(2000);

		
		Boolean b=driver.findElement(By.xpath("//*[@name='Mobilephone']")).isEnabled();
		System.out.println(b);
		driver.findElement(By.xpath("//*[@name='Mobilephone']")).sendKeys(UserData[6]);
		
		driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();	
		Thread.sleep(2000);
		
		System.out.println("The user is added");
		driver.quit();
		
	}

}
