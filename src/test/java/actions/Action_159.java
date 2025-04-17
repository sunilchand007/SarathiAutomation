package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import frameworkLibrary.BasePage;
import pageobjects.CL_CLApprovalPage;

public class Action_159 extends BasePage{
	
      WebDriver driver;
      
	public void cLApproval() {
		CL_CLApprovalPage CLApproval=new CL_CLApprovalPage(driver);
		CLApproval.Clickon_Approvebutton();
		WebElement text = driver.findElement(By.xpath("//form[@id='NewCLApproval']//div[2]"));
		System.out.println(text.getText());
		if (isDisplayed(text) == true) {
			CLLicencenumber = App_NO(driver, "//form[@id='NewCLApproval']//div[1]//div[2]//h4[1]");
			setdata("CLLicNo", CLLicencenumber.substring(16).trim());
			CLBadgenumber = App_NO(driver, "//form[@id='NewCLApproval']//div[1]//div[2]//h4[2]");
			setdata("CLBadgeNo", CLBadgenumber.substring(14).trim());
		} else {
			System.out.println("Please Check Once");
		}
	}
}
