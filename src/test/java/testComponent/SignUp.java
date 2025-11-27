package testComponent;

import com.pranavbale.pageObjectives.RegisterUser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUp extends BaseTest{

    @Test
    public void SignUpUser() {

        RegisterUser registerUser = new RegisterUser(driver);
        registerUser.createAccount();
    }

}
