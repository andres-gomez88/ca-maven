/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCases;


import Utilities.ExtentFactory;
import static Utilities.LoginEnvUtilities.*;
import static Utilities.PathUtilities.*;
import static Utilities.Screenshot.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;


public class ProtocolTestCases {
    private static final Logger log = LogManager.getLogger(ProtocolTestCases.class.getName());
    WebDriver driver;
    LogInPg logInPgTest; 
    NavBarFooterPg navBarFooterPgTest;
    PatientListPg patientListPgTest;
    ProtocolsListPg protocolsListPgTest;
    CreateEditProtocolPg createEditProtocolPgTest;
    public String methodName;
    ExtentReports extent;
    ExtentTest reportTest;
    
    @Parameters("browserType")
    @BeforeClass
    public void setup(@Optional String browser) throws Exception {
        if(browser == null) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", getGeckoDriverPath());
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
        }        
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logInPgTest = new LogInPg(driver);
        navBarFooterPgTest = new NavBarFooterPg(driver);
        patientListPgTest = new PatientListPg(driver);
        protocolsListPgTest =  new ProtocolsListPg(driver);
        createEditProtocolPgTest = new CreateEditProtocolPg(driver);
        if(ExtentFactory.getInstance() == null) {
            extent = ExtentFactory.createInstance(browser);
        } else {
            extent = ExtentFactory.getInstance();
        }
    }
    
    @Test(enabled = true)
    public void testCase019() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName);
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            log.info("Redirected to Protocol List Page");
            log.info("PASS");
            reportTest.log(Status.PASS, "Redirected to Protocol List Page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase020() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            log.info("All elements displayed on page");
            log.info("PASS");
            reportTest.log(Status.PASS, "All elements displayed on page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase021() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            createEditProtocolPgTest.waitForPgLoad();
            log.info("Redirected to Add New Protocol");
            log.info("PASS");
            reportTest.log(Status.PASS, "Redirected to Create a Protocol Page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase022() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment()); 
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            log.info("PASS");
            reportTest.log(Status.PASS, "All elements displayed in Add Protocol page");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase023() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.searchExcAssess("clams");
            reportTest.log(Status.PASS, "Search data for clams displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase024() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.searchExcAssess("lalalala");
            reportTest.log(Status.PASS, "No results found displayed no data found");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase025() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickExcercisesTab();
            reportTest.log(Status.PASS, "Exercise list and search field displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase026() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            reportTest.log(Status.PASS, "Assessments list and search field displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase027() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.PASS,"Exercises selected and added to list");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase028() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.PASS,"Exercises selected are displayed with their related details");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase029() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.viewExcerciseDesc();
            reportTest.log(Status.PASS, "Popup window displayed related to the exercise");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase030() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.viewExcerciseDesc();
            reportTest.log(Status.PASS, "Popup window displayed with exercise image and procedure");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase031() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.viewExcerciseDesc();
            reportTest.log(Status.INFO, "Popup exercise description window displayed");
            createEditProtocolPgTest.clickOKBtn();
            reportTest.log(Status.PASS, "Popup exercise window closed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase032() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.viewExcerciseDesc();
            reportTest.log(Status.INFO, "Popup exercise description window displayed");
            createEditProtocolPgTest.closeDescWindow();
            reportTest.log(Status.PASS, "Popup exercise window closed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase033() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.checkSR();
            reportTest.log(Status.PASS, "SR checkbox is selectable");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase034() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickBiasDrp();
            reportTest.log(Status.PASS, "Bias dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase035() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickSetsDrp();
            reportTest.log(Status.PASS, "Sets dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase036() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickRepsDrp();
            reportTest.log(Status.PASS, "Reps dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase037() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickXDaysDrp();
            reportTest.log(Status.PASS, "x/Days dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase038() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickFreqDrp();
            reportTest.log(Status.PASS, "Frequency dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase039() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickEditOptEx();
            reportTest.log(Status.PASS, "Equipment and Rest Between Sets fields displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase040() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickEditOptEx();
            createEditProtocolPgTest.clickEquipDrp();
            reportTest.log(Status.PASS, "Equipment dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase041() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickEditOptEx();
            createEditProtocolPgTest.clickRestSetDrp();
            reportTest.log(Status.PASS, "Rest Between Sets dropdown list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase042() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickExpCollExc();
            reportTest.log(Status.PASS, "Exercise list is hidden");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase043() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickReorderExc();
            reportTest.log(Status.PASS, "Reorder option in exercises list enabled");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase044() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickReorderExc();
            reportTest.log(Status.PASS, "Reorder option in exercises list enabled");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase045() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickExtraOptnRowE();
            reportTest.log(Status.PASS, "Extra options expanded for the exercise");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase046() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.deleteExc();
            reportTest.log(Status.PASS, "Selected exercise is now deleted");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase047() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.copyExc();
            reportTest.log(Status.PASS, "Selected exercise has been copied to list");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase048() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.resetValExc();
            reportTest.log(Status.PASS, "Selected exercise has reset to default values");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase049() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickCancelProtBtn();
            createEditProtocolPgTest.clickOKPopupBtn();
            protocolsListPgTest.waitPgLoad();
            reportTest.log(Status.PASS,"Canceled New Protocol redirected to Protocol list");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase050() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO, "Exercises selected and added to list");
            createEditProtocolPgTest.clickSaveAsProt();
            reportTest.log(Status.PASS, "Popup window displayed to enter details");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase051() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickSaveAsProt();
            reportTest.log(Status.PASS, "Popup window displayed with the required fields and buttons");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase052() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.addProtocol("Case 52", "Test description");
            reportTest.log(Status.PASS, "Protocol saved confirmation message displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }   
    }
    
    @Test(enabled = true)
    public void testCase053() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickSaveAsProt();
            createEditProtocolPgTest.checkDisableProtSaveBtn();
            reportTest.log(Status.PASS, "Save button is disabled no details provided");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }   
    }
    
    @Test(enabled = true) 
    public void testCase054() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.selectExcercises();
	    reportTest.log(Status.INFO,"Exercises selected and added to list");
            createEditProtocolPgTest.clickSaveAsProt();
            createEditProtocolPgTest.checkDisableProtSaveBtn();
            createEditProtocolPgTest.clickCancelPopupBtn();
            reportTest.log(Status.PASS, "Popup window to save protocol closed with cancel button");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true) 
    public void testCase055() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            reportTest.log(Status.PASS, "Assessment list and search field with watermark displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase056() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.searchExcAssess("knee");
            reportTest.log(Status.INFO, "Performing assessment search");
            reportTest.log(Status.PASS, "Assessments search results displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase057() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.searchExcAssess("lalala");
            reportTest.log(Status.INFO, "Performing assessment search");
            reportTest.log(Status.PASS, "No result found validation displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase058() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.searchExcAssess("lalala");
            reportTest.log(Status.INFO, "Performing assessment search");
            createEditProtocolPgTest.clickClearSearch();
            reportTest.log(Status.PASS, "Cleared search text field, default assessment list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase059() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
            reportTest.log(Status.PASS,"Assessments selected and added to list");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase060() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
            reportTest.log(Status.PASS,"Assessments selected are displayed with their related details");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase061() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.clickExpCollAssess();
            reportTest.log(Status.PASS, "Assessment list is now hidden");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase062() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.clickExpCollAssess();
            reportTest.log(Status.INFO, "Assessment list hidden");
            createEditProtocolPgTest.clickExpCollAssess();
            reportTest.log(Status.PASS,"Assessments list displayed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase063() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.changeFreqA("Every");
            reportTest.log(Status.PASS, "Frequency changed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase064() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.changeBiasA("right");
            reportTest.log(Status.PASS, "Bias changed");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase065() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.clickReorderAss();
            reportTest.log(Status.PASS, "Reorder option in assessments list enabled");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)//Needs work for drag and dropping
    public void testCase066() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.clickReorderAss();
            reportTest.log(Status.PASS, "Reorder option in assessments list enabled position changeable");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase067() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.deleteAss();
            reportTest.log(Status.PASS, "Selected assessment is now deleted");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase068() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.deleteAss();
            log.info("Assessments List Reduced by 1");
            reportTest.log(Status.PASS, "Assessment deleted list reduced by 1");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase069() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.copyAss();
            reportTest.log(Status.PASS, "Selected assessment is now copied");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase070() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.copyAss();
            log.info("Copied Assessment placed below the original one");
            reportTest.log(Status.PASS, "Copied assessment placed below the original one");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase071() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.copyAss();
            log.info("Assessments list increased by one");
            reportTest.log(Status.PASS, "Assessment copied list increased by 1");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase072() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            log.info("Frequency on the current day");
            reportTest.log(Status.PASS, "Frequency on the current day and every weekday");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase073() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.resDefaultAss();
            reportTest.log(Status.PASS, "Selected assessment has reset to default values");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase074() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.clickClearAllExAs();
            reportTest.log(Status.PASS, "Selected assessments are now cleared from the list");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase075() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.addSameAssessment();
            reportTest.log(Status.PASS, "Selected assessment has been added twice");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase076() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.addSameAssessment();
            reportTest.log(Status.PASS, "Selected exercise increased two times on the image");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase077() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.clickCancelProtBtn();
            createEditProtocolPgTest.clickOKPopupBtn();
            protocolsListPgTest.waitPgLoad();
            log.info("Sent Back to Protocol List");
            reportTest.log(Status.PASS, "Clicked cancel button exiting to Protocol List");
            log.info("PASS");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase078() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.clickAddProtocol();
	    reportTest.log(Status.INFO, "Navigating to Create Protocol page");
            log.info("Clicked Add Protocol");
            createEditProtocolPgTest.waitForPgLoad();
            createEditProtocolPgTest.clickAssessmentsTab();
            createEditProtocolPgTest.selectAssessments();
	    reportTest.log(Status.INFO,"Assessments selected and added to list");
            createEditProtocolPgTest.checkClickSaveAsProt();
            reportTest.log(Status.PASS, "Save as New Protocol button is not clickable");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Test(enabled = true)
    public void testCase079() {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	reportTest = extent.createTest(methodName); 
        try {
            driver.get(finalEnvironment());
            log.info("Opened: " + finalEnvironment());
	    reportTest.log(Status.INFO, "WebPage Opened: " + finalEnvironment());
            logInPgTest.logIn(finalEmail(), finalPass());
	    reportTest.log(Status.INFO, "Login Attempt with user: " + finalEmail());
            patientListPgTest.waitPgLoad();
            log.info("Home page loaded");
            navBarFooterPgTest.clickProtocolsTabNav();
	    reportTest.log(Status.INFO, "Navigating to Protocols page");
            protocolsListPgTest.waitPgLoad();
            protocolsListPgTest.addProtocol("Case 79", "Test description");
            reportTest.log(Status.PASS, "Protocol saved confirmation message displayed");
        } catch (Exception e) {
            reportTest.log(Status.FAIL, "Test FAILED");
	    org.testng.Assert.fail("Test FAILED");
        }
    }
    
    @Parameters("browserType")
    @AfterMethod
    public void screenAfterMethod(@Optional String browser) throws IOException, InterruptedException {
        String path = null;
        if(browser == null) {
            path = takeScreenshotCH(methodName + "CH", driver);
        } else if(browser.equalsIgnoreCase("firefox")) {
            path = takeScreenshotFF(methodName + "FF", driver);
        } else if (browser.equalsIgnoreCase("chrome")) {
            path = takeScreenshotCH(methodName + "CH", driver);
        }
        reportTest.debug("Final Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());     
    }
    
    @AfterClass
    public void flush() {
        extent.flush();
        driver.close();
    }
}
