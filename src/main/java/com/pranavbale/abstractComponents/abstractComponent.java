package com.pranavbale.abstractComponents;

import com.pranavbale.pageObjectives.RegisterUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abstractComponent {

    WebDriver driver;

    public abstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title=\"My Account\"]")
    WebElement myAccount;

}
