package Page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by suci on 4/5/17.
 */
public class ExamplePage extends BasePage {

    private String userNameField = "com.naspers_classifieds.loginsample:id/username";
    private String passwordField = "com.naspers_classifieds.loginsample:id/password";
    private String loginButton = "com.naspers_classifieds.loginsample:id/login";
    private String messageText = "com.naspers_classifieds.loginsample:id/message";

    public ExamplePage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username){
        typeElement("Id",userNameField,username);
    }

    public void typePassword(String password){
        typeElement("Id",passwordField, password);
    }

    public void clickLoginButton(){
        clickElement("ID", loginButton);
    }

    public void verifySuccessLogin(){
        Assert.assertEquals(getTextString("ID",messageText),"Success!","Can not find Success!");
    }

    public void verifyFailLogin(){
        Assert.assertEquals(getTextString("ID",messageText),"Failure!","Can not find Failure!");
    }
}
