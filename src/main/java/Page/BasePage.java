package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.Arrays;

/**
 * Created by suci on 4/4/17.
 */
public class BasePage {

    protected WebDriver driver;
    protected Wait wait;
    protected int TIMEOUT = 10;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private void locatorType(String locatorType){
        String[] locatorTypes = {"id","name","xpath","classname","css","dom","linktext"};

        Assert.assertTrue(Arrays.asList(locatorTypes).contains(locatorType));
    }

    private By getByElement(String locatorType, String locatorName){
        //locatorType(locatorType);

        if(locatorType.equalsIgnoreCase("ID")){
            return By.id(locatorName);
        }else if(locatorType.equalsIgnoreCase("NAME")){
            return By.name(locatorName);
        }else if(locatorType.equalsIgnoreCase("XPATH")){
            return By.xpath(locatorName);
        }else if(locatorType.equalsIgnoreCase("CLASSNAME")){
            return By.className(locatorName);
        }else if (locatorType.equalsIgnoreCase("CSSSELECTOR")){
            return By.cssSelector(locatorName);
        }else if(locatorType.equalsIgnoreCase("LINKTEXT")){
            return By.linkText(locatorName);
        }
        else if(locatorType.equalsIgnoreCase("PARTIALLINKTEXT")){
            return By.partialLinkText(locatorName);
        }else{
            return null;
        }

    }

    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void clickElement(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        driver.findElement(getByElement(locatorType,locatorName)).click();
    }

    /**
     * type an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     * @param input
     */
    public void typeElement(String locatorType, String locatorName, String input){
        By by  = getByElement(locatorType,locatorName);
        driver.findElement(by).sendKeys(input);
    }

    /**
     *
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void waitElementToBeClickAble(final String locatorType, final String locatorName) {
        wait = new WebDriverWait(driver,TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(getByElement(locatorType,locatorName)));
    }

    public String getTextString(String locatorType, String locatorName){
        return driver.findElement(getByElement(locatorType,locatorName)).getText();
    }

}
