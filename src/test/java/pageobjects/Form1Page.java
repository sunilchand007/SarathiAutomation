package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Form1Page extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	
	public Form1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='declaringcheck']")
	WebElement DeclareForm1;
	public void ClickonDeclareCheckbox() {
		stepstatus = clickElement(DeclareForm1);
	}
	
	
	@FindBy(how = How.XPATH, using = "//button[@id='getFormOneDetails_newll_submit']")
	WebElement SubmitbuttonatForm1;

	public void ClickonSubmitbuttonatForm1() {
		stepstatus = clickElement(SubmitbuttonatForm1);
		if (alertExist(driver)) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
	}
	

	public void Fill_Form1Details(String title ) {
		 driver.findElement(By.xpath("(//label[text()='NO']/preceding-sibling::input[1])[1]")).click();
	     driver.findElement(By.xpath("(//label[text()='YES']/preceding-sibling::input[1])[2]")).click();
	     driver.findElement(By.xpath("(//label[text()='NO']/preceding-sibling::input[1])[5]")).click();
	     driver.findElement(By.xpath("(//label[text()='NO']/preceding-sibling::input[1])[6]")).click();
	     driver.findElement(By.xpath("(//label[text()='NO']/preceding-sibling::input[1])[7]")).click();
	     driver.findElement(By.xpath("(//label[text()='NO']/preceding-sibling::input[1])[8]")).click();
	     
			
			/*
			 * List<WebElement> radio = driver.findElements(By.xpath(
			 * "//label[text()='NO']/preceding-sibling::input[1]")); int noofradiobuttons =
			 * radio.size(); System.out.println("No of radio buttons in Form1 is : " +
			 * noofradiobuttons); for (WebElement subradio : radio) { subradio.click(); }
			 */
			 

		ClickonDeclareCheckbox();
		ClickonSubmitbuttonatForm1();
		closeWindowByTitle("FormOneSuccess", driver);
		SwitchtoWindowByTitle(title, driver);
		System.out.println("Exist from From1 ");
	}
}


