package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name ="user")
    public Object[][] usersData() {
        return new Object[0][];
    }
}
