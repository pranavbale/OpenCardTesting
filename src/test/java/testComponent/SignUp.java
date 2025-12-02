package testComponent;

import pageObjectives.RegisterUser;
import dataProvider.DataProviderClass;
import org.testng.annotations.Test;
import tools.jackson.databind.JsonNode;

public class SignUp extends BaseTest{

    @Test(dataProvider = "user", dataProviderClass = DataProviderClass.class)
    public void SignUpUser(JsonNode node) {

        RegisterUser registerUser = new RegisterUser(driver);
        registerUser.loginOrResisterUser(node);
    }

}
