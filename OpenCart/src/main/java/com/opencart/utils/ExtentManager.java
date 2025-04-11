package com.opencart.utils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.base.BaseClass;



public class ExtentManager extends BaseClass {
	
	public static ExtentReports getReports()
	{
		
		String reportsFolderPath=System.getProperty("user.dir")+"\\reports";
		
		if(reports==null)
		{
			reports=new ExtentReports();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			String date = simpleDateFormat.format(new Date());
			//System.out.println(date);
			date=date.replace(":", "-");
			System.out.println(date);
			
			File reportsFile=new File(reportsFolderPath+"\\"+date+".html");
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(reportsFile);
			
			reporter.config().setDocumentTitle("OpenCart reTest Reports");
			
			reporter.config().setReportName("Regression Reports");
			
			reports.attachReporter(reporter);
			
		}
		
		return reports;
		
	}


}
