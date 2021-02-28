package com.flipkart.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class Base {

	public static ExtentReports createExtentReport()
	{
		ExtentReports extent= new ExtentReports("/Users/superman/Assignment/Flipkart_automation/com.automation/Extent Reports/Assignment_cases_Report.html", true);

		//report will be generated at given location
		return extent;


	}


}
