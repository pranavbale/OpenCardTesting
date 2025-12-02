package abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AbstractComponent {

    public WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title=\"My Account\"]")
    public WebElement myAccount;

    @FindBy(css = "img[title=\"TheTestingAcademy eCommerce\"]")
    public WebElement logo;

}
