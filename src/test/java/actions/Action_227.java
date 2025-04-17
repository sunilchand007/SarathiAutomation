package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworkLibrary.BasePage;
import pageobjects.CL_EndorsementApprovalPage;

public class Action_227 extends BasePage{

	
	WebDriver driver;

	   public void CL_EndorsementApproval() {
		   CL_EndorsementApprovalPage CLApproval=new CL_EndorsementApprovalPage(driver);
		   CLApproval.Clickon_CL_EndorsementApproval();
			//*[@id="redirect"]/div/div[1]/h4
			WebElement text = driver.findElement(By.xpath("//*[@id=\"redirect\"]/div/div[1]/h4"));
			System.out.println(text.getText());
			if (isDisplayed(text) == true) {
				CLLicencenumber = App_NO(driver, "//*[@id=\"redirect\"]/div/div[1]/h4");
				setdata("CLEndorsementNo", CLLicencenumber.substring(61,84).trim());
			} else {
				System.out.println("Please Check Once");
			}
	   }
}
