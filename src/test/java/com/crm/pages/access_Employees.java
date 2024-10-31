package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class access_Employees  {

    public access_Employees(){
        // Implement the constructor here
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space(text())='Employees']")
    public WebElement employeesLink;

    @FindBy(xpath="//div[@id='top_menu_id_company']")
    public List<WebElement> employeesModule;


}
