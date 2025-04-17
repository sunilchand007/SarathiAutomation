package transactions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BaseClass;
import pageobjects.DLclubbingPage;
import pageobjects.NewDLSubmissionPage;
import pageobjects.StateSpecificHomePage;

public class Transaction_538 extends BaseClass{

	WebDriver driver;
	public void Menuitem_DLClub() {
	
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.Mouserhoveron_DrivingLicence();
		stateSpecificHomePage.clickon_DLClub();
		DLclubbingPage dLclubbingPage = new DLclubbingPage();
		dLclubbingPage.select_State(getdata("State"));
		dLclubbingPage.select_RTO(getdata("RTOCode"));
		dLclubbingPage.Enter_Licnoone(getdata("LicNo1"));
		dLclubbingPage.Enter_Licnotwo(getdata("LicNo2"));
		dLclubbingPage.Clickon_Submitbutton();
	
		
		wait(2);
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		String title = driver.getTitle();
		if (title.equals("Acknowledgement for DL Club")) {
			setdata("ApplicationNo", AppNum.substring(3).trim());
			setdata("DateofBirth", DOB.substring(3).trim());
			setdata("StatusofApplication", "Success");

		} else {
			System.out.println("DL Club not submitted");
			setdata("StatusofApplication", "Fail");
		}
	}
	
	
}
