package pageobjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class CLbacklogApprovalPage extends BasePage{
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	Utilitymethods utilitymethods;

	public CLbacklogApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how = How.XPATH, using = "//a[text()='CL ']")
	WebElement CL;
	
	@FindBy(how = How.XPATH, using = "//a[text()='CL BACKLOG APPROVAL']")
	WebElement CLBacklogApproval;
	

	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement CLAppNumber;
	
	@FindBy(how=How.XPATH, using ="//input[@id='proceed']")
	WebElement Proceedbutton;
	@FindBy(how=How.XPATH, using ="//input[@id='clbacklogapproval_execute_submit']")
	WebElement ApproveButton;
	
	
	
	
	public void ClickonCL() {
		stepstatus = basepage.clickElement(CL);
		reportEvent(stepstatus, "Able to Click on CL", "Unable to Click on CL", driver, true);
	}
	
	public void ClickonCLBacklogApproval() {
		stepstatus = basepage.clickElement(CLBacklogApproval);
		reportEvent(stepstatus, "Able to Click on CLBacklog", "Unable to Click on CLBacklog", driver, true);
	}
	
	
	public void EnterCLAppNo(){
		stepstatus = basepage.setText(CLAppNumber,getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Click on CLBacklog", "Unable to Click on CLBacklog", driver, true);
	}
	
	public void ClickProceed(){
		
		stepstatus= basepage.clickElement(Proceedbutton);
		reportEvent(stepstatus, "Able to Click Proceed Button", "Unable to click proceed button", driver, true);
	}

	
	@FindBy(how=How.XPATH, using ="//div[@id='navbar']//a[text()='Logout']")
	WebElement LogoutButton;
	public void ClickApproveButton(){
		
		stepstatus= basepage.clickElement(ApproveButton);
		reportEvent(stepstatus, "Able to Click Approve Button", "Unable to click Approve button", driver, true);
		WebElement element = driver.findElement(By.xpath("(//h4)[1]"));
        String text = element.getText();
        System.out.println(text);
        
        if(driver.getPageSource().contains(" Application Number  has been approved already")) {
        	stepstatus= basepage.clickElement(LogoutButton);
    		reportEvent(stepstatus, "Able to Click Logout Button", "Unable to click Logout Button", driver, true);
        }
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='navbar']//a[text()='Logout']")
	WebElement Logout;
	@FindBy(how = How.XPATH, using = "//input[@value='Go to https://sarathi.preprod.nic.in/sarathiservice']")
	WebElement URL;
	
	public void Clickon_Logout() {
		//if(driver.getPageSource().contains("Application No 116524 is Approved"))
		wait(5);
		stepstatus = basepage.clickElement(Logout);
		reportEvent(stepstatus, "Able to click on Logout", "Unable to click on Logout", driver, true);
	}
	
	public void Clickon_URL_ofstateHomePage() {
		wait(2);
		stepstatus = basepage.clickElement(URL);
		reportEvent(stepstatus, "Able to click on URL", "Unable to click on URL", driver, true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

