package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeesPage_sadaf {

    public EmployeesPage_sadaf() {


        // Constructor to initialize elements
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public static void navigateToEmployeesPage() {
        employeesPageLink.click();
    }

    // Define the WebElements for each module using @FindBy
    @FindBy(xpath = "//div[contains(text(),'Company Structure')]")
    public static WebElement companyStructure;

    @FindBy(xpath = "//div[contains(text(),'Find Employee')]")
    public static WebElement findEmployee;

    @FindBy(xpath = "//div[contains(text(),'Telephone Directory')]")
    public static WebElement telephoneDirectory;

    @FindBy(xpath = "//div[contains(text(),'Staff Changes')]")
    public static WebElement staffChanges;

    @FindBy(xpath = "//div[contains(text(),'Efficiency Report')]")
    public static WebElement efficiencyReport;

    @FindBy(xpath = "//div[contains(text(),'Honored Employees')]")
    public static WebElement honoredEmployees;

    @FindBy(xpath = "//div[contains(text(),'Birthdays')]")
    public static WebElement birthdays;

    @FindBy(xpath = "//div[contains(text(),'New page')]")
    public static WebElement newPage;

    @FindBy(xpath = "span[@class='menu-item-link-text']")  // Assuming all modules share a common class
    public List<WebElement> allModules;

    @FindBy(xpath = "span[@class='menu-item-link-text' and normalize-space(text())='Employees']")
    public static WebElement employeesPageLink;




    // Actions for verifying module visibility
    public static boolean isModuleVisible(String moduleName) {
        switch (moduleName) {
            case "Company Structure":
                return companyStructure.isDisplayed();
            case "Find Employee":
                return findEmployee.isDisplayed();
            case "Telephone Directory":
                return telephoneDirectory.isDisplayed();
            case "Staff Changes":
                return staffChanges.isDisplayed();
            case "Efficiency Report":
                return efficiencyReport.isDisplayed();
            case "Honored Employees":
                return honoredEmployees.isDisplayed();
            case "Birthdays":
                return birthdays.isDisplayed();
            case "New page":
                return newPage.isDisplayed();
            default:
                return false;
        }


    }
    // Verify default view as "Company Structure"
    public static boolean isCompanyStructureDisplayedByDefault() {
        return companyStructure.isDisplayed();
    }

    // Method to count all visible modules on the page
    public int getVisibleModuleCount() {
        return allModules.size();
    }
}