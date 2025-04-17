package pageobjects;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class DrivingLicenceMenuPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public DrivingLicenceMenuPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Driving Licence ']")
	WebElement DrivingLicence;

	public void Mouserhoveron_DrivingLicence() {
		
		stepstatus = basepage.mouseHover(DrivingLicence, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on DrivingLicence",
				"Unable to do Mousehover action on DrivingLicence", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Services on DL (Renewal/Duplicate/AEDL/IDP/Others)']")
	WebElement Services;

	public void Clickon_ServicesonDL() throws IOException, InterruptedException {
		stepstatus = basepage.clickElement(Services);
		reportEvent(stepstatus, "Able to click on Services on DL (Renewal/Duplicate/AEDL/Others) ",
				"Unable to click on Services on DL (Renewal/Duplicate/AEDL/Others)", driver, true);
		
	}
	
}
