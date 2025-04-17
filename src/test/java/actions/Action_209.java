package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.IssueofPSVBadgeToDriverDLPage;

public class Action_209 extends BasePage{

	WebDriver driver ;
	public void RecordPSVBadgeTestResults() {
		scrooldown(driver);
		IssueofPSVBadgeToDriverDLPage IPSVB=new IssueofPSVBadgeToDriverDLPage(driver);
		IPSVB.Enter_ApplicationNumber1();
		wait(3);
		IPSVB.Clickon_Submit3();
		IPSVB.Enter_TestDate();
		IPSVB.selectResult();
		IPSVB.selectTestType();
		IPSVB.Clickon_Submit2();
}
}
