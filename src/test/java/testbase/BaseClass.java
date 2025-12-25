package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j

public class BaseClass {
	
	 public static WebDriver driver;
	 public Logger logger; // to get log files
	 public Properties p;
	 
		@BeforeClass(groups = {"Sanity","Master","Regression"})
		@Parameters({"browser","os"})
		public void Setup(String br, String os) throws IOException  {
			
			//loading config.properties file
			
			FileReader file =new FileReader("./src//test//resources//config.properties");
			p= new Properties();
			p.load(file);
			
			logger = LogManager.getLogger(this.getClass());
			
			
			
			switch(br.toLowerCase()){
			
			case "chrome": driver= new ChromeDriver();break;
			case "edge"  : driver= new EdgeDriver();break;
			case "firefox": driver =new FirefoxDriver();break;
			default: System.out.println("invalid browser name"); return;				
				
			}		
			
			driver.manage().deleteAllCookies();
			driver.get(p.getProperty("appURL")); // reading URL from config.properties file
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();		

		}
		@AfterClass(groups = {"Sanity","Master","Regression"})
		public void teardown() {
			driver.quit();

		}
		
		// creating java user defined methods for re-usable purpose
		
		@SuppressWarnings("deprecation")
		public String randomString() {		// to generate random name and email prefix

			String generatedString = RandomStringUtils.randomAlphabetic(5);
			return generatedString; 	

		}
		
		@SuppressWarnings("deprecation")
		public String randomNumber() {	// to generate random mobile number
			
			String generatedNumber = RandomStringUtils.randomNumeric(10);
			return generatedNumber;	

		}
		@SuppressWarnings("deprecation")
		public String randomPwd() {	// to generate random pwd (alphabet +numeric)
			
			String generatedString = RandomStringUtils.randomAlphabetic(5);
			String generatedNumber = RandomStringUtils.randomNumeric(10);
			return generatedString +"&"+ generatedNumber;	

		}
		
		// to capture the failed test screen whenever onTestfail() triggered in ExtendReport manager utility file 
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}


}
