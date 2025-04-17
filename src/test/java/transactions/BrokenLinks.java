package transactions;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLHandshakeException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class BrokenLinks extends BasePage {
	
	 WebDriver driver;
	boolean stepstatus;

	public BrokenLinks(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}



	public void getLinksData() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
        
		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);
          // System.out.println("Element is : " + ele);
			
		   String uRL = ele.getAttribute("href");
		  
		   System.out.println("printing uRL :" + i);
		   System.out.println(uRL);
		   verifyLinks(uRL);
		}
          
		driver.quit();
		
	}	
		   

	
	public void verifyLinks(String linkUrl)
	{
	    try
	    {
	        URL url = new URL(linkUrl);

	        //Now we will be creating url connection and getting the response code
	        HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	    	httpURLConnect.setRequestMethod("HEAD");
	        httpURLConnect.setConnectTimeout(5000);
	        httpURLConnect.connect();
	        int responseCode = httpURLConnect.getResponseCode();
	        

			if (responseCode == 200) {
				System.out.println(linkUrl + " ::Status Code:: " + httpURLConnect.getResponseCode()
						+ " ::Connected InstanceID:: " + getInstance());
				httpURLConnect.disconnect();

			}
			else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkUrl + " - " + responseCode + " - " + HttpURLConnection.HTTP_NOT_FOUND);
				httpURLConnect.disconnect();
			}
			else if(responseCode>=400)
	        {
	        	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
	        	httpURLConnect.disconnect();
	        }    
	   
	        //Fetching and Printing the response code obtained
	        else{
	            System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            httpURLConnect.disconnect();
	        }
			
	    }catch (Exception e) {
//	    	e.printStackTrace();
	  }
	}

	
	
	
	//NOT IN USE MERGED IN THE ABOVE METHOD getlinksData
/*	public void verifyLinkActive(String linkUrl) {

		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

		//	httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " ::Status Code:: " + httpURLConnect.getResponseCode()
						+ " ::Connected InstanceID:: " + getInstance());

			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkUrl + " - " + httpURLConnect.getResponseCode() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}*/

	public String getInstance() {
		WebElement getInst = driver.findElement(By.xpath("//section[@class='footer_main']/div/div/div/div/div/p/b"));
		String getInsttext = getInst.getText();
		String Result = getInsttext;
		return Result;
	}

	public void gettotallinks() throws MalformedURLException, IOException, SSLHandshakeException {
		List<WebElement> linklist = driver.findElements(By.xpath("//a"));
		linklist.addAll(driver.findElements(By.xpath("//a")));
		System.out.println("Size of full links and images--->" + linklist.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for (int i = 0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getAttribute("href"));
			if (linklist.get(i).getAttribute("href") != null)
				activeLinks.add(linklist.get(i));
		}
		System.out.println("Size of active links and images--->" + activeLinks.size());
		// for (int j = 0; j < activeLinks.size(); j++) {
		// HttpURLConnection connection = (HttpURLConnection) new
		// URL(activeLinks.get(j).getAttribute("href"))
		// .openConnection();
		// connection.connect();
		// String response = connection.getResponseMessage();
		// connection.disconnect();
		// System.out.println(activeLinks.get(j).getAttribute("href") + " --->" +
		// response);
		// }
	}

	public void Verify_BrokenImages() {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total number of Images on the Page are " + images.size());
		for (int i = 0; i < images.size(); i++) {
			WebElement image = images.get(i);
			String imageURL = image.getAttribute("src");
			System.out.println("URL of Image " + (i + 1) + " is: " + imageURL);
			verifyImages(imageURL);

			try {
				boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript(
						"return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
						image);
				if (imageDisplayed) {
					System.out.println("DISPLAY - OK");

				} else {
					System.out.println("DISPLAY - BROKEN");

				}
			} catch (Exception e) {
				System.out.println("Error Occured");
			}

			ExportConsoleoutputtoTextfile("URL of Image " + (i + 1) + " is: " + imageURL);
		}
		

	}

	public static void ExportConsoleoutputtoTextfile(String text) {
		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(new FileWriter("./out.txt"));
			out.println(text);
			out.close();
		} catch (IOException e1) {
			System.out.println("Error during reading/writing");
		}
	}

	public static void verifyImages(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseCode() + "is a broken link");
			} else {
				System.out.println("HTTP STATUS - " + httpURLConnect.getResponseCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
