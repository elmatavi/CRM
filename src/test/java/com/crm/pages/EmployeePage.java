package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {


    public EmployeePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//a[@href='/company/vis_structure.php']")
    public WebElement companyStructureButton;


    @FindBy(id="pagetitle")
    public WebElement companyStructureTitle;

   @FindBy(xpath="//a[@class='webform-small-button webform-small-button-blue webform-small-button-add']")
   public WebElement addDepartment;

    @FindBy(id="popup-window-titlebar-BXStructure")
   public WebElement popup;


}
