package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityStreamPage {


    public ActivityStreamPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="feed-add-post-form-tab-message")
    public WebElement messageTab;

    @FindBy(id="feed-add-post-form-tab-tasks")
    public WebElement taskTab;

    @FindBy(id = "feed-add-post-form-tab-calendar")
    public WebElement eventTab;

    @FindBy(id="feed-add-post-form-tab-vote")
    public WebElement pollTab;

    @FindBy(xpath="//span[text()='More']")
    public WebElement moreTab;


///dropdown options from moreTab:

    @FindBy(xpath="//span[text()='File']")
    public WebElement fileOption;

    @FindBy(xpath="//span[text()='Appreciation']")
    public WebElement appreciationOption;

    @FindBy(xpath="//span[text()='Announcement']")
    public WebElement announcementOption;

    @FindBy(xpath="//span[text()='Workflow']")
    public WebElement workflowOption;






}
