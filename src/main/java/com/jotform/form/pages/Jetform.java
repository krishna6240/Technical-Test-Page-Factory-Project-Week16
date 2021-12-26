package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import freemarker.template.utility.DateUtil;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Jetform extends Utility {
    public Jetform() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='jfCard-welcome-start']")
    WebElement nextbtn;
    @CacheLookup
    @FindBy(css = "#first_3")
    WebElement firstname;
    @CacheLookup
    @FindBy(css = "#last_3")
    WebElement lastname;
    @CacheLookup
    @FindBy(css = "#form-pagebreak-next_5")
    WebElement nextbutton;
    @CacheLookup
    @FindBy(css = "#input_6")
    WebElement downloadfile;
    @CacheLookup
    @FindBy(css = "#form-pagebreak-next_4")
    WebElement nxtbtn;
    @CacheLookup
    @FindBy(xpath = "//canvas[@aria-label='E-Signature Field']")
    WebElement signature;
    @CacheLookup
    @FindBy(css = "#form-pagebreak-next_8")
    WebElement clicksingbtn;
    @CacheLookup
    @FindBy(id = "lite_mode_10")
    WebElement selectdate;
    @CacheLookup
    @FindBy(css = "#form-pagebreak-next_13")
    WebElement clicknext;
    @CacheLookup
    @FindBy(css = "#form-pagebreak-next_14")
    WebElement lastNextbtn;
    @CacheLookup
    @FindBy(css = ".jfDropdown-chipContainer")
    WebElement selectdropdown;
    @FindBy(xpath = "//li[normalize-space()='Name of the first pet']")
    WebElement selectPet;
    @CacheLookup
    @FindBy(xpath = "//input[@id='input_11_field_2']")
    WebElement petname;
    @CacheLookup
    @FindBy(id = "input_2")
    WebElement submit;


    public void clickNextBtn() {
        clickOnElement(nextbtn);
    }

    public void inputfirsname(String name) {
        sendTextToElement(firstname, name);
    }

    public void inputlastname(String name) {
        sendTextToElement(lastname, name);
    }

    public void clickonNextButton() {
        clickOnElement(nextbutton);
    }

    public void clickOnDownLoadFile(String file) {
        sendTextToElement(downloadfile, file);
    }
    public void ClickOnNextBtn(){
        clickOnElement(clicknext);
    }

    public void clickOnnxtbtn() {
        clickOnElement(nxtbtn);
    }

    @FindBy(xpath = "//canvas[@aria-label='E-Signature Field']")
    WebElement canvasElement;

    @FindBy(xpath = "//div[@data-type='control_signature']" +
            "//button[@aria-label='Next'][normalize-space()='Next']")
    WebElement signaturePageNextButton;

    @FindBy(css = "#form-pagebreak-next_8")
    WebElement signatureLabel;
    @FindBy(xpath = "//p[@class='thankyou-sub-text ty-text']")
    WebElement verificationText;

    public void writeOnsignature() throws InterruptedException {
        Actions builder = new Actions(driver);

        Thread.sleep(2000);

        Action signature = builder.moveToElement(canvasElement)
                .clickAndHold()
                .moveToElement(canvasElement, 20, -50)
                .moveByOffset(50, 50)
                .moveByOffset(80, -50)
                .moveByOffset(100, 50)
                .release(canvasElement)
                .build();
        signature.perform();

        Thread.sleep(10000);

        pmClickOnElement(signatureLabel);
    }


    public void clickOnSignBtn() {
        clickOnElement(clicksingbtn);
    }


    public void Date(String date) {
        sendTextToElement(selectdate, date);
    }

    public void clickOnNext() {
        Reporter.log("Click on the Next Button on signature page : " + signaturePageNextButton.toString() + "<br>");
        clickOnElement(signaturePageNextButton);
    }

    public void selectOnDropDown() {
        clickOnElement(selectdropdown);
    }

    public void selectPetName() {
        clickOnElement(selectPet);
    }

    public void selectPet(String name) {
        sendTextToElement(petname, name);
    }

    public void clickOnSubmitBtn() {
        clickOnElement(submit);
    }
    public void clickOnLastNextBtn(){
        clickOnElement(lastNextbtn);
    }


    public void verifyThatSubmissionHasBeenReceived(String expectedMessage) {
        Reporter.log("Verifying the submission message: " + verificationText.toString() + "<br>");
        String actualMessage = pmGetTextFromElement(verificationText);
        pmVerifyElements(expectedMessage, actualMessage, "Incorrect submission");
    }
}
