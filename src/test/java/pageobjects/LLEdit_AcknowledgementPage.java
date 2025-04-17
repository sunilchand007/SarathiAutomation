package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class LLEdit_AcknowledgementPage extends BasePage{

	
	WebDriver driver;
	
	public LLEdit_AcknowledgementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LLEditEntry_Acknowledgement() {
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
	   
		String title = driver.getTitle();
	    if (title.equals("")) {
		setdata("ApplicationNo", AppNum.substring(3).trim());
		setdata("DateofBirth", DOB.substring(3).trim());
		setdata("StatusofApplication", "Success");

	    }  
	    else {
		System.out.println("LL Edit not submitted");
		setdata("StatusofApplication", "Fail");
	}

	
	
}}
