package com.crm.step_definitions;

import com.crm.pages.CRM_HomePage;
import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActivityStreamStepDef {

    CRM_HomePage homePage = new CRM_HomePage();

    @Then("User can see options below")
    public void user_can_see_options_below(List<String> options) {

        List<WebElement> elements = homePage.listOfElements;

        List<String> actualOptions = new ArrayList<>();

        for (WebElement eachElement : elements) {
            actualOptions.add(eachElement.getText());
        }

        Assert.assertEquals(options, actualOptions);

    }

    @Then("User sees options below option under MORE")
    public void userSeesOptionsBelowOptionUnder(List<String> expectedOptions) {

        //clicks "MORE" function to be able to see options
        homePage.moreLink.click();
        //After click waits 2 second
        BrowserUtils.sleep(2);

        //Created a List<WebElement> to be able to store each element into the LIST
        //(And created webElements container which is already defined in CRM_HomePage class)
        List<WebElement> listOfElements = homePage.listOfMoreLinks;

        //Created New empty List<String> to be able to store actual WebElement's Text
        List<String> actualOptions = new ArrayList<>();

        //Iterating through listOfElements and getting text each of it, and storing into List<String> above
        for (WebElement eachElement : listOfElements) {
            actualOptions.add(eachElement.getText());
        }

        //Comparing expectedOptions which is passed as an argument with actualOptions
        Assert.assertEquals(expectedOptions, actualOptions);

    }

    //aasdasd
    @Then("User should click MORE")
    public void userShouldClickMORE() {
        homePage.moreLink.click();

    }

}
