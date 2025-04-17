package actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworkLibrary.BasePage;
import pageobjects.Temporary_CL_ApprovalPage;

public class Action_241 extends BasePage{

	
	WebDriver driver;
	   
		  public void Temporary_CL_Approval() throws IOException, InterruptedException {
			  Temporary_CL_ApprovalPage TempCLApproval=new Temporary_CL_ApprovalPage(driver);
			  TempCLApproval.TemporaryCL_Approval();
			  
			  WebElement text = driver.findElement(By.xpath("//*[@id=\"tempCLApproval_execute\"]/div/div[2]/h4[1]"));
				System.out.println(text.getText());
				if (isDisplayed(text) == true) {
					CLLicencenumber = App_NO(driver, "//*[@id=\"tempCLApproval_execute\"]/div/div[2]/h4[1]");
					setdata("Temporary_ConductorLicenceNo", CLLicencenumber.substring(16,33).trim());
					
					WebElement text1 = driver.findElement(By.xpath("//*[@id=\"tempCLApproval_execute\"]/div/div[2]/h4[2]"));
					System.out.println(text1.getText());
					if (isDisplayed(text1) == true) {
						CLBadgenumber = App_NO(driver, "//*[@id=\"tempCLApproval_execute\"]/div/div[2]/h4[2]");
						setdata("Temporary_CLBadgeNo", CLBadgenumber.substring(14,32).trim());
						
				} else {
					System.out.println("Please Check Once");
				}}
			}
	
}

