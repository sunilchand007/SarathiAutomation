package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationFeeforLLDLTestPage extends BasePage {

	
	WebDriver driver;

	boolean stepstatus;

	public ApplicationFeeforLLDLTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='applNo']")
	WebElement AppNo;
	public void Enter_Application_Number(String value) {
		stepstatus = setText(AppNo, value);
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver,
				true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement DOB;
	
	public void Enter_DateofBirth(String value) {
		stepstatus = setText(DOB, value);
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//button[@value='Click Here To Calculate Fee']")
	WebElement Feecal;

	public void Clickon_Calculate_Fee() {
		stepstatus = clickElement(Feecal);
		reportEvent(stepstatus, "Able to click Calculate_Fee", "Unable to click Calculate_Fee", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='bankslist']")
	WebElement Bank;
	public void SelectBank(String Option) {
		wait(5);
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement aboutMe;
		aboutMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='bankslist']")));*/
		try {
			//scrooldown(driver);
			stepstatus = setOptionInSelectBox(Bank, Option);
			reportEvent(stepstatus, "Able to Select Bank", "Unable to Select Bank", driver, true);
		} catch (StaleElementReferenceException e) {
			//scrooldown(driver);
			stepstatus = setOptionInSelectBox(Bank, Option);
			reportEvent(stepstatus, "Able to Select Bank", "Unable to Select Bank", driver, true);
		}

	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='captchatext']")
	WebElement Captcha;
	public void EnterCaptcha() {
		  driver.findElement(By.xpath("//input[@id='captchatext']")).sendKeys("123456");
		  
			/*
			 * String ref =
			 * driver.findElement(By.xpath("//input[1][@id='abc']")).getAttribute("value");
			 * if(ref.equalsIgnoreCase("123456")) {
			 * driver.findElement(By.xpath("//input[@id='captchatext']")).sendKeys("123456")
			 * ; } else { stepstatus = setText(Captcha,
			 * Captcha.getAttribute("value"));
			 * reportEvent(stepstatus,"Able to Enter Captcha", "Unable to Enter Captcha",
			 * driver, true); }
			 */
		 
		/*
		 * WebElement ref = driver.findElement(By.xpath("//input[1][@id='abc']"));
		 * String captcha = ref.getAttribute("value").replaceAll("\\s", "");
		 * System.out.println("Captcha in feepayment page applicant side " + captcha);
		 * stepstatus = setText(Captcha,captcha); reportEvent(stepstatus,
		 * "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
		 */
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='first']")
	WebElement Paynow;

	public void Clickon_Paynow_Button() {
		stepstatus = clickElement(Paynow);
		reportEvent(stepstatus, "Able to click Paynow button", "Unable to click Paynow button", driver, true);
	}
	
}
