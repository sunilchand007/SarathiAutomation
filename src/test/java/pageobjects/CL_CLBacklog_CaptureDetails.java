package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class CL_CLBacklog_CaptureDetails extends BasePage{
	
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	Utilitymethods utilitymethods;
	
	public CL_CLBacklog_CaptureDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void capturedetailsinClbacklogPage() throws IOException, InterruptedException {
		if(driver.getPageSource().contains("CL Backlog Saved Successfully......")) {
			wait(10);
			cl01 = CL_Backlog(driver, "//div[@class='panel-body']/h4[1]");
			setdata("CL", cl01.substring(16).trim());
			System.out.println("CL No. "+ cl01);
			cl02 = CL_Approvedappno(driver, "//h3[2]");
			setdata("ApplicationNo", cl02.substring(23).trim());
			System.out.println("Application No. "+ cl02);
			setdata("Status", "Pass");
		}
			else
			{
			System.out.println("Due to Changes in CL Backlog Code,Unable to perform actions");
			}
		
	}
	
	protected String CL_Backlog(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));
			cl01 = ele.getText();
			System.out.println(cl01);

		} catch (Exception e) {
			System.out.println("Not allowed");
		}
		return cl01;

	}
	protected String CL_Approvedappno(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));

			cl02 = ele.getText();
			System.out.println(cl02);

		} catch (Exception e) {
			System.out.println("Not allowed");
		}
		return cl02;

	}
	

}
