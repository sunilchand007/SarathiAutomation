package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;


public class CL_ExtractCL_ApplicationAcknowledgementPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
    boolean stepstatus;
   
	public CL_ExtractCL_ApplicationAcknowledgementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(how = How.XPATH, using =  "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]")
	WebElement applicationno;
	@FindBy(how = How.XPATH, using =  "//table/tbody/tr[2]/td[3]/following-sibling::td")
	WebElement DateOfBirth;
	
	public void Capture_CLService_AcknowledgementDetails() {
		
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
	   
		String title = driver.getTitle();
	    if (title.equals("CL Transactions")) {
		setdata("ApplicationNo", AppNum.substring(3).trim());
		setdata("DateofBirth", DOB.substring(3).trim());
		setdata("StatusofApplication", "Success");

	    }  
	    else {
		System.out.println("CL not submitted");
		setdata("StatusofApplication", "Fail");
	}

	}	
}
