package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class SBHhomePage extends BasePage {
	WebDriver driver;
	
	boolean stepstatus;
	
	public SBHhomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@class='btn'][1]")
	WebElement Pressheretocontinue;

	public void Clickon_Pressheretocontinue_Button() {
		stepstatus = clickElement(Pressheretocontinue);
		if (alertExist(driver)) {
			acceptAlert(driver);
			System.out.println(alertGetText(driver));
			String title = driver.getTitle();
			if (title.equals("::Payment Success ACK ::")) {
				setdata("StatusofFeePayment", "Success");
			} else {
				setdata("StatusofFeePayment", "Fail");
			}

		} else {
			dismissAlert(driver);
		}
	}
}
