package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.pages.AppreciationPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendingAppreciationStepDefs {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @Given("the user is on the appreciation form page under Active Stream")
    public void the_user_is_on_the_appreciation_form_page_under_active_stream() {

    activityStreamPage.moreTab.click();
    activityStreamPage.appreciationOption.click();

    }



    AppreciationPage appreciationPage = new AppreciationPage();
    @And("the user fills in Message content with a valid text {string}")
    public void theUserFillsInMessageContentWithAValidText(String message) {

        Driver.getDriver().switchTo().frame(appreciationPage.messageIframe);
        appreciationPage.messageBody.sendKeys(message + Keys.ENTER);
        Driver.getDriver().switchTo().parentFrame();

    }



    @And("the user adds at least one recipient {string}")
        public void theUserAddsAtLeastOneRecipient(String recipientEmail) {
        appreciationPage.addRecipient.click();
        appreciationPage.recipientInput.click();
        appreciationPage.recipientInput.sendKeys(recipientEmail+Keys.ENTER);

        }


    @And("the user clicks Send button")
        public void theUserClicksSendButton() {
        appreciationPage.sendButton.click();
        BrowserUtils.waitFor(4);
        }




    @Then("the appreciation message should be posted in the Activity Stream")
    public void theAppreciationMessageShouldBePostedInTheActivityStream() {
    WebElement topMessage = Driver.getDriver().findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner' and contains(text(), 'Thank you for everything')])[1]"));
    Assert.assertTrue("The expected appreciation message was not found at the top of the Activity Stream.", topMessage.isDisplayed());
        }


    @Then("the default delivery To should be {string}")
    public void theDefaultDeliveryToShouldBe(String expectedSetting) {

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appreciationPage.allEmployees));


        String actualSetting = appreciationPage.allEmployees.getText();
        System.out.println("actualSetting = " + actualSetting);

        // Verify that the actual text matches the expected setting ("All employees")
        Assert.assertEquals("The default delivery setting is incorrect.", expectedSetting, actualSetting);
    }

    @And("the user clicks the Cancel button")
    public void theUserClicksTheCancelButton() {
        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appreciationPage.cancelButton));


     // Click the Cancel button and wait for the page to reload
    appreciationPage.cancelButton.click();
    }

    @And("the user navigates back to the appreciation form")
    public void theUserNavigatesBackToTheAppreciationForm() {
        activityStreamPage.moreTab.click();
        activityStreamPage.appreciationOption.click();

    }




    @Then("the form fields should be cleared")
    public void theFormFieldsShouldBeCleared() {

        Driver.getDriver().switchTo().frame(appreciationPage.messageIframe);
        String messageContent = appreciationPage.messageBody.getText();
        Driver.getDriver().switchTo().parentFrame();
        // Assert that the message content is empty
        Assert.assertTrue("The message content field is not empty.", messageContent.trim().isEmpty());


        // Get the text from the "All employees" span
        String recipientText = appreciationPage.allEmployees.getText().trim();

        // Assert that the recipient field does not contain any recipients
        Assert.assertTrue("The recipient field is not empty.", recipientText.isEmpty() || recipientText.equals("Add more"));

    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String errorMessage) {

        String expectedErrorMessage = errorMessage;
        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        String actualErrorMessage = appreciationPage.errorMessageTitle.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals("The displayed error message is incorrect.", expectedErrorMessage, actualErrorMessage);
    }



    @And("the user removes the recipient")
    public void theUserRemovesTheRecipient() {

        appreciationPage.delButAllEmployes.click();

    }

    @Then("a warning {string} should be shown")
    public void aWarningShouldBeShown(String message) {

        String expectedErrorMessage = message;
        System.out.println("expectedErrorMessage = " + expectedErrorMessage);
        String actualErrorMessage = appreciationPage.recipientErrorMessage.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals("The displayed error message is incorrect.", expectedErrorMessage, actualErrorMessage);
    }
}
