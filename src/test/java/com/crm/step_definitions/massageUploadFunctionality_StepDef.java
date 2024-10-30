package com.crm.step_definitions;

import com.crm.pages.MessagePage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v118.browser.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class massageUploadFunctionality_StepDef {

   WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

   MessagePage messagePage = new MessagePage();


    @And("user click on {string} input field")
    public void userClickOnInputField(String messageInputField) {
        messagePage.sendMessageInput.click();
    }


    @When("user uploads a file named  {string}")
    public void user_uploads_a_file_named(String fileName) {
         // Use the utility method to get the full path of the file
        String filePath = BrowserUtils.getFileFullPath(fileName);

        messagePage.uploadFileIcon.click();
        messagePage.fileAndImageUploadSection.sendKeys(filePath);

         // Wait until the file appears as an attachment
         BrowserUtils.sleep(3);


    }

    @Then("the file {string} should be successfully attached to the message")
    public void theFileShouldBeSuccessfullyAttachedToTheMessage(String fileName) {

        WebElement uplodedFile = Driver.getDriver().findElement(By.xpath("//div[@class='diskuf-placeholder']//table//tbody[@class='diskuf-placeholder-tbody']/tr"));

        wait.until(ExpectedConditions.visibilityOf(uplodedFile));

        Assert.assertTrue(uplodedFile.isDisplayed());

    }



    @And("user click insert in text button")
    public void userClickInsertInTextButton() {

        wait.until(ExpectedConditions.elementToBeClickable( Driver.getDriver().findElement(By.xpath("//span[@class='insert-btn-text']"))));
        WebElement insertInTextButton = Driver.getDriver().findElement(By.xpath("//span[@class='insert-btn-text']"));

        BrowserUtils.sleep(3);
        for (int i = 0; i < 3; i++) {

            try {
                insertInTextButton.click();
                break;
            } catch (StaleElementReferenceException e) {
                insertInTextButton = Driver.getDriver().findElement(By.xpath("//span[@class='insert-btn-text']"));
                insertInTextButton.click();
            }
        }

    }





    @Then("file {string} should be successfully attached to the message text area")
    public void fileShouldBeSuccessfullyAttachedToTheMessageTextArea(String fileName) {


        int extensionIndex = fileName.indexOf('.');
        String baseFileName = fileName.substring(0, extensionIndex);


        //wait to iframe to be present and switch to it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@class='bx-editor-iframe']")));

        Driver.getDriver().switchTo().frame(messagePage.iframeMessageField);

        if(fileName.contains(".png") || fileName.contains("jpg")){

        //Xpath for image in text area   //body[@contenteditable='true']//img[contains(@src, '" + fileName + "')]
        WebElement imageInTextArea = Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']//img[contains(@src, '" + baseFileName + "')]"));

        wait.until(ExpectedConditions.visibilityOf(imageInTextArea));

        Assert.assertTrue(imageInTextArea.isDisplayed());

        } else if (fileName.contains(".txt") || fileName.contains(".pdf") || fileName.contains(".docx")) {
            WebElement txtTextArea = Driver.getDriver().findElement(By.xpath("//body[@contenteditable='true']//span[contains(text(), '" + baseFileName +"')]"));

            wait.until(ExpectedConditions.visibilityOf(txtTextArea));

            Assert.assertTrue(txtTextArea.isDisplayed());
        }

    }


    @Then("user remove file by clicking on Remove Icon")
    public void userRemoveFileByClickingOnRemoveIcon() {
        messagePage.removeIcon.click();
    }


    @And("user click Send Button")
    public void userClickSendButton() {

        messagePage.sendButton.click();
    }


    @Then("user see file in Activity Stream")
    public void userSeeFileInActivityStream() {

        WebElement activeStreamFileLocator = Driver.getDriver().findElement(By.xpath("//div[@id='log_internal_container']//div[@class='feed-wrap']/div//img[contains(@id,'disk-attach-image')]"));

        wait.until(ExpectedConditions.visibilityOf(activeStreamFileLocator));
        Assert.assertTrue(activeStreamFileLocator.isDisplayed());
    }



}
