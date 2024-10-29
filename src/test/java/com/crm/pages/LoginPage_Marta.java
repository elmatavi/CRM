package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Marta {

    public LoginPage_Marta(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//input[@id='USER_REMEMBER']")
    public WebElement rememberMeCheckbox;

    @FindBy(xpath = "//label[contains(text(), 'Remember me')]") // Replace with actual XPath or locator for the text/link
    public WebElement rememberMeText;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordFieldByType;




}
