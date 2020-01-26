package TestsForTires;


import org.testng.annotations.AfterMethod;
import static com.codeborne.selenide.Selenide.close;

public class BaseTest {

    @AfterMethod (groups = "Regression")
    public void tearDown() {
        close();
    }
}

