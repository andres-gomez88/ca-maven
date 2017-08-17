/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import pageObjects.LogInPg;
import pageObjects.ResetpwLogInPg;
import pageObjects.NavBarFooterPg;
import pageObjects.PatientListPg;
import pageObjects.ProtocolsListPg;
import pageObjects.CliniciansListPg;
import pageObjects.AddPatientPg;
import pageObjects.ChangePwPg;
import pageObjects.ExercisePlanPg;
import pageObjects.TestSurveysPg;
import pageObjects.ReportsPg;
import pageObjects.ProfilePg;
import pageObjects.SupportPg;
import pageObjects.CreateEditProgramPg;
import pageObjects.CreateEditProtocolPg;
import static Utilities.WaitUtilities.*;
/**
 *
 * @author Admin
 */
public class testPgObj {
    static WebDriver driver;
    
    static LogInPg logInPgTest;
    static ResetpwLogInPg resetpwLogInPgTest;
    static NavBarFooterPg navBarFooterPgTest;
    static PatientListPg patientListPgTest; 
    static ProtocolsListPg protocolsListPgTest;
    static CliniciansListPg cliniciansListPgTest;
    static AddPatientPg addPatientPgTest;
    static ChangePwPg changePwPgTest;
    static ExercisePlanPg exercisePlanPgTest;
    static TestSurveysPg testSurveysPgTest;
    static ReportsPg reportsPgTest;
    static ProfilePg profilePgTest;
    static SupportPg supportPgTest;
    static CreateEditProgramPg createEditProgramPgTest;
    static CreateEditProtocolPg createEditProtocolPgTest;
    
    public static void main(String[] args) throws InterruptedException {
        String prever = "https://prerelease-wc.prod.reflexionhealth.com";
        String testver = "https://test-wc.test.reflexionhealth.com";
        String exePath = "C:\\seleniumdriver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exePath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(testver);
        
        logInPgTest = new LogInPg(driver);
        resetpwLogInPgTest = new ResetpwLogInPg(driver);
        navBarFooterPgTest = new NavBarFooterPg(driver);
        patientListPgTest = new PatientListPg(driver);
        protocolsListPgTest =  new ProtocolsListPg(driver);
        cliniciansListPgTest = new CliniciansListPg(driver);
        addPatientPgTest = new AddPatientPg(driver);
        changePwPgTest = new ChangePwPg(driver);
        exercisePlanPgTest =  new ExercisePlanPg(driver);
        testSurveysPgTest = new TestSurveysPg(driver);
        reportsPgTest = new ReportsPg(driver);
        profilePgTest = new ProfilePg(driver);
        supportPgTest = new SupportPg(driver);
        createEditProgramPgTest = new CreateEditProgramPg(driver);
        createEditProtocolPgTest = new CreateEditProtocolPg(driver);
        
        logInPgTest.logIn("andres.gomez@reflexionhealth.com", "Reflexion1");
        //logInPgTest.rememberMeChkBox.click();
        //logInPgTest.resetpwLink.click();
        //logInPgTest.userguideLink.click();
        //resetpwLogInPgTest.sendResetLink("andres.gomez@reflexionhealth.com");
        //patientListPgTest.searchNavBar.click();
        //patientListPgTest.searchTxtBoxNavBar.sendKeys("Test");
        //patientListPgTest.patientsNavBar.click();
        waitForVisibility(patientListPgTest.patientLinkRow, 5, driver);
        //(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(patientListPgTest.patientLinkRow));
        //patientListPgTest.clearSearchBtn.click();
        //navBarFooterPgTest.protocolsNavBar.click();
        //(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(patientListPgTest.clearSearchBtn));
        //patientListPgTest.cliniciansNavBar.click();
        //patientListPgTest.protocolsNavBar.click();
        //protocolsListPgTest.addProtocol.click();
        patientListPgTest.patientLinkRow.click();
        exercisePlanPgTest.testSurvNav.click();
        testSurveysPgTest.reportsNav.click();
        reportsPgTest.managePatDropDown.click();
        reportsPgTest.dischrgPatDropDown.click();
        reportsPgTest.cancelDischBtn.click();
        /*
        protocolsListPgTest.addProtocol.click();
        waitForVisibility(createEditProtocolPgTest.e01Bal3WayStarGrid, driver);
        for(int i =0; i <2; i++) {
        createEditProtocolPgTest.bodyAreaFltrDrop.click();
        waitForVisibility(createEditProtocolPgTest.lumbarBdyFltr, driver);
        createEditProtocolPgTest.lumbarBdyFltr.click();
        createEditProtocolPgTest.movTypeFltrDrop.click();
        waitForVisibility(createEditProtocolPgTest.adlMovFltr, driver);
        createEditProtocolPgTest.adlMovFltr.click();
        createEditProtocolPgTest.modifiersFltrDrop.click();
        waitForVisibility(createEditProtocolPgTest.openChainModFltr, driver);
        createEditProtocolPgTest.openChainModFltr.click();
        createEditProtocolPgTest.equipTypeFltrDrop.click();
        waitForVisibility(createEditProtocolPgTest.ballEquipFltr, driver);
        createEditProtocolPgTest.ballEquipFltr.click();
        }
        
        
        
        //createEditProgramPgTest.expandInfo.click();
        //createEditProgramPgTest.expandInfo.click();
        createEditProtocolPgTest.e45SingleLegBal.click();
        createEditProtocolPgTest.e08DeepLunge.click();
        createEditProtocolPgTest.assessmentsTab.click();
        createEditProtocolPgTest.a02SingleLegBalTest.click();
        createEditProtocolPgTest.expColExcercises.click();
        createEditProtocolPgTest.excDesLinkRowE.click();
        createEditProtocolPgTest.okBtn.click();
        createEditProtocolPgTest.srChkBoxRowE.click();
        createEditProtocolPgTest.biasClickDrpRowE.click();
        createEditProtocolPgTest.biasTxtBoxRowE.sendKeys("right", Keys.ENTER);
        createEditProtocolPgTest.setsClickDrpRowE.click();
        createEditProtocolPgTest.setsTxtBoxRowE.sendKeys("2", Keys.ENTER);
        createEditProtocolPgTest.repsClickDrpRowE.click();
        createEditProtocolPgTest.repsTxtBoxRowE.sendKeys("15", Keys.ENTER);
        createEditProtocolPgTest.xDayClickDrpRowE.click();
        createEditProtocolPgTest.xDayTxtBoxRowE.sendKeys("8", Keys.ENTER);
        createEditProtocolPgTest.freqClickDrpRowE.click();
        createEditProtocolPgTest.freqTxtBoxRowE.sendKeys("every other", Keys.ENTER);
        createEditProtocolPgTest.editOptLinkRowE.click();
        createEditProtocolPgTest.equipClickDrpRowE.click();
        createEditProtocolPgTest.equipTxtBoxRowE.sendKeys("no", Keys.ENTER);
        createEditProtocolPgTest.holdPosClickDrpRowE.click();
        createEditProtocolPgTest.holdPosTxtBoxRowE.sendKeys("50", Keys.ENTER);
        createEditProtocolPgTest.restRepClickDrpRowE.click();
        createEditProtocolPgTest.restRepTxtBoxRowE.sendKeys("60", Keys.ENTER);
        createEditProtocolPgTest.restSetClickDrpRowE.click();
        createEditProtocolPgTest.restSetTxtBoxRowE.sendKeys("60", Keys.ENTER);
        createEditProtocolPgTest.extraOptRowE.click();
        createEditProtocolPgTest.copyExtraOptnRowE.click();
        createEditProtocolPgTest.expColAssessmnt.click();
        createEditProtocolPgTest.expColAssessmnt.click();
        //createEditProtocolPgTest.startDateTxtBoxRowA.clear();
        //createEditProtocolPgTest.startDateTxtBoxRowA.sendKeys("02/15/17");
        createEditProtocolPgTest.freqClickDrpRowA.click();
        createEditProtocolPgTest.freqTxtBoxRowA.sendKeys("every", Keys.ENTER);
        createEditProtocolPgTest.biasClickDrpRowA.click();
        createEditProtocolPgTest.biasTxtBoxRowA.sendKeys("Righ", Keys.ENTER);
        createEditProtocolPgTest.extraOptRowA.click();
        createEditProtocolPgTest.resetExtraOptnRowA.click();
        //createEditProtocolPgTest.applyPrgmBtn.click();
        //createEditProtocolPgTest.contApplyBtn.click();
        //createEditProtocolPgTest.updateProtBtn.click();
        createEditProtocolPgTest.saveAsProtBtn.click();
        createEditProtocolPgTest.protNameSaveTxtBox.sendKeys("A prot3");
        createEditProtocolPgTest.protDescSaveTxtBox.sendKeys("A Desc3");
        createEditProtocolPgTest.saveProtSaveBtn.click();
        */
    }   
    
}
