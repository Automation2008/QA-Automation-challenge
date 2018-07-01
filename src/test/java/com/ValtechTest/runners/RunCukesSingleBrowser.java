package com.ValtechTest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.ValtechTest.stepDefinitions"},
       // tags="@test1",
        plugin ={"json:target/cucumber-report/singleBrowser/singleBrowser.json"})

			public class RunCukesSingleBrowser extends AbstractTestNGCucumberTests {
	
			}