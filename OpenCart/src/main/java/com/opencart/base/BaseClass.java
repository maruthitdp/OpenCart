package com.opencart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import com.opencart.utils.ExtentManager;
public class BaseClass {
	
	public static FileInputStream fs;
	public static Properties properties;
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public void readProperties() {
		try {
			fs=new FileInputStream("src/test/resources/properties/application.properties");
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check the path again...");
			System.out.println(e.getMessage());
		}
		
		properties=new Properties();
		try {
			properties.load(fs);
		} catch (IOException e) {
			System.out.println("Could not load the properties...");
			System.out.println(e.getMessage());
		}
		reports=ExtentManager.getReports();
	}
	
	public void launchBrowser(Method method) {
		readProperties();
		test=reports.createTest(method.getName());

		
		

		String browserName=properties.getProperty("browser");
		switch (browserName) {
		case "chrome":
			driver=new ChromeDriver();
			test.log(Status.INFO, browserName+" browser is started..");
			break;
		case "FireFox":
			driver=new FirefoxDriver();
			test.log(Status.INFO, browserName+" browser is started..");
			break;
		case "Edge":
			driver=new EdgeDriver();
			test.log(Status.INFO, browserName+" browser is started..");
			break;

		default:
			driver=new ChromeDriver();
			test.log(Status.INFO, browserName+" browser is started..");
			break;
		}
		
	}
	
	public void openUrl() {
		readProperties();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		test.log(Status.INFO,  driver.getCurrentUrl()+" is opened" );
	}

}
