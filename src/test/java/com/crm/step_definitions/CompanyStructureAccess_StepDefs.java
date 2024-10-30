package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.pages.EmployeePage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class CompanyStructureAccess_StepDefs {

    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    EmployeePage employeePage = new EmployeePage();

    @When("user navigate to the Company Structure section under the Employee menu")
    public void userNavigateToTheCompanyStructureSectionUnderTheEmployeeMenu() {
        activityStreamPage.Employee.click();
        employeePage.companyStructureButton.click();
        BrowserUtils.waitFor(2);

    }



    @Then("the {string} is should be visible")
    public void the_is_should_be_visible(String expectedTitle) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeePage.companyStructureTitle));

        String actualTitle = Driver.getDriver().getTitle();
        // Allow partial matches
       assertTrue("Expected title not found!", actualTitle.contains(expectedTitle));

    }


    @And("user click the ADD DEPARTMENT button")
    public void userClickTheADDDEPARTMENTButton() {

    employeePage.addDepartment.click();

    }

    @Then("the {string} window is displayed")
    public void theWindowIsDisplayed(String expectedWindowTitle) {
    Assert.assertTrue("The popup window is not displayed", employeePage.popup.isDisplayed());

    }

    @Then("the ADD DEPARTMENT button should not be displayed")
    public void theADDDEPARTMENTButtonShouldNotBeDisplayed() {
        try {
            // Assert that the "ADD DEPARTMENT" button is not displayed
            Assert.assertFalse("The ADD DEPARTMENT button should not be displayed", employeePage.addDepartment.isDisplayed());
        } catch (NoSuchElementException e) {
            // If the element is not found in the DOM, treat it as not displayed
            Assert.assertTrue("The ADD DEPARTMENT button is not present in the DOM, which is expected.", true);
        }

    }
}
