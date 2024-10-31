package com.crm.step_definitions;


import com.crm.pages.LoginPage;
import com.crm.pages.access_Employees;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
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

public class Employees_step_defs {

    access_Employees accessEmployees = new access_Employees();

    @When("the user navigates to the Employees page")
    public void the_user_navigates_to_the_employees_page() {
        accessEmployees.employeesLink.click();

        // Wait until the Employees page is fully loaded
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(accessEmployees.employeesLink)
        );


    }



    @Then("the following modules should be visible")
    public void the_following_modules_should_be_visible(List<String> modules) {

        // Get the text of all visible modules on the Employees page
        List<String> actualModules = BrowserUtils.getElementsText(accessEmployees.employeesModule);

        // Compare each expected module to ensure it's present in the actual list
        for (String module : modules) {

            Assert.assertTrue("Module " + module + " is not visible", actualModules.contains(module));
        }

    }




}
