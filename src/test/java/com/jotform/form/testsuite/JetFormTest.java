package com.jotform.form.testsuite;

import com.jotform.form.pages.DatePage;
import com.jotform.form.pages.Jetform;
import com.jotform.form.pages.SecurityPage;
import com.jotform.form.testbase.TestBase;
import com.jotform.form.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JetFormTest extends TestBase {
    SecurityPage securityPage;
    DatePage datePage;
    Jetform jetform;
    SoftAssert softAssert;
    String timeStamp;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inTt() {
        securityPage = new SecurityPage();
        datePage = new DatePage();
        jetform = new Jetform();
        softAssert = new SoftAssert();
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    @Test(groups = {"sanity", "regression"})

    @Parameters({"securityQuestion", "securityAnswer", "expectedMessage"})
    public void verifyThatUserShouldTestSucessfully(String sq,String sa,String em) throws InterruptedException {

     // jetform.clickNextBtn();
      jetform.inputfirsname("krishna");
      jetform.inputlastname("patel");
      jetform.clickonNextButton();
      jetform.clickOnDownLoadFile("C:\\Users\\Krishna\\Desktop\\JetForm.txt");
      jetform.clickOnnxtbtn();
      Thread.sleep(1000);
      jetform.writeOnsignature();
     //jetform.clickOnSignBtn();
      datePage.selectDate("01-01-2022");
      datePage.clickOnNext();
      securityPage.selectFromDropDown(sq);
      securityPage.enterSecurityAnswer(sa);
      jetform.ClickOnNextBtn();
      jetform.clickOnLastNextBtn();
      jetform.clickOnSubmitBtn();
      jetform.verifyThatSubmissionHasBeenReceived(em);



    }
}