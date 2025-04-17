package actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;
import pageobjects.LLApprovalbatch;

public class Action_101 extends BasePage{

	WebDriver driver ;
	
	LLApprovalbatch LLApproval;
	
	@FindBy(how = How.XPATH, using = "//table/tbody/tr/td[2]/a")
	WebElement BioIDLink;
	@FindBy(how = How.XPATH, using = "//input[@value='Different Applicant']")
	WebElement DiffrentApplicant;
	@FindBy(how = How.XPATH, using = "//table[@id='detailsTable']/tbody/tr[2]/td[1]/input[@name='bioidValue']")
	WebElement CheckforSameApplicant;
	@FindBy(how = How.XPATH, using = "//input[@value='Same Applicant']")
	WebElement SameApplicant;

	@FindBy(how = How.XPATH, using = "//input[@value='ISSUE LL']")
	WebElement Issueall;
	@FindBy(how = How.XPATH, using = "//input[@value='Reject']")
	WebElement Rejectbutton;
	
	public void ApproveLL() {
		LLApproval = new LLApprovalbatch(driver);
		LLApproval.ClickonLLLink();
		LLApproval.ClickonLLAprovalbatchLink();
		LLApproval.ClickonRadiobutton();
		LLApproval.Set_Application_Number(getdata("ApplicationNo"));
		LLApproval.Clickon_Submitbutton();
		LLApproval.Clickon_Selectallcheckbox();
		LLApproval.Clickon_Issueallbutton();
		NewLLNumber = LL_No(driver, "//table/tbody/tr/td[5]/p");
		if (NewLLNumber.trim()
				.equalsIgnoreCase("Same Bioid Already Existed.Please go for bioid matcher Decision on Pop Up Window")) {

			System.out.println("Same Bioid Existed");
			clickElement(BioIDLink);
			wait(3);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println(tabs.size());

			if (isWindowExistsByURL("https://sarathicov.nic.in:8443/sarathiservice/bio_displayCurrent.do",
					driver) == true) {
				SwitchtoWindowByURL("https://sarathicov.nic.in:8443/sarathiservice/bio_displayCurrent.do", driver);
				showMenu();
				if (selectionString.equalsIgnoreCase("Different Applicant")) {
					System.out.println("Selected Different Applicant");
					try {
						clickElement(DiffrentApplicant);
						wait(2);
						tabs = new ArrayList<String>(driver.getWindowHandles());
						System.out.println(tabs.size());
						if (isWindowExistsByTitle("New LL Approval", driver) == true) {
							scrooldown(driver);
							clickElement(Issueall);
							wait(2);
							String licNo = driver.findElement(By.xpath("(//h4)[3]/label")).getText();
							LLApproval.setdata("LLNumber", licNo.trim());
							closeWindowByTitle("New LL Approved", driver);
							SwitchtoWindowByTitle("Bulk LL Approval", driver);
						}
					} catch (Exception e) {
						System.out.println("Exception Occured");
					}

				} else if (selectionString.equalsIgnoreCase("Same Applicant")) {
					System.out.println("Selected Same Applicant");
					List<WebElement> comparecov = driver
							.findElements(By.xpath("//table[@id='detailsTable']/tbody/tr/td[8]/input"));
					int count = comparecov.size();
					if (count >= 1) {
						System.out.println("Total Covs in a table: " + count);
						try {
							clickElement(CheckforSameApplicant);
							clickElement(SameApplicant);
							wait(2);
							tabs = new ArrayList<String>(driver.getWindowHandles());
							System.out.println(tabs.size());
							if (isWindowExistsByTitle("New LL Approval", driver) == true) {
								scrooldown(driver);
								String txt = driver.findElement(By.xpath("//textarea[@name='remarks']")).getText();
								System.out.println(txt);
								if (txt.equalsIgnoreCase(
										"Same Bioid Already Existed.Please go for bioid matcher Decision on Pop Up Window")) {
									clickElement(Rejectbutton);
									String rejecttxt = driver.findElement(By.xpath("//h4/span")).getText();
									setdata("LLNumber", rejecttxt);
									closeWindowByTitle("New LL Rejected", driver);
									SwitchtoWindowByTitle("Bulk LL Approval", driver);
								} else {
									// If Different COVS are present in DL It will process further
									clickElement(Issueall);
									wait(2);
									String licNo = driver.findElement(By.xpath("(//h4)[3]/label")).getText();
									LLApproval.setdata("LLNumber", licNo.trim());
									
									
								}

							}
						} catch (NoSuchWindowException e) {
							System.out.println("Exception Occured");
						}

					}

				} else {
					System.out.println("Selected Applicant not available.");
				}
			}

		} else {
			System.out.println(NewLLNumber.substring(25, 43).trim());
			LLApproval.setdata("LLNO", NewLLNumber.substring(25, 43).trim());
		}

	}

}
