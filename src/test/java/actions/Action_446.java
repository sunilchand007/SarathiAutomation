package actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.RelatedApplicationsSearchPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;

public class Action_446 extends BaseClass{
	WebDriver driver;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	@Test(invocationCount = 1)
	public void TC_Search_Related_Applications() {

		
	
		stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.Mouserhoveron_Others();
	
		wait(20);
		stateSpecificHomePage.clickon_SearchRelatedApplications();
		RelatedApplicationsSearchPage relatedApplicationsSearchPage = new RelatedApplicationsSearchPage();
		relatedApplicationsSearchPage.SelectSearchTypee(getdata("Type"));
		relatedApplicationsSearchPage.Enter_SelectedType(getdata("Input"));
		relatedApplicationsSearchPage.Enter_Dateofbirth(getdata("DOB"));
		relatedApplicationsSearchPage.Clickon_Submit();
		

	}
}
