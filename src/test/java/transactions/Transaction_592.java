package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import frameworkLibrary.BasePage;
import pageobjects.DL_Backlog;
import pageobjects.LoginPage;
import pageobjects.NewDLSubmissionPage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_592 extends BaseClass {
	
	NewDLSubmissionPage NewDLSubmissionPage;
	Flows flows;
	BasePage basepage = new BasePage();
	WebDriver driver;
	DL_Backlog DL_Backlog;
	Flows validate;
	boolean stepstatus;

	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	

	@Test(invocationCount = 1)
	public void dLBacklog() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		
		DL_Backlog DL_Backlog = new DL_Backlog(driver);
		DL_Backlog.ArrangeDataSet();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(getdata("UserName"));
		loginPage.setpassword(getdata("Password"));
		loginPage.ClickonLogin();
		DL_Backlog.ClickonDL();
		DL_Backlog.ClickonDLBacklog();
		DL_Backlog.SetFirstissuedate(getdata("Firstissuedate"));
		DL_Backlog.SetNumaricLLno(getdata("NumaricLLno"));
		DL_Backlog.SetOriginalDLno(getdata("OriginalDLno"));
		DL_Backlog.SetLasttransdate(getdata("Lasttransdate"));
		DL_Backlog.SetName(getdata("Name"));
		DL_Backlog.SetLastName(getdata("Lastname"));
		DL_Backlog.SetRelation(getdata("Relation"));
		DL_Backlog.SetRelationfirstname(getdata("RFName"));
		DL_Backlog.SetRelationLastname(getdata("RLName"));
		DL_Backlog.ClickonGender();
		DL_Backlog.SetAge(getdata("Age"));
		DL_Backlog.SetBloodgroup(getdata("Bgrp"));
		DL_Backlog.SetQualification(getdata("Qualification"));
		DL_Backlog.SetMobilenumber(getdata("Mobilenumber"));
		DL_Backlog.SetState(prop.getProperty(getdata("State")));
		DL_Backlog.TypeofDistdetails();
		DL_Backlog.SetPincode(getdata("Pincode"));
		DL_Backlog.ClickonCheckbox();
		DL_Backlog.ClickonLicenseDetails();
		int totalcovs = Integer.valueOf(getdata("TotalCOVS"));
		switch (totalcovs) {
		case 1:
			/* Adding Single COV */
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			break;
		case 2:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			break;
		case 3:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Third COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate3"));
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			DL_Backlog.ClickonAddbutton();

			break;
		case 4:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Third COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate3"));
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Fourth COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate4"));
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			wait(2);
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			DL_Backlog.ClickonAddbutton();
			break;
		case 5:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Third COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate3"));
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Fourth COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate4"));
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			wait(2);
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Fifth COVS */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate5"));
			DL_Backlog.SetSelectCOV(getdata("COV5"));
			wait(2);
			DL_Backlog.SetSelectCOV(getdata("COV5"));
			DL_Backlog.ClickonAddbutton();
			break;

		default:
			System.out.println("Selected COV Count is not Available Please Check");
			break;
		}

		String expire = getdata("DoYouWantExpireBacklog");
		if (expire.equals("Y")) {
			String typeofcov = getdata("COVType");
			if (typeofcov.equals("NON-TR")) {
				driver.findElement(By.xpath("//input[@name='ntToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(getdata("ExpireDate"));
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(Keys.ESCAPE);
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("Transport")) {
				driver.findElement(By.xpath("//input[@name='trToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='trToDate']")).sendKeys(getdata("ExpireDate"));
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("Hazardous")) {
				driver.findElement(By.xpath("//input[@name='hzToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='hzToDate']")).sendKeys(getdata("ExpireDate"));
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("Hill")) {
				driver.findElement(By.xpath("//input[@name='hillToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='hillToDate']")).sendKeys(getdata("ExpireDate"));
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("NON-TR&Transport")) {
				driver.findElement(By.xpath("//input[@name='ntToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(getdata("ExpireDate"));
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(Keys.ESCAPE);
				driver.findElement(By.xpath("//input[@name='trToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='trToDate']")).sendKeys(getdata("CExpireDate"));
				driver.findElement(By.xpath("//input[@name='trToDate']")).sendKeys(Keys.ESCAPE);
				DL_Backlog.ClickonSubmit();
			} else {
				System.out.println("COV type is not availble");
			}

		} else if (expire.equals("N")) {
			DL_Backlog.ClickonSubmit();
	
			
		} else {
			System.out.println("Invalid Option");
		}

		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		driver.findElement(By.xpath("//input[@value = 'Go to https://sarathicov.nic.in:8443/sarathiservice']")).click();
	}

	

	
	
	
	
	@AfterMethod
	public void after() {
		System.out.println("After Method");
		// quitdriver(currentdriver);
	}

}
