package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browser {

	public static WebDriver driver;
	public static FirefoxProfile profile;
	public static ChromeOptions opts;
	public static String mainwin;
	
	public Browser() {
	}

	public static WebDriver driver() {
		return driver;
	}
    //FF has to be version 46.0.1 to work with eclipse. There is bug in 47.0
	public static void initFF() {
	System.setProperty("webdriver.gecko.driver", "D:\\00-DISK-D\\WebDriver PXC Projects\\drivers\\geckodriver.exe");
	//FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\milka.stankova\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\t53k05xa.default"));
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	}
	
	public static void ResizeBrowserWindow(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	public static void initChrome() {     
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "D:\\00-DISK-D\\WebDriver PXC Projects\\drivers\\chromedriver.exe");
		options.addArguments("chrome.switches","--disable-extensions"); 
		//options.addArguments("C:\\Users\\milka.stankova\\AppData\\Local\\Google\\Chrome\\User Data");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	public static void initIE() {
		/*InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();
		InternetExplorerDriverService srvc = builder.usingPort(5555).withHost("127.0.0.1").build();*/
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		cap.setCapability(InternetExplorerDriver.SILENT, true);
		System.setProperty("webdriver.ie.driver", "D:\\00-DISK-D\\WebDriver PXC Projects\\drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver(cap);
		driver.manage().window().maximize();
	}

	public static void initEdge() {
	System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
    EdgeOptions options = new EdgeOptions();
	options.setPageLoadStrategy("eager"); 
	// Launch a new Edge instance
    driver = new EdgeDriver();

	}
	
	public static void initOpera() {                  
		System.setProperty("webdriver.opera.driver", "D:\\00-DISK-D\\WebDriver PXC Projects\\drivers\\operadriver.exe");
		//Initialize Opera driver
		driver = new OperaDriver();
		driver.manage().window().maximize();
	}
	
	public static void initHeadlessBrowser() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("cssSelectorsEnabled", true);
		capabilities.setVersion("42.0");
		capabilities.setJavascriptEnabled(true);
		// driver=new FirefoxDriver();
	}

	public static void open(String url) {
		driver.get(url);
	}

	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}

 
	public static void ClosePopFrame() {
			driver.switchTo().window(mainwin);
			WebElement CloseBtn = driver.findElement(By.id("TB_closeWindowButton"));
			CloseBtn.click();	
			System.out.println("Close popup frame");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void SwitchToMain() {
		Browser.driver.switchTo().window(Browser.mainwin);
	}
	
     public static void SwitchToFrame() {
		Browser.driver.switchTo().frame(0);
	}
		

}
	

