package com.crm.step_definitions;

import com.crm.pages.LoginPage;
import com.crm.pages.LoginPage_Marta;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class Login_Marta_StepDefs {

    private static final Logger log = LoggerFactory.getLogger(Login_Marta_StepDefs.class);
    LoginPage_Marta loginMarta = new LoginPage_Marta();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    LoginPage login = new LoginPage();

    private static final String passwordType = "password";

    //work with system clipboard (copy/past)
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

/*
l
 */
     @When("user enter invalid {string} and {string}")

    public void userEnterInvalidAnd(String username, String password) {
        login.userName.sendKeys(username);
        login.password.sendKeys(password);
    }

    @When("user click on Login Button")
    public void user_click_on_login_button() {
         login.submit.click();
    }

    @Then("user see {string} error message")
    public void user_see_error_message(String expectedErrorMessage) {

        String actualErrorMessage = loginMarta.loginErrorMessage.getText();

        Assert.assertEquals("Actual Error Message are NOT equals with Expected:\nActual: "
                                    + actualErrorMessage + "Expected: " + expectedErrorMessage ,
                                    expectedErrorMessage, actualErrorMessage);

    }


    //Scenario
    @Given("user see Remember me on this computer text")
    public void user_see_text() {

        Assert.assertTrue(loginMarta.rememberMeText.isDisplayed());

    }

    @When("user select  Remember me on this computer checkbox")
    public void user_select_remember_me_on_this_computer_checkbox() {
        loginMarta.rememberMeCheckbox.click();
    }

    @Then("checkbox should be clickable")
    public void checkbox_should_be_clickable() {
        Assert.assertTrue(loginMarta.rememberMeCheckbox.isSelected());
    }

    //Scenario

    @When("user enter {string}")
    public void user_enter(String password) {
        login.password.sendKeys(password);
    }

    @Then("password field should display bullet signs by default")
    public void password_field_should_display_bullet_signs_by_default() {

        String typeAttribute = loginMarta.passwordFieldByType.getAttribute("type");

        Assert.assertEquals(
        "Password type not as expected:\nActual: " + typeAttribute + "\nExpected: " + passwordType,
                 passwordType, typeAttribute);

        }


    @When("user enter {string} as the username")
    public void user_enter_as_the_username(String username) {
       login.userName.sendKeys(username);
    }


    @When("user enter {string} as the password")
    public void user_enter_as_the_password(String password) {
       login.password.sendKeys(password);
    }


    @When("user click the login button")
    public void user_click_the_login_button() {
           login.submit.click();
    }



    @When("user copies the password text")
    public void user_copies_the_password_text() {
        login.password.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text in the password field

        // Retrieve the selected text
        String selectedText = login.password.getAttribute("value");

        // Set the selected text to the system clipboard
        StringSelection selection = new StringSelection(selectedText);

        clipboard.setContents(selection, null);


    }

    @When("user clear password field")
    public void user_clear_password_field() {

        login.password.clear();

    }

    @When("user pastes the copied text into the password field")
    public void user_pastes_the_copied_text_into_the_password_field() throws IOException, UnsupportedFlavorException {
       // Get text from the system clipboard
        String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);

        login.password.sendKeys(clipboardText);

    }

    @Then("password field should contain {string}")
    public void password_field_should_contain(String expectedPassword) {

        String actualPassword = login.password.getAttribute("value");
        Assert.assertEquals("Expected Password not equal to Actual password:\nExpected: " + expectedPassword + "\nActual: " + actualPassword
                                     ,expectedPassword, actualPassword);

    }


    @When("user enter {string} username and {string} password")
    public void user_enter_username_and_password(String username, String password) {
       login.userName.sendKeys(username);
       login.password.sendKeys(password);
    }


    @Then("user see title {string}")
    public void user_see_title(String expectedTitle) {
        BrowserUtils.verifyTitleContains(expectedTitle);
    }



}
