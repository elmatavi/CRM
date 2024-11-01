package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollPage extends BasePage {


    public PollPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locate All employees
    @FindBy(xpath = "//span[.='All employees']")
    public WebElement allEmployess;

    // Locate poll addQuestionBtn;
    @FindBy(xpath = "//a[.='Add question']")
    public WebElement addQuestionBtn;

    // Locate poll questionInput;
    @FindBy(xpath = "//input[@placeholder='Question ']")
    public WebElement questionInput;

    // Locate poll first AnswerBtn;
    @FindBy(xpath ="//input[@class='vote-block-inp adda']" )
    public WebElement firstAnswerInput;

    // Locate second answerInput;
    @FindBy(xpath = "//input[@id='answer_0__1_']" )
    public WebElement secondAnswerInput;

    // Locate Allow multiple choice
    @FindBy(xpath = "//input[@value='Y']")
    public WebElement multipleChoiceBtn;


    // Locator for the iframe
    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageIframe;

    @FindBy(xpath= "//body[@contenteditable='true']")
    public WebElement messageBody;

    //Locate send button
    @FindBy(id = "blog-submit-button-save")
    public WebElement sendBtn;

    // Locate "The message title is not specified"
    @FindBy(xpath = "//span[.='The message title is not specified']")
    public WebElement clearMessageTitle;


    //Locate "Please specify at least one person."
    @FindBy(xpath = "//span[.='Please specify at least one person.']")
    public WebElement unselectRecipients;
     //Locate "The question text is not specified."
    @FindBy(xpath = "//span[.='The question text is not specified.']")
    public WebElement errorQuestion;

    @FindBy(xpath = "//div[@class='feed-add-error']/span[@class='feed-add-info-text']")
    public WebElement errorAnswer;

    //Locate clear recipients
    @FindBy(xpath = "//a[.='Add persons, groups or department']")
    public WebElement clearRecipientsBtn;


    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement delBtnAllEmployees;






}
