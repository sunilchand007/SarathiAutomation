package pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class LLTestAppointmentDetailsPreviewPage extends BasePage {
	WebDriver driver;
	Utilitymethods Utilitymethods ;
	boolean stepstatus;
	
	public LLTestAppointmentDetailsPreviewPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//button[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbook;
	

	public void Clickon_Confirm_slotbookingbutton() throws IOException {

		Utilitymethods = new Utilitymethods(driver);
		Utilitymethods.Getlogotp("securityCd", 148, 154);
		stepstatus = clickElement(Confirm_slotbook);

	}

		// reportEvent(stepstatus, "Able to click Confirm_slotbook", "Unable to click
		// Confirm_slotbook", driver, true);
	}
	
	


		
	

