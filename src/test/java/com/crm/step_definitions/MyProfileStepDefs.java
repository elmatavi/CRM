package com.crm.step_definitions;

import com.crm.pages.BasePage;
import com.crm.pages.LoginPage;
import com.crm.pages.MyProfilePage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class MyProfileStepDefs {
    MyProfilePage myProfilePage = new MyProfilePage();


    @Given("the user is already logged into crm application")
    public void theUserIsAlreadyLoggedIntoCrmApplication() {
       // Driver.getDriver().get("https://qa.ctissolutions.com/");
    }

    /*@Then("user navigates to home page")
    public void userNavigatesToHomePage() {
        String expectedTitle = "Portal";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"The Title Verification is FAILED!");

    } */

    @And("user clicks on the username")
    public void userClicksOnTheUsername() {

        myProfilePage.userName.click();
         BrowserUtils.sleep(2);

    }

    @Then("user clicks on the My Profile dropdown")
    public void userClicksOnTheMyProfileDropdown() {
        myProfilePage.myProfileDropdown.click();



    }




    @And("user should see the following options")
    public void userShouldSeeTheFollowingOptions(List<String> expectedOptions) {

        List<String> actualOptions = BrowserUtils.getElementsText(myProfilePage.profileMenuItems);

        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Then("user should see the email under the General tab")
    public void userShouldSeeTheEmailUnderTheGeneralTab() {
        String actual=myProfilePage.emailAddress.getText();
        String expected = "helpdesk1@cydeo.com";
        Assert.assertEquals(actual,expected);


    }

    @And("user should see the following options")
    public void userShouldSeeTheFollowingOptions() {
    }
}
