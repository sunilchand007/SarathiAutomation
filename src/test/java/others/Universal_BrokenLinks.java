package others;

import java.awt.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.net.ssl.SSLHandshakeException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.LoginPage;
import transactions.BrokenLinks;
import utility.Utilitymethods;

public class Universal_BrokenLinks extends BaseClass {
	WebDriver driver;

	
	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	

//	@Test(invocationCount = 1)
	public void FindBrokenLinks() throws MalformedURLException, IOException, SSLHandshakeException {
		BrokenLinks verifylinks = new BrokenLinks(driver);
		//verifylinks.SelectState();
		verifylinks.getLinksData();
	}
	
//	@Test(invocationCount = 1,enabled = false)
//	public void Verify_BrokenImages() throws MalformedURLException, IOException {
//		BrokenLinks verifyimg = new BrokenLinks(driver);
//		verifyimg.SelectState();
//		verifyimg.Verify_BrokenImages();
//
//	}
//
	@Test(invocationCount = 1 )
	public void Verify_BrokenLinksRTOend() throws MalformedURLException, IOException {
		BrokenLinks verifylinks = new BrokenLinks(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("upst");
		loginPage.setpassword("Sar@123");
		loginPage.ClickonLogin();
		//verifylinks.Verify_BrokenImages();
		verifylinks.getLinksData();
	}
//	
//	@Test(invocationCount = 1 )
//	public void Brokenlinks_sample() throws MalformedURLException, IOException {
//		
//		String homePage = "https://sarathicov.nic.in:8443";
//        String url = "";
//        HttpURLConnection huc = null;
//        int respCode = 200;
//        
//        driver = new ChromeDriver();
//        
//        driver.manage().window().maximize();
//        
//        driver.get(homePage);
//        
//       java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
//        
//        Iterator<WebElement> it = links.iterator();
//        
//        while(it.hasNext()){
//            
//            url = it.next().getAttribute("href");
//            
//            System.out.println(url);
//        
//            if(url == null || url.isEmpty()){
//System.out.println("URL is either not configured for anchor tag or it is empty");
//                continue;
//            }
//            
//            if(!url.startsWith(homePage)){
//                System.out.println("URL belongs to another domain, skipping it.");
//                continue;
//            }
//            
//            try {
//                huc = (HttpURLConnection)(new URL(url).openConnection());
//                
//                huc.setRequestMethod("HEAD");
//                
//                huc.connect();
//                
//                respCode = huc.getResponseCode();
//                
//                if(respCode >= 400){
//                    System.out.println(url+" is a broken link");
//                }
//                else{
//                    System.out.println(url+" is a valid link");
//                }
//                    
//            } catch (MalformedURLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        
//        driver.quit();
//
//    }

		
		
		
	
	

	
	
	@AfterMethod
	public void CloseBrowser() {
		System.out.println("**************After Method***************");
	}

}
