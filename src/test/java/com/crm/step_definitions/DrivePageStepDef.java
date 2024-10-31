package com.crm.step_definitions;

import com.crm.pages.MyDrivePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DrivePageStepDef {

   MyDrivePage myDrivePage = new MyDrivePage();



    @Then("the user click the Drive button")
    public void the_user_click_the_drive_button() {
        myDrivePage.DriveButton.click();


    }
    @Then("the user should see the following modules on the Drive page")
    public void the_user_should_see_the_following_modules_on_the_drive_page(List<String> modules) {


     // Get the actual module elements and extract their text
     List<WebElement> listOfElements = myDrivePage.driveModules;
     List<String> actualOptions = new ArrayList<>();
     for (WebElement eachElement : listOfElements) {
      actualOptions.add(eachElement.getText());
     }
     Assert.assertEquals(actualOptions, modules);



    }
    }


