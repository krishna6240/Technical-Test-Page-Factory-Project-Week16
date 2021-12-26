package com.jotform.form.pages;

import com.jotform.form.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SecurityPage extends Utility {
    public SecurityPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "input_11")
    WebElement questionDropDown;

    @FindBy (id = "input_12")
    WebElement answerField;

    @FindBy(id = "form-pagebreak-next_13")
    WebElement submitButton;

    public void selectFromDropDown(String question){
        Reporter.log("Selecting from question dropdown : " + question + "<br>");
        pmSelectByVisibleTextFromDropDown(questionDropDown, question );
    }

    public void enterSecurityAnswer(String answer){
        Reporter.log("Entering the security answer : " + answer + "<br>");
        pmSendTextToElement(answerField, answer);
    }

    public void clickOnSubmitButton(){
        Reporter.log("Click on the Submit button : " + submitButton.toString() + "<br>");
        pmClickOnElement(submitButton);
    }


}

