package integration.factory.web.configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import integration.factory.web.common.BaseTest;
import integration.factory.web.enums.Web;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.net.MalformedURLException;

public class Hooks extends BaseTest {

    @Before
    public void beforeTest() throws MalformedURLException {
        System.out.println("Sistema Operacional: " + System.getProperty("os.name"));
        super.inicializarDriver(Web.CHROME);

    }

    @After
    public void afterTest(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        driver.quit();
    }
}
