# Automation-Framework-for-Selenium-With-Java
This project explain different components in a Selenium framework in detail
 	Continuous Integration and Continuous Delivery




	

	




















TestNG:
TestNG is a testing framework inspired from Junit and NUnit and it is designed to cover different categories of testing like unit, integration, functional, end to end. TestNG is mostly used for test execution, controlling test execution, integrating test scripts with build/deployment tools and for reporting test results etc. There are plenty of features in TestNG and I am not going to cover all of them in this section. Please refer TestNG official website to understand different TestNG concepts, It is worth going through the TestNG concepts. Here are some of the concepts we frequently use in Selenium Automation.
Execution: TestNG follow 3 step process for executing test cases:
1.	Develop a test case/script and annotate it with TestNG annotations
2.	Create testing.xml and provide information about your test cases like which test cases to execute, which groups to execute, listener class if any, optional configuration/data parameters etc. 
3.	Execute test cases using TestNG framework
Annotations:
Below are some of the annotations we frequently use in Selenium automation:
1.	@BeforeSuite: The annotated method/script will be executed first before actual test cases are executed. Setup methods are usually annotated with @BeforeSuite method.
Example:
2.	@AfterSuite: The annotated method/script will be executed last after all the test cases in a suit are executed. Teardown methods are usually annotated with @ AfterSuite method
3.	@BeforeTest: The annotated method/script will be executed first before actual test case execution. Setup methods are usually annotated with @BeforeTest method.
4.	@AfterTest: The annotated method/script will be executed last after actual test case execution. Teardown methods are usually annotated with @AfterTest method.
5.	@BeforeGroups: The annotated method/script will be executed first before list of groups. Setup methods are usually annotated with @BeforeGroups method.
6.	@AfterGroups: The annotated method/script will be executed first before list of groups. Setup methods are usually annotated with @AfterGroups method.
Use below parameters if required while annotating a method with above annotations:
•	alwaysRun: For before methods (beforeSuite, beforeTest, beforeTestClass and beforeTestMethod, but not beforeGroups): If set to true, this configuration method will be run regardless of what groups it belongs to.For after methods (afterSuite, afterClass, ...): If set to true, this configuration method will be run even if one or more methods invoked previously failed or was skipped.
•	Groups:	The list of groups this class/method belongs to.
7.	@DataProvider: Method annotated with @DataProvider supply data to the test cases at the time of execution. The annotated method must return a 2D Object where each Object[] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.
a.	Name: The name of this data provider. If it's not supplied, the name of this data provider will automatically be set to the name of the method.
b.	parallel	If set to true, tests generated using this data provider are run in parallel. Default value is false.
c.	DataProvider method can accept parameters like ITestContext, Method etc. which can be determined at execution time and depending on Test context/method, data conditions and test cases/methods that require data can be determined.
8.	@Listeners: @Listeners can be defined at each class level or for all classes/test cases at a test suite level, groups level etc. in testing. Listeners is a very helpful feature in TestNG and it does listen and capture events during test execution which can be used for debugging and reporting.
a.	value: The list of variables used to fill the parameters of this method.
9.	@Test: This is the most important annotation in TestNG and it marks a class or method as a test case which will eventually be executed using TestNG framework.
a.	alwaysRun: If set to true, this test method will always be run even if it depends on a method that failed.
b.	dataProvider: The name of the data provider for this test method.
c.	dataProviderClass: The class where to look for the data provider. If not specified, the data provider will be looked on the class of the current test method or one of its base classes. If this attribute is specified, the data provider method needs to be static on the specified class.
d.	dependsOnGroups: The list of groups this test method depends on.
e.	dependsOnMethods: The list of methods this test method depends on.
f.	Description: The description for this test method.
g.	expectedExceptions: The list of exceptions that a test method is expected to throw. If no exception or a different than one on this list is thrown, this test will be marked a failure.
h.	Groups: The list of groups this test class/method belongs to.
i.	invocationCount: The number of times this test method should be invoked in an execution cycle.
j.	invocationTimeOut: The maximum number of milliseconds this test should take for the cumulated time of all the invocationcounts. This attribute will be ignored if invocationCount is not specified.
k.	Priority: The priority for this test method. Lower priorities will be scheduled first.
l.	singleThreaded: If set to true, all the methods on this test class are guaranteed to run in the same thread, even if the tests are currently being run with parallel="methods". This attribute can only be used at the class level and it will be ignored if used at the method level.
10.	@Ignore: @Ignore let TestNG ignore all the @Test methods in a class or in a particular package and its child packages
TestNG Listeners
There are several interfaces that allow us to modify the default behavior of TestNG. These interfaces are broadly called "TestNG Listeners". Here are a few listeners that are commonly used:
•	IReporter:  explain in detail
•	ISuiteListener: explain in detail 
•	ITestListener: explain in detail 
When you implement one of these interfaces, you can let TestNG know about it with either of the following ways:
•	Using -listener on the command line.
•	Using <listeners> with ant.
•	Using <listeners> in your testng.xml file.
•	Using the @Listeners annotation on any of your test classes.
•	Using ServiceLoader.

Test Suite:
Each testing.xml contains a test suite which contain multiple test cases. Test cases require to be executed, not executed, parallel execution etc.  can be controlled in different ways from testing.xml by using features like groups, classes, methods, include, exclude, parameters, dependencies, thread-count etc.  Please refer to TestNG official website to know more about testing.xml and its content.
Execution:
Test cases can be executed by invoking TestNG from testing.xml, with maven, with ant or from a command line to name a few. Test cases to be included or not included in each execution cycle can be controlled from testing.xml or using TestNG annotations at each test/group/package level and if a test case contain multiple test scenarios, each test scenario execution can be controlled using @DataProvider annotation or from external sources (example: from Excel using Apache POI). Data required for execution can be provided/received at execution time by using TestNG listeners, test contexts etc. I will explain more about passing data to a test case in following pages. 
<suite name="testsuite1" parallel="tests" thread-count="2">
Test cases/suites can be executed parallelly or in sequence by using Parallel and thread-count feature in TestNG at test suite level. Tests or methods or classes or instances can be executed parallelly and if parallel execution is enabled, make sure browser session is opened for each parallel execution and tests under each thread gets executed under same browser session. If this is not taken care, test execution will not be as expected and there could be test failures and un desired test results. Also, make sure browser instantiation happens properly in parallel execution.  
Test cases can be executed in a sequence by not providing parallel attribute in testing.xml and test case sequence can be controlled by using @Test, priority argument, test cases gets executed based on the order of priority with lowest to highest number. Test cases with priority=0 gets executed first before test cases with priority=1. If test cases have same priority, then test cases are executed I alphabetical order. JVM cannot wait for all test cases in priority=0 to be executed before picking up test cases with priority=1 and if there is any dependency between test cases, then use ‘depends on ‘option to specify the dependency.
Many of web applications should work in same way from different browsers like Chrome, edge, firefox, safari etc. and it is important to make sure test execution is performed from different browsers. To test browser compatibility, we do not have to execute all the test cases from different browsers. Test cases can be executed in parallel and each test set/suite can be invoked from different browser. It is important to control the type of browser test scripts should get executed at run time and pass browser to the framework at runtime using TestNG parameter or from environment configuration.
Rerunning failed tests
TestNG generate testng-failed.xml file with all the failed tests and necessary information to run these tests in the output directory. TestNG can be programmed to automatically retry whenever a test fails by binding a retry analyzer(org.testng.IRetryAnalyzer) to a test. More details about retry analyzer can be find in TestNG official website.
Selenium Tests component:
Selenium automation can be broadly categorized into test and core components. Test component contains all the test cases categorized/packaged based on the functionality and should just initialize core objects, invoke core components, test scenario flow, perform validations and assertions etc. A test case accept input, perform a business logic and produces an output or perform validations. To achieve better maintainability, scalability and re-usability, test cases should not contain any logic and test case should just get data from calling environment, instantiate required core components related objects, pass data the core components and receive output/validation results.
Selenium Core Components: 
Selenium core components is the actual framework that consists many components required to perform test execution of an application. All the objects/components required for execution should be abstracted from core components and should be provided to test components.  Core components should be designed in such a way that the tester who develop test cases should not worry about how objects like driver gets instantiated or destroyed. In a nut shell, testers are encapsulated from the complexities and critical aspects of the framework and exposed only to the abstract methods of core components and tests are executed by just invoking the objects of these abstract classes and static classes. Below are some of the core components:
Driver Manager Factory:
There should be only one instance/object of a web driver that drives the test case execution of an instance/session. This can be achieved using Factory Design pattern. Create a driver manager abstract class and have a multiple implementation of this class for each browser type (Chrome, IE, Firefox etc.), driver capabilities and desired capabilities can be provided in implementation of each driver type. Create a Driver manager factory to that produces Driver Manager object and its implementation driver type, then have a static instantiation of driver manager factory in Test Base.
Test Base:
Test Base class is the driver class of the framework which is used to initialize all the variables/parameters required across different components in the framework. Some of the arguments it initializes are file input stream object to read environment configurations (URL, User name, password, browser type etc.) & excel files, synchronization variables to define implicit and explicit wait times, Logger objects, listener objects, driver object etc. and methods to destroy all these objects after execution is completed. Explain more and have a diagram here
Driver Providers: 
This is one of the important components of framework and using this component, all the data required for execution of test cases can be manufactured. Test data can be provided using multiple ways and test scenario execution can also be controlled from data providers. 
Test data and/or input conditions required for generating test data can be maintained in an excel sheet and this excel spreadsheet can be read using Apache POI. We can have test scenarios and test date input conditions in an excel sheet and test data can be enriched from database by passing these data conditions. Fake data that look like real data can be generated using APIs like java faker/jfairy.
Test data can be provided using any or combination of below options:
1.	By using parameters in testing.xml
2.	By using configuration properties files
3.	By using API’s
4.	By using TestNG data provider and storing data in a separate class and annotating it with TestNG DataProvider
5.	By defining constant/static variables in a class and passing data from this class
6.	By using TestNG data provider and enriching the data provider class with data from an excel spreadsheet
Data can be provided to test cases at execution time by passing ITestContext or Method parameters to DataProvider class which can be determined at runtime and based on the test context, data can be generated. 
Element Wrapper Services:
For Re-usability purposes and easy maintainable it is better to have wrapper classes to perform operations like element clicks, getting data from an element, sending data to an element, switch windows etc. so that if there are any changes. Using standard WebElement methods like click (), sendkeys() may yield undesired results and test failures because of page rendering issues, page refresh and delay in page load due to network issues etc. It is a good practice maintain element wrappers separately in combination with synchronization and JavaScript executor to maintain element operations more efficiently.  Popular element operations are:
1.	SendKeys
2.	getText
3.	getAttribute
4.	element.clear
5.	alert accept/dismiss
6.	element click 
7.	select (select by index, select by visible text, select by value and deselect etc.)
8.	Switch Frame
9.	Switch window
10.	Switch to parent frame or default content
11.	Wait until clickable
12.	Wait until element is enabled/displayed
13.	Wait until element is disabled/invisible
14.	Wait for the presence of an element
Synchronization:
Synchronization is one of the important aspects of framework and performance and speed at which test cases can be executed depends on how efficiently framework components are synchronized. There are many factors influence application loading and web applications load differently in different browsers and in different networks. Along with application, browser and test tools can also influence test execution time. It is very important to have good synchronization techniques to achieve efficient and highly performing framework. Do not use hard coded wait times or Thread.sleep() in your code until and unless there is no other option.
Selenium WebDriver provides two types of waits - implicit & explicit. An explicit wait makes WebDriver wait for a certain condition to occur before proceeding further with execution. An implicit wait makes WebDriver poll the DOM for a certain amount of time when trying to locate an element.
Implicity Wait Syntax:
driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

Explicit Wait Syntax:
WebDriverWait wait = new WebDriverWait(driver,TimeOut);
wait.until(ExpectedConditions.elementToBeClickable(element));	
Selenium WebDriver provide one more option FluentWait that can define the maximum amount of time to wait for a specific condition and frequency with which to check the condition before throwing an exception.
Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver). withTimeout(Duration.ofSeconds(100)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
webElmnt = fluentWait.until(new ExpectedCondition<WebElement>() {
	                @Override
	                public WebElement apply(WebDriver driver) {
	                    return element;
	                }
	            });
Page Objects:
Page objects is one important aspect and component of selenium framework. Changes happen in web applications very frequently and it is very important to separate element definitions from test cases so that changes can be incorporated easily. Selenium provide Page Object Model design pattern to create web elements of a page, this model improves the maintenance. There should be one class for each page to define web elements and methods to perform actions/operations on those web elements. Page Factory is an inbuilt Paga Object model concept to optimize the definition of page elements using @FindBy annotation and with the help of PageFactory class.
 Common Utilities:
Logging:
Log4j can be used to capture the flow details of a test case in a file or a database and can be used for debugging, steps to reproduce an issue and reporting. 

Reporting:
Reporting is one other important aspect of any automation framework. Test execution and test summary reporting is very important in a testing life cycle and better testing report you have easier it is to take decisions on build and deployments of an application. By looking at the report, one should know the status of the project/application is and it should provide details like how many test cases passed, failed, no-run, not completed, defects etc. TestNG fulfill the reporting requirements for selenium automation framework. When testing.xml file is executed, emailable and viewable html reports get generated and placed in output directory. These reports can be beautified by adding screenshots and by rendering log messages on to the reports using TestNG Listeners and Reporter
Extent Report can also be integrated with TestNG default reporting framework to generate more detailed and readable reports. Screenshots at each failed test step and detailed logging information can be built into report using ExtentReports and ExtentTest classes.
Exception Handling:
Exception handling is one other important aspect of any software solution and better the exception handling, better the efficiency of the test execution. Test cases should not fail for the events that occur not so frequently and tests should not end abruptly. Selenium by default handle many Web Driver exceptions and your code should handle these exceptions and throw them appropriately. In some cases, test execution should continue with subsequent test cases even if one of the test cases fail and it should not end test execution abruptly. Exceptions can be handled using try multiple catch and finally blocks and by using throws keyword. The stack trace of the exception can be logged into logs for debugging and fixing for subsequent executions. In some of the cases, exception can also be used to perform certain actions/operations in the event of exception.
Configuration and Source Control: Environment configurations required to execute selenium test cases can be passed using TestNG parameters or by defining configuration parameters as properties files or by passing them using data files externally. 
Source control (or version control) is the practice of tracking and managing changes to code. Source control management (SCM) systems provide a running history of code development and help to resolve conflicts when merging contributions from multiple sources. Git is a popular source control and source management tool used in many companies. Code can be integrated in DevOps easily and can be executed using Git
Assertions: Assertions are very important part of test automation and it validates whether the state of the application is same to what it is expected to be. Selenium Assertions can be of soft asserts and hard asserts. Failure of hard assertion fails and stops the execution of a test case while soft assertion captures the exception/failure and continue with the execution. Use soft assertions if a test script has multiple validation requirements and hard assert if a requirement is to fail to test case on assert fail to be true. Selenium has ‘verify’ option as well which when fails, logs the exception and continue with execution. Popular selenium hard assertions are below:
•	assertEquals (actual, expected)
•	assertNotEquals (actual, expected)
•	assertTrue(condition)
•	assertFalse(condition)
•	assertNull (Property/Object)
•	assertNotNull (Property/Object)

Soft asserts can be implemented using SoftAssert() and validations can also be performed using waitFor a condition which turns to be true or false.
Design Patterns: 
A design patterns are well-proved solution for solving the specific problem/task. It is good coding practice and make framework more reliable, re-usable, maintainable and scalable with the use of design patterns. Selenium provide Page Object Model pattern to define web elements and element actions and depending on the requirements and scope, design patterns can be used in selenium automation framework design. Common used design patterns are Factory design pattern for manufacturing Driver objects, Decorator and composite patterns for defining web element wrappers and façade, decorator, composite etc. depending on the business logic and functional complexity while developing test cases and a framework.
Coding standards:
Coding standards help maintain consistency across the code and increase maintainability, usability and readability. Coding standards can be at below different levels:
1.	Naming standards for variables, parameters, methods, classes/test cases, Data elements etc. Maintain consistency in naming of variables, parameters, methods and classes across different elements/sections of the framework. Naming is one very important aspect to identify and understand what it does. By looking at the name of the variable/parameters, one should understand what it does. Example: Variable name: customerName clearly tell us that this variable stores the name of a Customer. Naming patterns in automation framework should also be consistent with page elements in an application. There should be a differentiation to differentiate Instance variables, local variables, static variables, function arguments etc. 

Methods usually perform an action based on produces an output, it is good to define methods as verbs and name of the method should tell calling environment what it does. Examples are set in method name set/assign data to instance/local variables in a class and getData method usually pass data to calling environment.

Use nouns while defining classes and interfaces and use of class names should be consistent with the application. For example, if a business entity is called as Customer in an application, define it as a customer in your framework but not as client or account.

2.	Comments: Comments is one important aspect for documentation and readability. Try to capture as much information as you can using comments and it helps testers and other team members understand the code better and can contribute efficiently. Depending on the need use block comments and one-line comments and keep details like version, date, author, change description and function/event that has been changed etc. in comments so that it can be understood easily. Comments can also be used to document everything starting from who developed it to who reviewed and approved block of code.

3.	General: Below are some of general guidelines for keeping code clean and better readable:
a.	Write Static variables in capital letters and use ‘_’ between different words
b.	Method names should be verbs with mixed case and start with lowercase letter
c.	Class and interface names should also be mixed case and use capital for all the words
d.	Use appropriate indentation
e.	Follow meaningful naming across framework
f.	Do not use long names. Make them crisp and precise and use abbreviations if required
g.	Naming of objects also should be consistent across. Example: name Web Driver object as driver and follow it consistently same across the framework
h.	Good to suffix test case names with Test. This can be used while executing test cases with build deployment tools like Maven.
i.	Use packages to group similar classes/test methods into same logical grouping
j.	Use TestNG annotation effectively. Example: Use priority to prioritize test cases, groups to group test cases to be executed together etc.
k.	Package Page objects together and use page names same as application and suffix them with page. Example: LoginPage.java, CheckOutPage.java
l.	Destroy all the objects at the end of test execution and purge data used for execution if necessary
m.	Initialize all the variables at the time of defining them
n.	Use appropriate access modifiers for classes, variables and methods. 
o.	Appropriate use of access modifiers in combination of getters/setters/constructors increases the security of code
p.	Use try catch finally blocks to catch exceptions appropriately then using throws keyword in method signature.
q.	Do not hardcode variables in any part of the code. 
r.	Define environment variables in properties files, pass run time parameters using TestNG parameters and test scenarios and execution flag using excel files.  If environment variables are more and frequently changing, maintain them in excel files and pass them from excel

Maven:
Maven is a build automation tool and using maven, test scripts can be integrated with DevOps/CICD (Continuous Integration continuous delivery) pipelines and can be executed. Maven collect all the dependencies and referenced libraries required for execution, MavenSurefile plugin of Maven is used for executing test cases. Go through ‘maven in 5 minutes’ documentation provided in official maven website to understand more about maven and how to convert exiting projects into maven projects, how to build projects and how to execute test cases using maven.
Cucumber Framework: Cucumber is a software product/framework that supports Behavioral driven development. Behavior-driven development (BDD) is an Agile software development methodology derived from Test Driven Development and it encourages collaboration among developers, QA and non-technical or business participants in a software project. 
Cucumber allows test cases to be written in plain English using Gherkin language by business analyst/product owner that can be understood by all stakeholders involved in software development, implementation and use. Cucumber helps fill the gap between technical, business teams and helps convert user stories into test cases using which can be used by developers for development and testers to automate testing and business teams to execute automated acceptance testing.
Cucumber test cases/framework can be written as a wrapper on top of Selenium framework and it can be done by adding below extra features to an existing selenium code.
1.	Create Feature files: These are files written in plain English using Gherkin language and with extension ‘. feature’. These files contain business requirement description written in below format and should be placed under features package in src/test/java folder:
Feature: Application Login
Scenario: Validate Login functionality
Given A user with valid login credentials
When User open a "Chrome" browser and launch a "URL" with username: "userName" and password: "password"
Then User can login to the application successfully 

2.	Step Definitions: For each of above statement (given, when and then) in feature file, steps should be created and placed in StepDifinitions package. These step definitions contain the logic required to execute the scenarios

package stepDefinations;

//import io.cucumber.junit.Cucumber;
import model.ICargoNavigation;
import objectRepository.MaintainAWBPage;
import resources.ReadExcelData;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//@RunWith(Cucumber.class) //use this step while executing the cucumber test scripts using jUnit
public class MyStepDefinitions {

    @Given("^A user with valid login credentials$")
    public void a_user_with_valid_login_credentials() {
        //Business logic
    }

    @When("^User open a \"([^\"]*)\" browser and launch a \"([^\"]*)\" with username: \"([^\"]*)\" and password: \"([^\"]*)\"$")
    public void user_open_a_something_browser_and_launch_a_something_with_username_something_and_password_something(String strArg1, String strArg2, String strArg3, String strArg4){
        //Business logic
    }

    @Then("^User can login to the application successfully $")
    public void user_can_login_to_the_application_successfully() {
        //Business logic
    }

}

3.	Test Runner: Test runner binds feature files and step definitions together and execute the test scenarios as jUnit test cases or TestNG test cases.
	package Testrunners;
	
	//import io.cucumber.junit.Cucumber;
	//import io.cucumber.junit.CucumberOptions;
	import org.junit.runner.RunWith;
	import io.cucumber.testng.CucumberOptions;
	
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	
	
	//@RunWith(Cucumber.class) //Enable this step to execute cucumber test cases as jUnit test cases
	@CucumberOptions(features = "src/test/java/features",glue = "stepDefinations")
	public class TestRunner 
	       // extends AbstractTestNGCucumberTests  //Enable this to execute the test cases as TestNG test cases
{	}
Use @RunWith to execute Cucumber using jUnit test cases and extend AbstractTestNGCucumberTests   in TestRunner class to execute cucumber test cases as TestNG test cases. Create a separate testng.xml file for executing Cucumber test cases and testng can also be integrated with build management tools and in DevOps processes as explained above.
Below dependencies are required for Cucumber framework:
1.	Eclipse Natural plug in to understand and support Cucumber Gherkin language
2.	Cucumber Dependent Jars:
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>xxx</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>xxx</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>xxx</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-core -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-core</artifactId>
			<version>xxx</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>gherkin</artifactId>
			<version>xxx</version>
		</dependency>		

		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-testng</artifactId>
			<version>xxx</version>
		</dependency>









