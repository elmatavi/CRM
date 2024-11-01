package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.pages.LoginPage;
import com.crm.pages.PollPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Poll_stepDefinitions {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    PollPage pollPage = new PollPage();


    @When("user is on the poll page under  Activity stream page")
    public void user_is_on_the_poll_page_under_activity_stream_page() {
        activityStreamPage.pollBtn.click();
    }


    @Then("user sees to {string} by default")
    public void user_sees_to_by_default(String expectedText) {
        BrowserUtils.waitFor(2);
        String actualText = pollPage.allEmployess.getText();

        // verify that the actual text matches the expected text
        Assert.assertEquals(actualText, expectedText);


    }


//    @When("the user click to Add question button")
//    public void theUserClickToAddQuestionButton() {
//        BrowserUtils.waitFor(2);
//        pollPage.addQuestionBtn.click();
//    }

    @When("the user adds a question to the poll{string}")
    public void theUserAddsAQuestionToThePoll(String expectedQuestion) {

        BrowserUtils.waitForClickablility(pollPage.questionInput, 2);
        pollPage.questionInput.sendKeys(expectedQuestion);
        pollPage.questionInput.clear();


    }


    @Then("the user adds multiple answers {string} and {string}")
    public void theUserAddsMultipleAnswersAnd(String expectedFirst, String expectedSecond) {

        pollPage.firstAnswerInput.sendKeys(expectedFirst);
        pollPage.secondAnswerInput.sendKeys(expectedSecond);
    }


    @And("the user selects Allow multiple choice checkbox")
    public void theUserSelectsAllowMultipleChoiceCheckbox() {

        BrowserUtils.selectCheckBox(pollPage.multipleChoiceBtn, true);

    }


    @Then("the user create  {string}")
    public void theUserCreate(String expectedText) {
        Driver.getDriver().switchTo().frame(pollPage.messageIframe);
        pollPage.messageBody.sendKeys(expectedText);
        Driver.getDriver().switchTo().defaultContent();
    }

    @Then("the user click send")
    public void theUserClickSend() {
        BrowserUtils.sleep(1);
        pollPage.sendBtn.click();
    }


    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = pollPage.clearMessageTitle.getText();

        Assert.assertEquals("The displayed error message is.", actualErrorMessage, expectedErrorMessage);
    }


    @And("the user remove all employess default")
    public void theUserRemoveAllEmployessDefault() {
        pollPage.delBtnAllEmployees.click();
    }

    @Then("the recipient error message {string} should be displayed")
    public void theRecipientErrorMessageShouldBeDisplayed(String expectedReciptientMessage) {

        String actualReciptientMessage = pollPage.unselectRecipients.getText();

        Assert.assertEquals("The displayed error message is.", actualReciptientMessage, expectedReciptientMessage);

    }

    @Then("the user adds  answers {string}")
    public void theUserAddsAnswers(String firstAnswer) {
        pollPage.firstAnswerInput.sendKeys(firstAnswer);
    }

    @Then("the user sees error message is {string} should be displayed")
    public void theUserSeesErrorMessageIsShouldBeDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = pollPage.errorQuestion.getText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }


    @Then("the user adds  {string}")
    public void theUserAdds(String question0) {
        pollPage.questionInput.sendKeys(question0);
    }


    @Then("the user sees error message is {string}{string}{string}")
    public void theUserSeesErrorMessageIs(String arg0, String arg1, String arg2) {

        String expectedText = arg0 + "\"" +arg1+ "\"" + arg2;
        Assert.assertEquals(pollPage.errorAnswer.getText(), expectedText);
    }
}



















