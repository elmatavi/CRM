package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CRM_HomePage {

    public CRM_HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    //Locating Elements and storing into List<WebElement>
    @FindBy(xpath = "//div[@class='feed-add-post-form-variants']/span")
    public List<WebElement> listOfElements;

    //Locating "MORE" link to be able to click on it
    @FindBy(xpath = "//span[@id='feed-add-post-form-link-text']")
    public WebElement moreLink;

    //Locating options in the "MORE" link and storing them into List<WebElement>
    @FindBy(xpath = "//div[@class='menu-popup-items']/span")
    public List<WebElement> listOfMoreLinks;

    @FindBy(xpath = "//span[normalize-space(text())='Employees']")
    public WebElement employeesLink;
}
