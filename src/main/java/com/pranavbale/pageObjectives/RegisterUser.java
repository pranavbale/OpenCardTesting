package com.pranavbale.pageObjectives;

import com.pranavbale.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUser extends AbstractComponent {

    WebDriver driver;

    public RegisterUser(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://awesomeqa.com/ui/index.php?route=account/register']")
    WebElement register;

    @FindBy(xpath = "//input[@name=\"firstname\"]")
    WebElement firstName;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    WebElement lastName;

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email;

    @FindBy(xpath = "//input[@name=\"telephone\"]")
    WebElement telephone;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//input[@name=\"confirm\"]")
    WebElement conformPassword;

    @FindBy(css = "input[value=\"1\"][name=\"newsletter\"]")
    WebElement subscribeYes;

    @FindBy(css = "input[value=\"0\"][name=\"newsletter\"]")
    WebElement subscribeNo;

    @FindBy(css = "input[name='agree']")
    WebElement privacyPolicy;

    @FindBy(css = "input[type='submit']")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    WebElement alert;

    public void createAccount() {
        myAccount.click();
        register.click();
        resisterAccount();
    }

    public void resisterAccount() {
    }

}
