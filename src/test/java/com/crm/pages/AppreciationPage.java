package com.crm.pages;

import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppreciationPage {


    public AppreciationPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    // Locator for the iframe
    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageIframe;

    @FindBy(xpath= "//body[@contenteditable='true']")
    public WebElement messageBody;

    @FindBy(id= "bx-grat-tag")
    public WebElement addRecipient;

    @FindBy(id= "feed-add-post-grat-input")
    public WebElement recipientInput;


    @FindBy(id= "blog-submit-button-save")
    public WebElement sendButton;



    // Locate the "All employees" span element
    @FindBy(xpath= "//span[.='All employees']")
    public WebElement allEmployees;


    @FindBy(xpath= "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//span[.='The message title is not specified']")
    public WebElement errorMessageTitle;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement delButAllEmployes;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement recipientErrorMessage;


    }


