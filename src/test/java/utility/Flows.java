package utility;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.Action_102;
import actions.Action_103;
import actions.Action_115;
import actions.Action_123;
import actions.Action_132;
import actions.Action_135;
import actions.Action_159;
import actions.Action_227;
import actions.Action_225;
import actions.Action_387;
import actions.Action_145;
import actions.Action_142;
import actions.Action_240;
import actions.Action_120;
import actions.Action_205;
import actions.Action_239;
import actions.Action_246;
import actions.Action_133;
import actions.Action_210;
import actions.Action_105;
import actions.Action_101;
import actions.Action_209;
import actions.Action_241;
import actions.Action_Temporary_CL_Print;
import frameworkLibrary.BasePage;

import pageobjects.ApplicationStatusStage01Page;
import pageobjects.LLApprovalbatch;
import pageobjects.LoginPage;
import pageobjects.Login_DLTestResultsPage;
import pageobjects.RTO_LoginHomePage;
import pageobjects.ScrutinyPage;

public class Flows extends BasePage {
	
	WebDriver driver;
	boolean stepstatus;
	

	ApplicationStatusStage01Page applicationStatusstage01;
	ScrutinyPage Scrutiny;
	Login_DLTestResultsPage Login_DLTestResultsPage;
	
	

	LoginPage loginPage;
	
	
	RTO_LoginHomePage rto_loginHomePage;
	
	@FindBy(how = How.XPATH, using = "//h3[text()='Application is under processing at RTO Level.']")
	WebElement CaptureText;
	@FindBy(how = How.XPATH, using = "//input[@value='Process Flow']")
	WebElement Processflowbutton;
	@FindBy(how = How.XPATH, using = "//h3[text()='Licence has been Approved.']")
	WebElement CaptureCompletedText;
	@FindBy(how = How.XPATH, using = "//h3[text()='Application for  LL Edit entry has been approved successfully']")
	WebElement CaptureCompletedLLEditText;
	@FindBy(how = How.XPATH, using = "//h3[text()='Application for  DL Backlog entry has been approved successfully']")
	WebElement CaptureCompletedTextforbacklog;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	WebElement VerifyHome;
	
	@FindBy(how = How.XPATH, using = "//h3[text()='DL Backlog Saved Successfully......']")
	WebElement CaptureDLBAcklogmesg;
	
	@FindBy(how = How.XPATH, using = "//h3[text()='Application is under processing at RTO Level.']/following::table[1]/tbody/tr/td[5]")
	WebElement Allotmentinfonotavailable;
	@FindBy(how = How.XPATH, using = "//label[text()='Photo and Signature are Visible Properly']")
	WebElement labelforPhotoSign;
		
	@FindBy(how = How.XPATH, using = "//textarea/text()")
	WebElement Remarks;
	
	
	
	
	
	
	
	public Flows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyFlows() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		if (iselementExist(driver, "//button[@id='trsaction_ack_nextStatus']")) {
			driver.findElement(By.xpath("//button[@id='trsaction_ack_nextStatus']")).click();
			applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		    applicationStatusstage01.enterdetails_In_Applicationstaus();
			
		}
		else {
			System.out.println("Working application status page");
		
		}
		
		Verify_ApplicationCurrentStatus();

	}

	public void Verify_ApplicationCurrentStatus() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		wait(10);
		//driver.findElement(By.xpath("//input[@id = 'refreshbtn']")).click();
//		driver.findElement(By.xpath("//input[@id = 'entcaptxt']")).sendKeys("123456");
//		driver.findElement(By.xpath("//input[@id='submit']")).click();
		System.out.println(driver.getPageSource().contains("Stage(s) to be Completed"));
		if (driver.getPageSource().contains("Stage(s) to be Completed")) 
		{
			System.out.println("Starting Applicant Side Flows");
			scrooldown(driver);
			Initiate_Public_Flows();
		}else if (driver.getPageSource().contains("Application is under processing at RTO Level.")||driver.getPageSource().contains("Application Processing Stage") && driver.getPageSource().contains("Date of Birth")) {
				
			System.out.println("Application is under processing at RTO Level.Please wait Logging into for RTO process");
				scrooldown(driver);
				driver.findElement(By.xpath("//button[@id='applViewStages_0']")).click();
				Login();
					
		} else if (driver.getPageSource().contains("Application is under processing at RTO Level.") || driver.getPageSource().contains("DL Backlog Saved Successfully......")) {
			System.out.println("Application is under processing at RTO Level.Please wait starting RTO process");
			
		}else {
			System.out.println("Getting Miscommunication Please check");
		}
		RTOLevel_Status();
	}

	public void Login() {
		loginPage = new LoginPage(driver);
		wait(8);
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
		//driver.navigate().to(prop.getProperty(getdata("CASENV")));
		wait(8);
		loginPage.setUserName(getdata("username"));
		wait(5);
		loginPage.setpassword(getdata("Password"));
		loginPage.ClickonLogin();
//		RTO.ClickonMobile();
//		RTO.setMobileNumber(getdata("JPMobileno"));
//		RTO.ClickonPWDLessAuthentification();
//		RTO.chkconcentlogin();
//		RTO.ClickonSignIn();
//		wait(3);
//		RTO.SetOTP();
//		RTO.ClickonotpSubmitButton();
		
	}
	
	public void RTOLevel_Status() {
		rto_loginHomePage = new RTO_LoginHomePage(driver);
		wait(3);
		rto_loginHomePage.Clickon_Misc();
		rto_loginHomePage.Click_on_applicationstatus();
		rto_loginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
		rto_loginHomePage.Click_on_viewflows();
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;
	@FindBy(how = How.XPATH, using = "//ul[@class='errorMessage']/li/span")
	WebElement ViewflowsRejectedmesg;
	
	public void rtoFlows() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		
		//wait(5);
		//RTO flows code 
		wait(3);
		if (driver.getPageSource().contains("Stage(s) to be Completed") == false) {
			System.out.println("There are no public flows identified");
			wait(2);
			if (driver.getPageSource().contains("Application is under processing at RTO Level.") == true) {

				WebElement rtoflowstatus = driver.findElement(By.xpath("//h3[text()='Application is under processing at RTO Level.']/following::table[1]/tbody/tr/td[2]"));

				String rtoflowtext = rtoflowstatus.getText();
				System.out.println(rtoflowtext);
				if (rtoflowtext.contains("SCRUTINY - (Verification of Proof Documents)")) {
					rto_loginHomePage.Click_on_processflow();
					Action_103 action_103 = new Action_103();
					action_103.scrutiny();
					RTOLevel_Status();
				}
				else if (rtoflowtext.contains("FEE PAYMENT")) {
					//[@value="Fee Payment"
					//driver.findElement(By.xpath("//input[@id='submit']")).click();
					driver.findElement(By.xpath("//input[@value='Fee Payment']")).click();					
				//	rto_loginHomePage.Click_on_processflow();
					//RTPFeePayment();(refer action 134 methods while executing
					RTOLevel_Status();
				} else if (rtoflowtext.contains("CAPTURE PHOTO & SIGNATURE OFAPPLICANT")) {
					System.out.println("inside new capture ");
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_115 action_115 = new Action_115();
					action_115.CapturePhotoandSignature();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("CAPTURE PHOTO AND SIGNATURE OF APPLICANT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_115 action_115 = new Action_115();
					action_115.CapturePhotoandSignature();
					//OldCaptureBiometricsatFirefox();
					RTOLevel_Status();
				}
				else if (rtoflowtext.contains("RECORDING LL TEST RESULTS")) {
					
					rto_loginHomePage.Click_on_processflow();
					Action_102 action_102 = new Action_102();
					action_102.onlineLLtest();
					
				} else if (rtoflowtext.contains("APPROVAL OF LL BY LICENCING AUTHORITY")) {
					wait(2);
					Action_101  action_101 = new Action_101();
					action_101.ApproveLL();
					rto_loginHomePage = new  RTO_LoginHomePage(driver);
					rto_loginHomePage.Clickon_Misc();
					rto_loginHomePage.Click_on_applicationstatus();
					rto_loginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
					rto_loginHomePage.Click_on_viewflows();
					if (isDisplayed(ViewflowsRejectedmesg) == true) {
						clickElement(Logout);
					} else {
						RTOLevel_Status();
					}

				} 
				// else if (rtoflowtext.contains("PRINTING OF LEARNING LICENCE")) {
				// LLPrint();
				// }
				else if (rtoflowtext.contains("RECORD TEST RESULTS OF DRIVING TEST")) {
					rto_loginHomePage.Click_on_processflow();
					Action_210 action_210 = new Action_210();
					action_210.RecordDLTestResults();
					wait(1);
					RTOLevel_Status();

				} else if (rtoflowtext.contains("RECORD TEST RESULTS OF PSV BADGE")) {
					rto_loginHomePage.Click_on_processflow();
					//52924
					Action_209 action_209 = new Action_209();
					action_209.RecordPSVBadgeTestResults();
					wait(1);
					RTOLevel_Status();

				}
				else if (rtoflowtext.equals("APPROVAL OF DL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					
					Action_205 action_dlapproval = new Action_205();
					action_dlapproval.ApproveDL();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("PRINTING OF DL IN FORM 7 ( SMART CAR")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_120 action_120 = new Action_120();
					action_120.DLPrint();
					wait(2);
					RTOLevel_Status();
			} else if (rtoflowtext.contains("ATTACH OFFICE RECORDS")){
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					EnterApplicationNumberinOfficeRecordsPage(getdata("ApplicationNo"));
					ClickSubmitOfficeRecordsPage();
					wait(1);
					ClickOKinOfficeRecords();
					Action_123 action_123 = new Action_123(driver);
					action_123.uploadDocuments();
					RTOLevel_Status();	
			} else if (rtoflowtext.contains("DL BACKLOG RTO REMARKS")){	
				wait(2);
				rto_loginHomePage.Click_on_processflow();
				EnterApplicationNumberinRTORemarksPage(getdata("ApplicationNo"));
				SelectDLreason("Preceding Page of the DL Record not uploaded");
				driver.findElement(By.xpath("//*[@id='submit']")).click();
				RTOLevel_Status();	
				
					
				} else if (rtoflowtext.equals("APPROVAL OF DL BACKLOG")) {
					System.out.println("DLBACKLOG APPROVAL FLOW");
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					
					Action_239 action_dlbacklogApprove = new Action_239();
					action_dlbacklogApprove.ApproveDLBacklog();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DLEXTRACT REPORT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					//DLExtract();
				} else if (rtoflowtext.equals("APPROVAL OF ENDORSEMENTS ON DL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
				
					Action_246 action_dlendorsementapproval = new Action_246();
					action_dlendorsementapproval.ApproveOfENDORSEMENTSONDL();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DISPATCH OF THE DL AND PSV BADGE")) {
					wait(2);
					try {
						rto_loginHomePage.Click_on_processflow();
						VerifyDispatchdetails();
					} catch (NoSuchElementException e) {
						if (isDisplayed(Allotmentinfonotavailable) == true) {
							System.out.println(
									"Process Flow Button is not Available and " + Allotmentinfonotavailable.getText());
							clickElement(Logout);
							wait(2);
							driver.quit();
						}
					}

				} else if (rtoflowtext.equals("LL-EDIT APPROVAL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					LLApprovalbatch	LLApproval = new LLApprovalbatch(driver);
					LLApproval.LLEditApprove();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DL CLUB APPROVAL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_240 action_240 = new Action_240();
					action_240.DLClubApproval();
					RTOLevel_Status();
				} else if (rtoflowtext.trim().equals("CL TEST")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_142 cltestresutls = new Action_142();
					cltestresutls.RecordCLTestResults();
					RTOLevel_Status();
				} else if (rtoflowtext.trim().equals("APPROVAL OF CONDUCTOR LICENCE")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
				
					Action_159 action_159 = new Action_159();
					action_159.cLApproval();
					RTOLevel_Status();
				} else if (rtoflowtext.trim().equals("CL PRINT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_145  action_145  = new Action_145();
					action_145.CLPrint();
					RTOLevel_Status();
				}

				else if (rtoflowtext.trim().equals("APPROVAL OF ENDORSEMENTS ON CL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					
					Action_227 action_227 = new Action_227();
					action_227.CL_EndorsementApproval();
					RTOLevel_Status();
				}
				else if (rtoflowtext.trim().equals("APPROVAL OF TEMPORARY CONDUCTOR LICENCE")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
				
					Action_241 action_241 = new Action_241();
					action_241.Temporary_CL_Approval();
					RTOLevel_Status();
				}
				
				else if (rtoflowtext.trim().equals("CLEXTRACT REPORT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					
					 Action_387  action_387  = new  Action_387 ();
					 action_387.CL_ExtractReport();
					RTOLevel_Status();
				}
				else if (rtoflowtext.trim().equals("PROVISIONAL CL-PRINT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_Temporary_CL_Print action_Temporary_CL_Print = new Action_Temporary_CL_Print();
					action_Temporary_CL_Print.Temporary_CL_Print();
					RTOLevel_Status();
				} 
				else if (rtoflowtext.trim().equals("CL BACKLOG APPROVAL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
				
					Action_225 action_225 = new Action_225();
					action_225.CL_BacklogApproval();
					RTOLevel_Status(); 
					
				}
				
				else {
					System.out.println("There is no RTO Flow found");
				}

			} else if(driver.getPageSource().contains("Application Processing Stage")==true) {

				WebElement rtoflowstatus = driver.findElement(By.xpath("//*[@id=\"covTable\"]/tbody[2]/tr/td[2]/b"));

				String rtoflowtext = rtoflowstatus.getText();
				System.out.println(rtoflowtext);
				if (rtoflowtext.contains("SCRUTINY - (Verification of Proof Documents)")) {
					rto_loginHomePage.Click_on_processflow();
					Action_103 action_103 = new Action_103();
					action_103.scrutiny();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("FEE PAYMENT")) {
					//[@value="Fee Payment"
					//driver.findElement(By.xpath("//input[@id='submit']")).click();
					driver.findElement(By.xpath("//input[@value='Fee Payment']")).click();					
				//	rto_loginHomePage.Click_on_processflow();
					//RTPFeePayment();(refer action 134 methods while executing
					RTOLevel_Status();
				} else if (rtoflowtext.contains("CAPTURE PHOTO & SIGNATURE OFAPPLICANT")) {
					System.out.println("inside new capture ");
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_115 action_115 = new Action_115();
					action_115.CapturePhotoandSignature();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("CAPTURE PHOTO AND SIGNATURE OF APPLICANT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					
					Action_115 action_115 = new Action_115();
					action_115.CapturePhotoandSignature();
					//OldCaptureBiometricsatFirefox();
					RTOLevel_Status();
				}
				else if (rtoflowtext.contains("RECORDING LL TEST RESULTS")) {
					rto_loginHomePage.Click_on_processflow();
					Action_102 action_102 = new Action_102();
					action_102.onlineLLtest();
					
				} else if (rtoflowtext.contains("APPROVAL OF LL BY LICENCING AUTHORITY")) {
					wait(2);
					//ApproveLL();
					/*
					 * rto_loginHomePage = new Commom_RTO_Menu(driver); rto_loginHomePage.Clickon_Misc();
					 * rto_loginHomePage.Click_on_applicationstatus();
					 * rto_loginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
					 * rto_loginHomePage.Click_on_viewflows(); if (isDisplayed(ViewflowsRejectedmesg) ==
					 * true) { clickElement(Logout); } else { RTOLevel_Status(); }
					 */

				} 
				 else if (rtoflowtext.contains("PRINTING OF LEARNING LICENCE")) {
					 Action_105  action_105 = new Action_105();
					 action_105.LLPrint();
				
				 
				 }
				else if (rtoflowtext.contains("RECORD TEST RESULTS OF DRIVING TEST")) {
					rto_loginHomePage.Click_on_processflow();
					Action_210 action_210 = new Action_210();
					action_210.RecordDLTestResults();
					
					wait(1);
					RTOLevel_Status();

				} else if (rtoflowtext.equals("APPROVAL OF DL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_205 action_dlapproval = new Action_205();
					action_dlapproval.ApproveDL();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("PRINTING OF DL IN FORM 7 ( SMART CAR")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_120 action_120 = new Action_120();
					action_120.DLPrint();
					wait(2);
					RTOLevel_Status();
			} else if (rtoflowtext.contains("ATTACH OFFICE RECORDS")){
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					EnterApplicationNumberinOfficeRecordsPage(getdata("ApplicationNo"));
					ClickSubmitOfficeRecordsPage();
					wait(1);
					ClickOKinOfficeRecords();
					Action_123 action_123 = new Action_123(driver);
					action_123.uploadDocuments();
					RTOLevel_Status();	
			} else if (rtoflowtext.contains("DL BACKLOG RTO REMARKS")){	
				wait(2);
				rto_loginHomePage.Click_on_processflow();
				EnterApplicationNumberinRTORemarksPage(getdata("ApplicationNo"));
				SelectDLreason("Preceding Page of the DL Record not uploaded");
				driver.findElement(By.xpath("//*[@id='submit']")).click();
				RTOLevel_Status();	
				
					
				} else if (rtoflowtext.equals("APPROVAL OF DL BACKLOG")) {
					System.out.println("DLBACKLOG APPROVAL FLOW");
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_239 action_dlbacklogApprove = new Action_239();
					action_dlbacklogApprove.ApproveDLBacklog();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DLEXTRACT REPORT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					//DLExtract();
				} else if (rtoflowtext.equals("APPROVAL OF ENDORSEMENTS ON DL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_246 action_dlendorsementapproval = new Action_246();
					action_dlendorsementapproval.ApproveOfENDORSEMENTSONDL();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DISPATCH OF THE DL AND PSV BADGE")) {
					wait(2);
					try {
						rto_loginHomePage.Click_on_processflow();
						VerifyDispatchdetails();
					} catch (NoSuchElementException e) {
						if (isDisplayed(Allotmentinfonotavailable) == true) {
							System.out.println(
									"Process Flow Button is not Available and " + Allotmentinfonotavailable.getText());
							clickElement(Logout);
							wait(2);
							driver.quit();
						}
					}

				} else if (rtoflowtext.equals("LL-EDIT APPROVAL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					LLApprovalbatch	LLApproval = new LLApprovalbatch(driver);
					LLApproval.LLEditApprove();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DL CLUB APPROVAL")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
				
					Action_240 action_240 = new Action_240();
					action_240.DLClubApproval();
					RTOLevel_Status();
				} else if (rtoflowtext.trim().equals("CL TEST")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_142 cltestresutls = new Action_142();
					cltestresutls.RecordCLTestResults();
					RTOLevel_Status();
				} else if (rtoflowtext.trim().equals("APPROVAL OF CONDUCTOR LICENCE")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					Action_159 action_159 = new Action_159();
					action_159.cLApproval();
					RTOLevel_Status();
				} else if (rtoflowtext.trim().equals("CL PRINT")) {
					wait(2);
					rto_loginHomePage.Click_on_processflow();
					
					Action_145  action_145  = new Action_145();
					action_145.CLPrint();
					RTOLevel_Status();
				}

				else {
					System.out.println("There is no RTO Flow found");
				}

				
				
			}else {
				if (driver.getPageSource().contains("Licence has been Approved.") == true) {
					System.out.println("RTO Flows has been Completed for the Application number: "
							+ getdata("ApplicationNo") + " and  " + CaptureCompletedText.getText());
					clickElement(Logout);
					// driver.quit();
				} else if (driver.getPageSource()
						.contains("Application for  DL Backlog entry has been approved successfully") == true) {
					System.out.println(CaptureCompletedTextforbacklog.getText() + " for the Application Number: "
							+ getdata("ApplicationNo"));
					clickElement(Logout);
					driver.quit();
				} else if (driver.getPageSource()
						.contentEquals("Application for  LL Edit entry has been approved successfully") == true) {
					System.out.println(CaptureCompletedLLEditText.getText() + " for the Application Number: "
							+ getdata("ApplicationNo"));
					clickElement(Logout);
					driver.quit();
				}

			}
		} else {
			System.out.println("Public Flows Identified from RTO Side");
			List<WebElement> ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
			int count = ele.size();
			for (int i = 0; i < count; i++) {
				ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
				WebElement webele = ele.get(i);
				String text = webele.getText();

				if (!text.contains("Completed")) {

					if (!text.contains("Exempted")) {
						WebElement Flowtext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+"
								+ i + "]/td[@id='statusId']/preceding-sibling::td"));
						String flowtext = Flowtext.getText();
						if (flowtext.contains("UPLOAD DOCUMENTS")) {
							Action_123 action_123 = new Action_123(driver);
							action_123.uploadDocuments();
						} else if (flowtext.contains("UPLOAD PHOTO AND SIGNATURE")) {
						
							Action_135 action_135 = new Action_135(driver);
							action_135.uplaodphotoandsignature();
							
						} else if (flowtext.contains("FEE PAYMENT")) {
							//FeePayment(); (refer action 134 methods while executing
						} else if (flowtext.contains("LL TEST SLOT BOOKING")) {
							//LLSlotBooking();(refer Action 132 and remove this later 
							Action_132 action_132 = new Action_132(driver);
							action_132.LLslotbooking();
						} else if (flowtext.contains("DL SLOT BOOK")) {
						
							Action_133 action_133 = new Action_133();
							action_133.DLSlotbooking();
						} else if (flowtext.trim().contains("LL/DL SERVICES SLOT BOOK")) {
							
							Action_133 action_133 = new Action_133();
							action_133.LL_DL_ServiceSlotbooking();
						} else {
							System.out.println(flowtext + " Applicant Flow is Not Availble");
						}
					} else {
						System.out.println("Flow Exempted");
					}

				} else {
					System.out.println(text);
				}
			}
			try {
				Verify_ApplicationCurrentStatus();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
	}

	
	
	
	public void Initiate_Public_Flows() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
		int count = ele.size();
		for (int i = 0; i < count; i++) {
			ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
			WebElement webele = ele.get(i);
			String text = webele.getText();

			if (!text.contains("Completed")) {

				if (!text.contains("Exempted")) {
					WebElement Flowtext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
							+ "]/td[@id='statusId']/preceding-sibling::td"));
					String flowtext = Flowtext.getText();
					System.out.println("The Next Flow is "+ flowtext);
					if (flowtext.contains("UPLOAD DOCUMENTS")) {
						wait(20);
						Action_123 action_123 = new Action_123(driver);
						action_123.uploadDocuments();
						applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
					    applicationStatusstage01.enterdetails_In_Applicationstaus();
						
					} else if (flowtext.contains("UPLOAD PHOTO AND SIGNATURE")) {
						wait(20);
						Action_135 action_135 = new Action_135(driver);
						action_135.uplaodphotoandsignature();
						applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
					    applicationStatusstage01.enterdetails_In_Applicationstaus();
						
					}else if (flowtext.contains("E-SIGN DOCUMENT")) {
						System.out.println("Inside the E-sign document");
						driver.findElement(By.xpath("//button[@id = 'applViewStages_0']")).click();
						driver.findElement(By.xpath("//input[@id = 'submitbtn']")).click();
						driver.findElement(By.xpath("//input[@id = 'ok']")).click();
						driver.findElement(By.xpath("//button[@id = 'eSignButton']")).click();
						driver.findElement(By.xpath("//input[@id='entcaptxt']")).sendKeys("123456");
						driver.findElement(By.xpath("//input[@id='submit']")).click();
						if (alertExist(driver)) {
							dismissAlert(driver);
							System.out.println("Able to cancel the button ");
						} else {
							System.out.println("unable to cancel the button ");
						}
						applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
					    applicationStatusstage01.enterdetails_In_Applicationstaus();
						
					} else if (flowtext.contains("FEE PAYMENT")) {
						wait(20);
						//FeePayment();(refer action 134 methods while executing
						applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
					    applicationStatusstage01.enterdetails_In_Applicationstaus();
						
						
					} else if (flowtext.contains("LL TEST SLOT BOOKING")) {
						wait(20);
					//	LLSlotBooking();refer action 132 and remove this later 
						Action_132 action_132 = new Action_132(driver);
						action_132.LLslotbooking();
						applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
					    applicationStatusstage01.enterdetails_In_Applicationstaus();
						
					} else if (flowtext.contains("DL TEST SLOT BOOKING")) {
						wait(20);
						
				
						Action_133 action_133 = new Action_133();
						action_133.DLSlotbooking();
						//appstatus=new ApplicationStatusPage(driver);
//						driver.findElement(By.xpath("//input[@id='home']")).click();
//						driver.findElement(By.xpath("//html/body/div[4]/div/div[2]/div[2]/div/a[1]")).click();
						//appstatus.enterCaptcha();
						driver.findElement(By.xpath("//input[@id='home']")).click();
						driver.findElement(By.xpath("//html/body/div[4]/div/div[2]/div[2]/div/a[1]")).click();
						//captcha_Handling_Applicationstatus();

						//captcha_Handling_Applicationstatus();


					} else if (flowtext.trim().contains("LL/DL SERVICES SLOT BOOK")) {
						wait(20);
						Action_133 action_133 = new Action_133();
						action_133.LL_DL_ServiceSlotbooking();
						applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
					    applicationStatusstage01.enterdetails_In_Applicationstaus();
						
					} else {
						System.out.println(flowtext + " Applicant Flow is Not Availble");
					}
				} else {
					System.out.println("Flow Exempted");
				}

			} else {
				System.out.println(text);
			}
		}
	        
		Verify_ApplicationCurrentStatus();//---Remove this line only for MH DL Ticket
		
		RTOLevel_Status();

	}

	





	

	
	
	
		   
	 
	
	





	

	

	

	

	



	

		

	

	


	public void VerifyDispatchdetails() {
		if (driver.getPageSource().contains("For this RTO Dispatch agency Master details not avaliable")) {
			clickElement(Logout);
			wait(2);
			driver.quit();
		} else {
			System.out.println("Implement Pending for this FLOW");
		}

	}

	
	
	@FindBy(how = How.XPATH, using = "//input[@id='1']")
	WebElement AttachofficeRecords;
	public void AttachOfficeRecords(){
		stepstatus = clickElement(AttachofficeRecords);
		reportEvent(stepstatus, "Able to Click AttachofficeRecords", "Unable to Click AttachofficeRecords", driver, true);
		wait(5);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='submitbtn']")
	WebElement SubmitinOfficeRecords;
	public void ClickSubmitOfficeRecordsPage(){
		stepstatus = clickElement(SubmitinOfficeRecords);
		reportEvent(stepstatus, "Able to Click Submit in OfficeRecordsPage", "Unable to Click Submit in OfficeRecordsPage", driver, true);
		wait(2);	
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='attachDecla2']")
	WebElement CheckBoxinOfficeRecords;
	public void Checkbox2(){
		stepstatus = clickElement(CheckBoxinOfficeRecords);
		reportEvent(stepstatus, "Able to Click Submit in OfficeRecordsPage", "Unable to Click Submit in OfficeRecordsPage", driver, true);
		wait(2);	
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	WebElement ClickOkInOfficerecords;
	public void ClickOKinOfficeRecords(){
		stepstatus = clickElement(ClickOkInOfficerecords);
		reportEvent(stepstatus, "Able to Click Submit in ", "Unable to Click Submit in ", driver, true);
		wait(2);
	
	}
	@FindBy(how = How.XPATH, using = "//input[@id='applicationNum']")
	WebElement setapplnoinOfficeRecordsPage;

	public void EnterApplicationNumberinOfficeRecordsPage(String value) {
		stepstatus = setText(setapplnoinOfficeRecordsPage, value);
		reportEvent(stepstatus, "Able to set text", "Unable to set text", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@id='applNo']")
	WebElement setapplnoinRTORemarksPage;
	//*[@id='dlBacklogRTOGetDet_fetch']
	@FindBy(how = How.XPATH, using = "//*[@id='dlBacklogRTOGetDet_fetch']")
	WebElement ClickOkinRTORemarksPage;
	public void EnterApplicationNumberinRTORemarksPage(String value) {
		stepstatus = setText(setapplnoinRTORemarksPage, value);
		reportEvent(stepstatus, "Able to set text", "Unable to set text", driver, true);
		stepstatus = clickElement(ClickOkinRTORemarksPage);
		reportEvent(stepstatus, "Able to click submit in rto remarks page", "Unable to click submit in rto remarks page", driver, true);
	
	}
	
	
	
	
	
	//*[@id='reasonForRtoRemarks']
	@FindBy(how = How.XPATH, using = "//select[@id='reasonForRtoRemarks']")
	WebElement RTOReason;
	public void SelectDLreason(String value) {
		stepstatus = setOptionInSelectBox(RTOReason, value);
		
		reportEvent(stepstatus, "Able to Select DL Reason", "Unable to Select DL Reason", driver, true);
	}

	



	
	
	


}
