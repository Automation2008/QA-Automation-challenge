## For this test, I have created maven project and picked up BDD framework with simple POM pattern without page factory implementation.

## Prerequisites
* IDE (Eclipse or any equivalent)
* Java 8 JDK (http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* Maven 3 (https://maven.apache.org/download.cgi)
* Win64 with Firefox Browser 57 and above
* Selenium 3.13.0


## Steps to run the Tests
* Pull the below project down from github.
* Import it into IDE
* Open CMD and navigate to directory where project is located
* Run below CLI command to run the tests (might take time to download the dependencies if not on your local machine)

```
mvn clean install -P runTestsSingleBrowser
```

## Viewing the reports if interested
* Refresh the project having done execution
* Cucumber reports are in: target/cucumber-html-reports
* In cucumber-html-reports folder you will find many html files but if you open `overview-features.html` in a web browser, you can see the all Features Statistics.
* If you click any feature it takes you to that particular Feature Report
* If any step is failed, it will be highlighted in red



