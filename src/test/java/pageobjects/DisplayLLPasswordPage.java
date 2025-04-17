package pageobjects;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkLibrary.BasePage;



public class DisplayLLPasswordPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	String nextFlow;
	int remainingFlows=0;
	boolean stepstatus;

	
	public DisplayLLPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@name='applNum']")
	WebElement Enterapplno;

	public void EnterApplicationNumberinDisplayPassword(String value) {
		stepstatus = basepage.setText(Enterapplno, value);
		reportEvent(stepstatus, "Able to set text", "Unable to set text", driver, true);
	}
	
	//input[@value = 'Submit']
	@FindBy(how = How.XPATH, using = "//input[@value = 'Submit']")
	WebElement Clickon_SubmitinDisplayPassword;

	public void Clickon_SubmitinDisplayPassword() {
		stepstatus = basepage.clickElement(Clickon_SubmitinDisplayPassword);
		reportEvent(stepstatus, "Able to click on view flows ", "Unable to click on view flows", driver, true);
	}
		
	@FindBy(how = How.XPATH, using = "//div[@class = 'col-md-3 customAlign']")
	WebElement LLTestPassword;
	//div[@class = 'col-md-3 customAlign']
	//div[normalize-space(text())='LL Test Password']/following::div[1]
	String password;

	public String getLLTestPassword() {

		System.out.println("Entered into getLLtestpasword method");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'col-md-3 customAlign']")));
        System.out.println(element);
		password = LLTestPassword.getText();
		System.out.println("LLTest Password is: " + password.trim());
		return password.trim();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}