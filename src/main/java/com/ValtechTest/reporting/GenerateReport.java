package com.ValtechTest.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {
	
	 public static void GenerateMasterthoughtReport(){
	        try{
	            String RootDir = System.getProperty("user.dir");
	            File reportOutputDirectory = new File("target");
	            List<String> list = new ArrayList<String>();
	          //for single browser report
		         list.add("target/cucumber-report/singleBrowser/singleBrowser.json");

	            String pluginUrlPath = "";
	            String buildNumber = "1";
	            String projectName = "Equal Experts";
//	            String buildProject = "cucumber-jvm";
	            boolean skippedFails = false;
	            boolean pendingFails = true;
	            boolean undefinedFails = true;
	            boolean missingFails = true;
	            boolean flashCharts = true;
	            boolean runWithJenkins = false;
	            boolean highCharts = false;
	            boolean parallelTesting = true;
	            boolean artifactsEnabled = false;
	            String artifactConfig = "";
	            
	            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
	         // optional configuration
	         configuration.setParallelTesting(parallelTesting);
	         configuration.setRunWithJenkins(runWithJenkins);
	         configuration.setBuildNumber(buildNumber);
	         // addidtional metadata presented on main page
	         configuration.addClassifications("Platform", "Windows");
	         configuration.addClassifications("Browser", "Firefox");
	         configuration.addClassifications("Sprint", "No.15");
	      //   configuration.addClassifications("Cycle", "No.2");
	         configuration.addClassifications("Test Scenario", "Booking and Cancellation");
	         configuration.addClassifications("User Stories", "smoke");

	            ReportBuilder reportBuilder = new ReportBuilder(list, configuration); 

	            reportBuilder.generateReports();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
}
