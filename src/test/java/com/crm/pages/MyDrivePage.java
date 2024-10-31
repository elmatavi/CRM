package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyDrivePage {


    public MyDrivePage() { PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "(//span[@class='menu-item-link-text'])[5]")

    public WebElement DriveButton;

    @FindBy(xpath = "//div[@id='top_menu_id_docs']/div/a")
    public List<WebElement> driveModules;










}
