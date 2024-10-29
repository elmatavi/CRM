package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProfilePage extends BasePage {

    public MyProfilePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//title[.='Portal']")
    public WebElement homePage;

    @FindBy(xpath="//div[@id='user-block']")
    public WebElement userName;

    @FindBy(xpath="//div[@id='menu-popup-user-menu']//a[1]")
    public WebElement myProfileDropdown;

    @FindBy (linkText="helpdesk1@cydeo.com")
    public WebElement emailAddress;

    @FindBy(xpath="//div[@id='profile-menu-filter']/a")
    public List<WebElement> profileMenuItems;



}
