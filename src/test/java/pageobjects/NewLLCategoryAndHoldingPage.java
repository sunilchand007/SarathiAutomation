package pageobjects;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class NewLLCategoryAndHoldingPage extends BasePage {


	WebDriver driver;

	boolean stepstatus;

	public NewLLCategoryAndHoldingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	
	@FindBy(how = How.XPATH, using = "//input[@id='aadhaarHoldingType0']")
	WebElement ApplicantholdsDrivingLicenceEnterDLNumber;

	public void clickonApplicantholdsDrivingLicenceEnterDLNumber() {
		stepstatus = clickElement(ApplicantholdsDrivingLicenceEnterDLNumber);
		reportEvent(stepstatus, "Able to click ApplicantholdsDrivingLicenceEnterDLNumber",
				"Unable to click ApplicantholdsDrivingLicenceEnterDLNumber", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='licenceType3']")
	WebElement ApplicantholdsLearnerLicenceEnterLLNumber;

	public void clickonApplicantholdsLearnerLicenceEnterLLNumber() {
		stepstatus = clickElement(ApplicantholdsLearnerLicenceEnterLLNumber);
		reportEvent(stepstatus, "Able to click ApplicantholdsLearnerLicenceEnterLLNumber",
				"Unable to click ApplicantholdsLearnerLicenceEnterLLNumber", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//select[@name='rtCode']")
	WebElement selectcamp;

	public void SelectRTOofficetodisplayCamp(String value) {
		stepstatus = setValueInSelectBox(selectcamp, value);
		reportEvent(stepstatus, "Able to select RTO office ", "Unable to select RTO office", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='ekycrtCode']")
	WebElement SetRTO;

	public void Select_RTO_Office() {
		stepstatus = setValueInSelectBox(SetRTO, getdata("RTOCode"));
		reportEvent(stepstatus, "Able to Select RTO", "Unable to Select RTO", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='submitOfNewLL']")
	WebElement Submitone;
	public void clickonSubmitonebutton() {

		stepstatus = clickElement(Submitone);
		reportEvent(stepstatus, "Able to click submitbutton and it is Enabled ","Unable to click submitbutton and it is not Enabled", driver, true);
	}
	
	
	//This method first verify the customization of RTO selection from dropdown or camplist  and click submit button 
	
		public void clickSubmitButton_in_NewLLCategory_and_Holding() throws ClassNotFoundException, SQLException, IOException {
			//connecting to state customization excel (StateCustom) to get the value of 'restrict_dlsp_camplist_tousr' 	 
		/*Utilitymethods utilitymethods = new Utilitymethods(driver);	
		String restrict_dlsp_camplist_tousr  = utilitymethods.ConnectDBandGetDBvalue("select * from s4_custom_st WHERE st_code" + "='" + getdata("State") + "';","restrict_dlsp_camplist_tousr");
		System.out.println("value of restrict_dlsp_camplist_tousr for state " + getdata("State") +  "  =  " + restrict_dlsp_camplist_tousr );
			
		String ekyc_is_rto_code = utilitymethods.ConnectDBandGetDBvalue( "select * from s4_custom_st WHERE st_code" + "='" + getdata("RTOCode") + "';" ,"ekyc_is_rto_code");
        System.out.println("value of ekyc is rto code for RTO " + getdata("RTOCode") +  "  =  " + ekyc_is_rto_code );
		
			if (restrict_dlsp_camplist_tousr.equalsIgnoreCase("N")) {
				System.out.println("Inside Please Select Rto Office to display camps/Sewa kendras");
				SelectRTOofficetodisplayCamp(getdata("RTOCode"));
				clickonSubmitonebutton();
			} else if (ekyc_is_rto_code!=null && !ekyc_is_rto_code.trim().equals("00")  ){
				
				System.out.println("Inside Please Select Rto Office ");
				Select_RTO_Office();
				clickonSubmitonebutton();
			} else  {
				
				System.out.println("Inside no RTO office");
				clickonSubmitonebutton();
				
			}*/
			
			//SelectRTOofficetodisplayCamp(getdata("RTOCode"));
			clickonSubmitonebutton();
			
		}
		
		

	@FindBy(how = How.XPATH, using = "//input[@value='Refresh']")
	WebElement Refresh;

	public void clickonRefreshbutton() {
		stepstatus = isEnabled(Refresh);
		reportEvent(stepstatus, "Able to click Refreshbutton and it is Enabled ",
				"Unable to click Refreshbutton and it is not Enabled", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
	WebElement Cancel;

	public void clickonCancelbutton() {
		stepstatus = isEnabled(Cancel);
		reportEvent(stepstatus, "Able to click Cancelbutton and it is Enabled ",
				"Unable to click Cancelbutton and it is not Enabled", driver, true);
	}

	
	
	
	
	
	
	
	
	
	
	


}
