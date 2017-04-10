package Steps;

import Page.ExamplePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by suci on 4/5/17.
 */
public class ExampleSteps{

    ExamplePage page;
    //AndroidSetup android;

    public ExampleSteps(){
        page = new ExamplePage(AndroidSetup.driver);
    }

    @Given("^I type correct username$")
    public void I_type_correct_username(){
        System.out.println("I type correct username");
        page.typeUsername("athena@olx.com");
    }

    @And("^I type correct password$")
    public void typeCorrectPassword(){
        System.out.println("I type correct password");
        page.typePassword("123456");
    }

    @When("^I click login button$")
    public void clickLoginButton(){
        System.out.println("I click login button");
        page.clickLoginButton();
    }

    @Then("^I verify login is success$")
    public void verifyLoginIsSuccess(){
        System.out.println("I verify login is success");
        page.verifySuccessLogin();
    }
}
