package dataProvider;

import com.pranavbale.resources.data.JsonUtils;
import org.testng.annotations.DataProvider;

public class DataProviderClass extends JsonUtils {

    @DataProvider(name ="user")
    public Object[][] usersData() throws Exception {
        return readJson("Users.json");
    }
}
