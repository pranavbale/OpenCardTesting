package pageObjectives;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tools.jackson.databind.JsonNode;

import java.time.Duration;
import java.util.List;

public class RegisterUser extends AbstractComponent {

    public RegisterUser(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://awesomeqa.com/ui/index.php?route=account/register']")
    WebElement register;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    WebElement login;

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
    List<WebElement> alert;

    @FindBy(tagName = "h1")
    WebElement accountCreated;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement continueButton;

    public void loginOrResisterUser(JsonNode node) {
        myAccount.click();
        register.click();
        if (resisterAccount(node)) {
            return;
        }
        loginUser(node);
    }

    public boolean resisterAccount(JsonNode node) {

        firstName.sendKeys(node.path("firstName").asString());
        lastName.sendKeys(node.path("lastName").asString());
        email.sendKeys(node.path("email").asString());
        telephone.sendKeys(node.path("telephone").asString());
        password.sendKeys(node.path("password").toString());
        conformPassword.sendKeys(node.path("password").toString());
        subscribeNo.click();
        privacyPolicy.click();
        submit.click();

        if (alert.size() > 0) {
            if (alert.get(0).getText().contains("Warning: E-Mail Address is already registered!")) {
                return false;
            }
        }


        Assert.assertTrue(accountCreated.getText().equalsIgnoreCase("Your Account Has Been Created!"));
        continueButton.click();

        logo.click();
        return true;
    }

    public void loginUser(JsonNode node) {
        myAccount.click();
        login.click();
        email.sendKeys(node.path("email").asString());
        password.sendKeys(node.path("password").toString());
        submit.click();
    }

}
