package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DatePage extends Utility {
    public DatePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#lite_mode_9")
    WebElement dateIcon;

    @FindBy(xpath = "//td[normalize-space()='24']")
    WebElement date;

    @FindBy(xpath = "//div[@class='form-pagebreak-next-container']" +
            "//button[@id='form-pagebreak-next_10'][normalize-space()='Next']")
    WebElement datePageNextButton;
    @FindBy(css = "#form-pagebreak-next_10")
    WebElement clickOnNext;

    public void selectDate(String date) {
      /*  pmWaitUntilVisibilityOfElementLocated(By.xpath("//input[@class='form-textbox validate[limitDate, validateLiteDate] calendar-opened']"), 30).click();
        pmWaitUntilVisibilityOfElementLocated(By.xpath("//td[normalize-space()='24']"), 100).click();
        Reporter.log("Selecting the date : " + dateIcon.toString() + "<br>");*/
        sendTextToElement(dateIcon, date);


    }

    public void clickOnNext() {
        Reporter.log("Click on the next button on date page : " + clickOnNext.toString() + "<br>");
        pmClickOnElement(clickOnNext);
    }


}


