package com.ilabassessment.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ilabassessment.actiondriver.Action;
import com.ilabassessment.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeSuite()
	public void loadConfig() throws IOException {
		
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked"); 
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")	+ "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp(String browserName) {
	 //   String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
			

		//Maximize the screen
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(),90);
		Action.pageLoadTimeOut(getDriver(), 90);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();

	}
	
	@AfterSuite
	public void afterSuite() {
	//	 extent.flush();
	}

	
}
