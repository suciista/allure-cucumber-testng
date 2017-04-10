package Steps;

import Page.ExamplePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by suci on 4/7/17.
 */
public class ExampleSteps2 {
    ExamplePage page;

    public ExampleSteps2(){
        page = new ExamplePage(AndroidSetup.driver);
    }

    @Given("^I type wrong username$")
    public void typeWrongUsername(){
        page.typeUsername("sasasa");
    }

    @And("^I type wrong password$")
    public void typeWrongPassword(){
        page.typePassword("");
    }

    @Then("^I verify login is fail$")
    public void verifyLoginFail(){
        page.verifyFailLogin();
    }
}
