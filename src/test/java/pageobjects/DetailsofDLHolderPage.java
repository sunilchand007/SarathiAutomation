package pageobjects;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;

public class DetailsofDLHolderPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public DetailsofDLHolderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(how = How.XPATH, using = "//select[@name='collectDL']")
	WebElement deliver;
	
	public void Selectbloodgrp() {
		try {
			WebElement ele = driver.findElement(By.xpath("//select[@id='bloodGroup']"));
			Select bgrp = new Select(ele);
			if (bgrp.getFirstSelectedOption().getText().equalsIgnoreCase("Select")) {
				System.out.println("Blood group is Selecting");
				setIndexValueInSelectBox(ele, 2);
			} else {
				System.out.println("Blood Group already selected");
			}

		} catch (NoSuchElementException e) {
			System.out.println("There is no Blood group option");
		}

	}
	@FindBy(how = How.XPATH, using = "//select[@id='surrOrgDL']")
	WebElement awareSurrender;	
	public void SelectawareSurrender(){
		String st=getdata("State");
		if (st.equals("MH")||st.equals("CH")){
			Select select = new Select(awareSurrender);
			select.selectByValue("YES");
			
		}
		else
			System.out.println("There is no Surrender drop-down");
	
	}
	@FindBy(how = How.XPATH, using = "//input[@id='envaction_enve_confirm']")
	WebElement Confirmbuttonindlsubmission;
	
	public void ConfirmbuttoninDLServsubmission() throws IOException, InterruptedException {
		stepstatus = basepage.clickElement(Confirmbuttonindlsubmission);
		reportEvent(stepstatus, "Able to click on Proceedbutton", "Unable to click on Proceedbutton", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
	}


	
public void SelectMethodOfDispatch() throws IOException, InterruptedException {
		
	// Locate the element that contains the text
	 try {
         // Locate the element that contains the text
         WebElement collectDLTextElement = driver.findElement(By.xpath("//*[contains(text(), 'How will you to collect DL')]"));
         WebElement collectDLTextElement1 = driver.findElement(By.xpath("//*[contains(text(), 'How would you like to Collect the DL')]"));
         // Check if the element is visible using the helper method
         if (isElementVisible(driver, collectDLTextElement) || isElementVisible(driver, collectDLTextElement1)) {
             // Proceed to interact with the select box only if the text is visible
             stepstatus = basepage.setValueInSelectBox(deliver, "P");
             reportEvent(stepstatus, "Able to Select collect DL", "Unable to Select collect DL", driver, true);
         } else {
             System.out.println("There is no CollectDL select box visible.");
         }
     } catch (NoSuchElementException e) {
         System.out.println("Element not found.");
     }

		
	}
@FindBy(how = How.XPATH, using = "//select[@id='collectDL']")
WebElement collectDL;
public void selecthowtocollectDL() {
	String Isdipreq = (getdata("IsDispatchHandReqd"));
	if (Isdipreq.equalsIgnoreCase("Y")) {
		stepstatus = basepage.clickElement(collectDL);
		Select select = new Select(collectDL);
		select.selectByVisibleText("By Post");
	} else {
		System.out.println("There is no How will you to collect DL");
	}
	
	 if(alertExist(driver)) {
			acceptAlert(driver);
		}else {
			System.out.println("There is no Confirmbutton");
		}
}
	
	
public static boolean isElementVisible(WebDriver driver, WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return (boolean) js.executeScript(
        "var element = arguments[0];" +
        "var style = window.getComputedStyle(element);" +
        "return (style.display !== 'none' && style.visibility !== 'hidden' && style.opacity !== '0');", 
        element
    );
}
	
	
	
	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



