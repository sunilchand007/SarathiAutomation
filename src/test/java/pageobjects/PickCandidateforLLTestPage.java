package pageobjects;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;



public class PickCandidateforLLTestPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	String nextFlow;
	int remainingFlows=0;
	boolean stepstatus;

	public PickCandidateforLLTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement AppNo;

	public void Enter_ApplicationNumber() {
		stepstatus = basepage.SetTextAndTAB(AppNo, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter AppNo", "Unable to enter AppNo", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement Sub;

	public void Clickon_Submit() {
		stepstatus = basepage.clickElement(Sub);
		System.out.println(stepstatus);
		reportEvent(stepstatus, "Able to click on Submit", "Unable to click on Submit", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement Confirm;

	public void Clickon_Confirm() {
	
		stepstatus = basepage.clickElement(Confirm);
		System.out.println(stepstatus);
		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
		
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='DisplayReult']/div[2]/div[2]")
	WebElement PinNumber;

	public String getPinNumber() {
	wait(40);
		pinnumber = PinNumber.getText();
		System.out.println("Pin Number is: " + pinnumber.trim());
		System.out.println("Pin length" + pinnumber.trim().length());
		return pinnumber.trim();
	}
	
	
	
	
	
	
	
	
	
	
}