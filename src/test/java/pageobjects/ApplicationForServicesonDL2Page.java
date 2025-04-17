package pageobjects;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;

public class ApplicationForServicesonDL2Page extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public ApplicationForServicesonDL2Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how = How.XPATH, using = "//select[@name='dispDLDet']")
	WebElement DrivingLicence;
	@FindBy(how = How.XPATH, using = "//select[@id='rtoCodeDLTr']")
	WebElement SubmitRequestRTOSelection;
	@FindBy(how = How.XPATH, using = "//select[@name='stateCodeDLTr']")
	WebElement SubmitRequestStateSelection;
	@FindBy(how = How.XPATH, using = "//input[@id='dlconfirm']")
	WebElement Proceedbutton;
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement Confirmbutton;
	@FindBy(how = How.XPATH, using = "//input[@id='envaction_enve_confirm']")
	WebElement Confirmbutton2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='envaction_enve_confirm']")
	WebElement Confirmbuttonindlsubmission;
	@FindBy(how = How.XPATH, using = "//input[@name='PincodeDLserReq']")
	WebElement ClearPincode;
	
	public void ClearPincode() throws IOException, InterruptedException {
		ClearPincode.clear();
	}
public void Confirmbutton() throws IOException, InterruptedException {
	stepstatus = basepage.clickElement(Confirmbutton);
	reportEvent(stepstatus, "Able to click on Confirmbutton", "Unable to click on Confirmbutton", driver, true);
	if(alertExist(driver)) {
		acceptAlert(driver);
		wait(2);
		
	}else {
		System.out.println("There is no alert present");
	}
}

public void Proceedbutton() throws IOException, InterruptedException {
	stepstatus = basepage.clickElement(Proceedbutton);
	reportEvent(stepstatus, "Able to click on Proceedbutton", "Unable to click on Proceedbutton", driver, true);
	if(alertExist(driver)) {
		acceptAlert(driver);
		wait(2);
		
	}else {
		System.out.println("There is no alert present");
	}
}
@FindBy(how = How.XPATH, using = "//select[@id='surrOrgDL']")
WebElement SurrenderDL;
public void SurrenderDL() throws IOException, InterruptedException {
	wait(3);
	if(SurrenderDL.isDisplayed() && SurrenderDL.isEnabled()) {
		stepstatus = basepage.setOptionInSelectBox(SurrenderDL,"YES");
		reportEvent(stepstatus, "Able to Select SurrenderDL", "Unable to Select SurrenderDL", driver, true);
	}else {
		
		System.out.println("There is no SurrendarDL option to select");
	}

	if(alertExist(driver)) {
		acceptAlert(driver);
		wait(2);
		
	}else {
		System.out.println("There is no alert present");
	}
}


public void Confirmbutton2() throws IOException, InterruptedException {
	stepstatus = basepage.clickElement(Confirmbutton2);
	reportEvent(stepstatus, "Able to click on Proceedbutton", "Unable to click on Proceedbutton", driver, true);
	if(alertExist(driver)) {
		acceptAlert(driver);
		wait(2);
		
	}else {
		System.out.println("There is no alert present");
	}
}
@FindBy(how = How.XPATH, using = "//select[@id='dispDLDet']")
WebElement DrivingLicenceYEs;

public void SelectYesOrNofromDropdown(){
	stepstatus=basepage.clickElement(DrivingLicenceYEs);
	Select select = new Select(DrivingLicenceYEs);
	select.selectByVisibleText("YES");
	System.out.println("Selected Yes");
	wait(10);
	//reportEvent(stepstatus, "Able to click on SelectYesfromDropdown", "Unable to click on SelectYesfromDropdown", driver, true);
	
}

public void SelectRTO() throws IOException, InterruptedException {
	
	stepstatus = basepage.setOptionInSelectBox(SubmitRequestStateSelection, prop.getProperty(getdata("State")));
	reportEvent(stepstatus, "Able to Select SubmitRequestStateSelection",
			"Unable to Select SubmitRequestStateSelection", driver, true);

	List<WebElement> subrtos = driver.findElements(By.xpath("//select[@id='rtoCodeDLTr']/option"));
	for (WebElement lstrtos : subrtos) {

		String rtotxt = lstrtos.getText();
		System.out.println(rtotxt);
		if (rtotxt.contains(getdata("RTOCode"))) {
			stepstatus = basepage.setOptionInSelectBox(SubmitRequestRTOSelection, rtotxt);
			break;
		}
	}

}


public void ConfirmbuttoninDLServsubmission() throws IOException, InterruptedException {
	stepstatus = basepage.clickElement(Confirmbuttonindlsubmission);
	reportEvent(stepstatus, "Able to click on Proceedbutton", "Unable to click on Proceedbutton", driver, true);
	if (basepage.alertExist(driver)) {
		basepage.acceptAlert(driver);
	} else {
		basepage.dismissAlert(driver);
	}
}









	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



