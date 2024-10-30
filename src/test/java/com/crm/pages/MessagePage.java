package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePage {

    public MessagePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='microoPostFormLHE_blogPostForm_inner']")
    public WebElement sendMessageInput;

    @FindBy(xpath = "//span[.='Message']/span")
    public WebElement messageTab;


    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFileIcon;


    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement fileAndImageUploadSection;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelButton;

     //td[@class='files-info']
     //span[@class='insert-btn-text']
     //span[@class='insert-btn-text']
     @FindBy(xpath = "//td[@class='files-info']")
     public WebElement insertInTextButton;


     //new locator:  //div[@class='bxhtmled-area-cnt']/div//iframe
     //iframe[@class='bx-editor-iframe']
     //bx-editor-iframe
     //iframe[@class='bx-editor-iframe']
     //div[@id='bx-html-editor-iframe-cnt-idPostFormLHE_blogPostForm']/iframe
     @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
     public WebElement iframeMessageField;

      @FindBy(xpath = "//div[@class='bxhtmled-area-cnt']/div//iframe")
      public WebElement uploadFileAndImages;


      @FindBy(xpath = "//div[@class='diskuf-placeholder']//table//tbody[@class='diskuf-placeholder-tbody']//td[@class='files-del-btn']/span")
      public WebElement removeIcon;


      @FindBy(xpath = "//span[@title='Link']")
      public WebElement linkIcon;


      @FindBy(xpath = "//div[@id='bx-admin-prefix']")
      public WebElement linkWindow;


      @FindBy(xpath = "//td[@class='bxhtmled-right-c']//input[@id='linkidPostFormLHE_blogPostForm-text']")
      public WebElement linkTextInput;

      @FindBy(xpath = "//td[@class='bxhtmled-right-c']//input[@id='linkidPostFormLHE_blogPostForm-href']")
      public WebElement link_Url_Input;

      //div[@class='bx-core-adm-dialog-buttons']//input[@value='Save']
      @FindBy(xpath = "//div[@class='bx-core-adm-dialog-buttons']//input[@value='Save']")
      public WebElement link_window_saveButton;


     /*
     This method waits until the uploaded file appears as an attachment and returns the WebElement.
      */
     public WebElement getUploadedFileElement(String fileName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(), '" + fileName + "')]")
        ));
    }



    //check
    //check







}
