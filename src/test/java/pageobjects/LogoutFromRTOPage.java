package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class LogoutFromRTOPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	String nextFlow;
	int remainingFlows=0;
	boolean stepstatus;
	
	public LogoutFromRTOPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
WebElement Logout;


public void Clickon_Logout() throws IOException {
	stepstatus = basepage.clickElement(Logout);
	wait(2);
	String env = getdata("ApplicationEnvironment");
	if (env.equalsIgnoreCase("SarathiCOV")) {
		driver.navigate().to("https://sarathicov.nic.in:8443/sarathiservice/stateSelection.do");
	} else if (env.equalsIgnoreCase("SarathiProd")) {
		driver.navigate().to("https://sarathiprod.nic.in/sarathiservice/stateSelection.do");
	} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
		driver.navigate().to("https://sarathicov.nic.in:8443/sarathiservice/stateSelection.do");
	} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
		driver.navigate().to("https://sarathiprod.nic.in/sarathiservice/stateSelection.do");
	} else {
		System.out.println("Navigation URL is not matched at Upload Photo and Signature Flow.Please try again");
	}
	loaddata();
}
}

	