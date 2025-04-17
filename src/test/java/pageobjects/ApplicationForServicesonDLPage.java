package pageobjects;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationForServicesonDLPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public ApplicationForServicesonDLPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(how = How.XPATH, using = "//input[@name='dlno']")
	WebElement DLnumber;
	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@value='Get DL Details']")
	WebElement GetDetails;
	@FindBy(how = How.XPATH, using = "//input[@id='entCaptha']")
	WebElement CaptchaBoxinDLSerReqSub;
	@FindBy(how = How.XPATH, using = "//input[@id='PrivacyPolicyTermsofService']")
	WebElement CheckBoxPolicyTerms;
	
	
	public void SetDLnumber() throws IOException, InterruptedException {
		stepstatus = basepage.setText(DLnumber, getdata("DL"));
		reportEvent(stepstatus, "Able to Enter DLNumber", "Unable to Enter DLNumber", driver, true);
	}
	
	public void SetDateofbirth() throws IOException, InterruptedException {
		stepstatus = basepage.setText(DateofBirth, getdata("DateofBirth"));
		reportEvent(stepstatus, "Able to Enter DateofBirth", "Unable to Enter DateofBirth", driver, true);

	}
	
	
	public void Clickon_Getdetails() {
		stepstatus = basepage.clickElement(GetDetails);
		reportEvent(stepstatus, "Able to Click Getdetails button ", "Unable to Click Getdetails button", driver, true);
		 if(alertExist(driver)) {
				acceptAlert(driver);
				wait(2);
			}else {
				System.out.println("There is no Confirmbutton");
			}
		 if (alertExist(driver)) {
				acceptAlert(driver);
				wait(2);

			} else {
				System.out.println("There is no Alert");
			}
		 if(alertExist(driver)) {
				acceptAlert(driver);
				wait(2);
				
			}else {
				System.out.println("There is no Alert");
			}
	}
	public void EnterCaptchatoFetchDetails(){
		stepstatus = basepage.setText(CaptchaBoxinDLSerReqSub,"123456");
		reportEvent(stepstatus, "Able to Enter Captcha In DLService Submission", "Unable to Enter Captcha In DLService Submission", driver, true);
	}
	
	public void checkboxPolicyTerms(){
		
		stepstatus=basepage.clickElement(CheckBoxPolicyTerms);
		reportEvent(stepstatus, "Able to checkBox Policy Terms", "Unable to checkBox Policy Terms", driver);
	}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



