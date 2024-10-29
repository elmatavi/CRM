package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ModuleVerificationPage {

        public ModuleVerificationPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(linkText = "Company")
        public WebElement companyLink;

    @FindBy(xpath = "//*[contains(@class, 'main-buttons-item-link')]")
    //@FindBy(xpath = "//div[@id='top_menu_id_about']")
        public List<WebElement> moduleTitles;

    }





