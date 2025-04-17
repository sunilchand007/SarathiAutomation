package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.LLBacklogPage;
import pageobjects.LoginPage;
import pageobjects.StateSelectionPage;
import utility.Utilitymethods;

public class Transaction_591 extends BaseClass {

	
	WebDriver driver;
	
	Utilitymethods utilitymethods;
	
	
	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	
//	public LLbacklog(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	@Test(invocationCount = 1)
	public void llBacklogEntry() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		
		LLBacklogPage LLBacklogPage = new LLBacklogPage(driver);
		utilitymethods.ArrangeDataSet();
		wait(5);
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
//		stateSelectionPage.clickLoginbutton();
		LoginPage loginpage = new LoginPage(driver);
		System.out.println(GetCurrentDate());
		loginpage.setUserName(getdata("UserName"));
		loginpage.setpassword(getdata("Password"));
		loginpage.ClickonLogin();
		
//		RTO.ClickonMobile();
//		RTO.setMobileNumber(getdata("Phone"));
//		RTO.ClickonPWDLessAuthentification();
//		RTO.chkconcentlogin();
//		RTO.ClickonSignIn();
//		wait(3);
//		RTO.SetOTP();
//		RTO.ClickonotpSubmitButton();

		LLBacklogPage.Clickon_LL_Link();
		LLBacklogPage.Clickon_LLBacklog();
		
//		LLBacklogPage.Clickon_LLorDL_Available();
//		wait(2);
//		LLBacklogPage.ClickonDL();
//		LLBacklogPage.Selectstate(getdata("State"));
//		LLBacklogPage.SelectRTO(getdata("RTOCode"));
//		LLBacklogPage.Enter_License_no(getdata("DLNo"));
//		LLBacklogPage.ClickonLoadLicenceDetails();
//		wait(2);
		
		wait(30);
		LLBacklogPage.Set_Issuedate(getdata("Issuedate"));
		
		//int OriginalLLno = Integer.parseInt(getdata("OriginalLLno")) + 1;
		//System.out.println("OriginalLLno" + OriginalLLno);
		//setdata("OriginalLLno", Integer.toString(OriginalLLno));
		//System.out.println("updated OriginalLLno in excel by increment--> " + Integer.toString(OriginalLLno));
		LLBacklogPage.Set_OriginalLLno(getdata("OriginalLLno"));
		/*
			if(alertExist(driver)) {
				
			    acceptAlert(driver);
				int OriginalLLno1 = Integer.parseInt(getdata("OriginalLLno")) + 1;
				System.out.println("OriginalLLno" + OriginalLLno1);
				setdata("OriginalLLno", Integer.toString(OriginalLLno1));
				System.out.println("updated OriginalLLno in excel by increment--> " + Integer.toString(OriginalLLno));
				LLBacklogPage.Set_OriginalLLno(getdata("OriginalLLno"));
			}
			else {
				
				System.out.println("There is no alert ");
			}*/
		//int NumaricLLNo = Integer.parseInt(getdata("NumaricLLNo")) + 1;
		//System.out.println("NumaricLLNo " + NumaricLLNo);
		//setdata("NumaricLLNo", Integer.toString(NumaricLLNo));
		//System.out.println("updated NumaricLLNo in excel by increment--> " + Integer.toString(OriginalLLno));
		
		
		LLBacklogPage.Set_NumaricLLNo(getdata("NumaricLLNo"));
		
		LLBacklogPage.nameoftheLicenceFirstName(getdata("ApplicantFirstName"));
		LLBacklogPage.NameofLicenceLastname(getdata("ApplicantLastName"));
		LLBacklogPage.selectGender();
		LLBacklogPage.selectRelation(getdata("Relationname"));
		LLBacklogPage.enterRelationfirstname(getdata("Relationfirstname"));
		LLBacklogPage.enterRelationlastname(getdata("Relationlastname"));
		LLBacklogPage.enterAge(getdata("Age"));
		LLBacklogPage.selectBloodGroup(getdata("bloodgroup"));
		LLBacklogPage.selectQualification(getdata("Qualification"));
		LLBacklogPage.enterMobilenumber(getdata("Mobile"));
		LLBacklogPage.SetState();
		LLBacklogPage.TypeDist();
		LLBacklogPage.Flat_Houseno();
		LLBacklogPage.Street_Locality();
		LLBacklogPage.PincodeinLLBacklog(getdata("Pin"));
		
		LLBacklogPage.CopytoPermanentAddressCheckbox();
		
		
		LLBacklogPage.selectCov1(getdata("COV1"));
//		LLBacklogPage.selectCov2(getdata("COV2"));
		wait(2);
		LLBacklogPage.clickRightarrow();
		LLBacklogPage.submit();
		wait(1);

		if (alertExist(driver)) {

			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
			
		LLBacklogPage.setApplication_and_LLnumber_inExcel();
		/*
		 * Flows validate = new Flows(driver); validate.RTOLevel_Status();
		 */
		LLBacklogPage.Clickon_LLLink();
		LLBacklogPage.Clickon_LLBacklogApprove();
		LLBacklogPage.Enter_LLBacklogApplicationno(getdata("ApplicationNo"));
		LLBacklogPage.Clickon_LLBacklogApplicationnoProceed();
		//driver.findElement(By.xpath("//button[@id = 'generateotp']")).click();
		LLBacklogPage.Verify_GenerateOTPforApproval();
		LLBacklogPage.Clickon_LLBacklogApprovebutton();
		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		driver.close();
		wait(10);
//		driver.get("https://sarathi.preprod.nic.in/sarathiservice/stateSelection.do");

	}
	
	
	@AfterMethod
	public void CloseBrowser() {
		System.out.println("**************After Method***************");
	}
	
}
