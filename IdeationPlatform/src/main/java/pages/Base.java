package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
	
	Actions actions = new Actions(Browser.driver); 
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
		
	 public void visit (String url){Browser.driver.get(url); 	}
	 
	 public  WebElement find (By locator){ return Browser.driver.findElement(locator); 	}
	 
	 public  void click(By locator){	find(locator).click(); 	}
	 
	 public  void PrintText(By locator) {
		 System.out.println(find(locator).getText());
	 }
	 
	 
	 public  Boolean isDisplayed(By locator){
			try {
				return find(locator).isDisplayed();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}
		}
	 
	 public  Boolean isDisplayed(By locator, int MaxTime){
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),MaxTime);
			} catch (org.openqa.selenium.TimeoutException e) {
				return false;
			}
			return true;
		}
	 
	 public  void WaitForPresence(By locator, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.presenceOfElementLocated(locator),MaxTime);
			} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
	 
	 public  void WaitForVisibility(By locator, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),MaxTime);
			} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
	 
	 public void WaitForWebElementVisibility(WebElement el, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.elementToBeClickable(el), MaxTime);
				} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
	 
	 public  void WaitForClickable(WebElement el, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.elementToBeClickable(el), MaxTime);
				} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
		
		private  void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
			timeout=timeout !=null?timeout:5;
			WebDriverWait wait=new WebDriverWait(Browser.driver, timeout);
			wait.until(condition);
		}
		
		//scroll to web element
		public void ScrollToElement (WebElement el)  {
		WebDriverWait wait = new WebDriverWait(Browser.driver, 30);	
		((JavascriptExecutor) Browser.driver).executeScript("arguments[0].scrollIntoView(true);", el);
		wait.until(ExpectedConditions.visibilityOf(el));
		}	
		
		public static void ScrollToBottom() {
			JavascriptExecutor jse = (JavascriptExecutor)Browser.driver;	
			jse.executeScript("scroll(0, 250);");
		}
		
		public void MoveToElement(WebElement el) {
			Actions action = new Actions(Browser.driver);
			action.moveToElement(el).perform();
		}
		
		public void ClickFormatDescBold(){
			List<WebElement> btn = Browser.driver.findElements(By.xpath("//span[@class='k-tool-icon k-bold']"));
			btn.get(1).click();
		}
		
		public void ClickFormatDescItalic(){
			List<WebElement> btn = Browser.driver.findElements(By.xpath("//span[@class='k-tool-icon k-italic']']"));
			btn.get(1).click();
		}
		
		public void ClickFormatDescBulets(){
			WebElement btn = Browser.driver.findElement(By.xpath("//span[@class='k-tool-icon k-insertUnorderedList']"));
			btn.click();
		}
		
	    public void ConfirmDelete(){
		    WaitForVisibility(By.xpath("//*[@class='modal fade in']"),3);
		    WebElement DeleteOKBtn = Browser.driver.findElement(By.xpath("//*[@class='btn btn-primary'][@data-dismiss='ok']"));
		    DeleteOKBtn.click();  	
		  }
	    
	    public void ConfirmCopyURL(){
		    WaitForVisibility(By.xpath("//*[@class='modal fade in']"),3);
		    WebElement CopyURLBtn = Browser.driver.findElement(By.id("btnCopyToClipboard"));
		    CopyURLBtn.click();  	
		  }
	    
	    
}
