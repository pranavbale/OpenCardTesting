package testComponent;

import com.pranavbale.pageObjectives.RegisterUser;
import com.pranavbale.resources.data.JsonUtils;
import dataProvider.DataProviderClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.jackson.databind.JsonNode;

import static com.pranavbale.resources.data.JsonUtils.readJson;

public class SignUp extends BaseTest{

    @Test(dataProvider = "user", dataProviderClass = DataProviderClass.class)
    public void SignUpUser(JsonNode node) {

        RegisterUser registerUser = new RegisterUser(driver);
        registerUser.createAccount(node);
    }

}
