package com.crm.step_definitions;

import com.crm.pages.LoginPage;
import com.crm.pages.ModuleVerificationPage;
import com.crm.utilities.BrowserUtils298;
import com.crm.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

public class ModuleVerificationStepDefinition {
    ModuleVerificationPage moduleVerificationPage = new ModuleVerificationPage();

    @Given("User is logged in as {string}")
    public void userIsLoggedInAs(String userType) {
        String username = null;
        String password = null;

        if (userType.equalsIgnoreCase("hr")) {
            username = ConfigurationReader.getProperty("hr_username");
            password = ConfigurationReader.getProperty("hr_password");
        } else if (userType.equalsIgnoreCase("help desk")) {
            username = ConfigurationReader.getProperty("help_desk_username");
            password = ConfigurationReader.getProperty("help_desk_password");
        } else if (userType.equalsIgnoreCase("marketing")) {
            username = ConfigurationReader.getProperty("marketing_username");
            password = ConfigurationReader.getProperty("marketing_password");
        }
        //send username and password and login
        new LoginPage().login(username, password);

    }


    @Then("User should see all the modules listed on the top menu of the page")
    public void userShouldSeeAllTheModulesListedOnTheTopMenuOfThePage(List<String>expectedModules) {

        List<String> actualModules = BrowserUtils298.getElementsText1(moduleVerificationPage.moduleTitles);

        Assert.assertEquals(expectedModules, actualModules);
        //Assert.assertTrue(actualModules.contains(expectedModules));
    }

    @When("User click to Company LinkPage")
    public void userClickToCompanyLinkPage() {
        moduleVerificationPage.companyLink.click();
    }
}

