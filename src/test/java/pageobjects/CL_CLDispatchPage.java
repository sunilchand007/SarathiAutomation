package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_CLDispatchPage extends BasePage {

	BasePage basepage = new BasePage();

	WebDriver driver;
	boolean stepstatus;

	public CL_CLDispatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='agentid']")
	WebElement AgentName;

	public void Select_AgentName(String value) {
		stepstatus = basepage.setOptionInSelectBox(AgentName, value);
		reportEvent(stepstatus, "Able to Select AgentName", "Unable to Select AgentName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='recievername']")
	WebElement ReceiverName;

	public void Set_ReceiverName(String value) {
		stepstatus = basepage.setText(ReceiverName, value);
		reportEvent(stepstatus, "Able to Enter ReceiverName", "Unable to Enter ReceiverName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='letter']")
	WebElement DispatchLetterPrint;

	public void Click_DispatchLetterPrintRadiobtn() {
		stepstatus = basepage.clickElement(DispatchLetterPrint);
		reportEvent(stepstatus, "Able to click DispatchLetterPrint", "Unable to click DispatchLetterPrint", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='acknowledgement']")
	WebElement Acknowledgement;

	public void Click_AcknowledgementRadiobtn() {
		stepstatus = basepage.clickElement(Acknowledgement);
		reportEvent(stepstatus, "Able to click Acknowledgement", "Unable to click Acknowledgement", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='reprint']")
	WebElement ReprintofDispatchLetter;

	public void Click_ReprintofDispatchLetterRadiobtn() {
		stepstatus = basepage.clickElement(ReprintofDispatchLetter);
		reportEvent(stepstatus, "Able to click ReprintofDispatchLetter", "Unable to click ReprintofDispatchLetter",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Exit']")
	WebElement Exit;

	public void Click_Exitbtn() {
		stepstatus = basepage.clickElement(Exit);
		reportEvent(stepstatus, "Able to click Exit button", "Unable to click Exit button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='all']")
	WebElement AllDispatchPendingCLList;

	public void Click_AllDispatchPendingCLListRadiobtn() {
		stepstatus = basepage.clickElement(AllDispatchPendingCLList);
		reportEvent(stepstatus, "Able to click AllDispatchPendingCLList", "Unable to click AllDispatchPendingCLList",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='between']")
	WebElement CLPrintDate;

	public void Click_CLPrintDateRadiobtn() {
		stepstatus = basepage.clickElement(CLPrintDate);
		reportEvent(stepstatus, "Able to click CLPrintDate radio button", "Unable to click CLPrintDate radio button",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clDispatchAutomatic_GetDetails']")
	WebElement GetDispatchPendingApplications;

	public void Click_GetDispatchPendingApplicationsbtn() {
		stepstatus = basepage.clickElement(GetDispatchPendingApplications);
		reportEvent(stepstatus, "Able to click GetDispatchPendingApplications button",
				"Unable to click GetDispatchPendingApplications button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='PDF']")
	WebElement PDF;

	public void Click_PDFButton() {
		stepstatus = basepage.clickElement(PDF);
		reportEvent(stepstatus, "Able to click PDF button", "Unable to click PDF button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Excel']")
	WebElement Excel;

	public void Click_ExcelButton() {
		stepstatus = basepage.clickElement(Excel);
		reportEvent(stepstatus, "Able to click Excel button", "Unable to click Excel button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='Re_Acknowledgement']")
	WebElement Go;

	public void Click_GOButton() {
		stepstatus = basepage.clickElement(Go);
		reportEvent(stepstatus, "Able to click Go button", "Unable to click Go button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='dlnumber']")
	WebElement LetterforCLNo;

	public void Set_LetterforCLNo(String value) {
		stepstatus = basepage.setText(LetterforCLNo, value);
		reportEvent(stepstatus, "Able to Enter LetterforCLNo", "Unable to Enter LetterforCLNo", driver, true);
	}

}
