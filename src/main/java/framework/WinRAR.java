package framework;

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;

public class WinRAR {

    private static WindowsDriver driver = null;
    private static WebElement CalculatorResult = null;

    @BeforeClass
    public static void setup() {
    	
    //	String gitBashAppId = "C:\\Program Files\\Git\\git-bash.exe!App";
    	String winrar = "C:\\Program Files\\WinRAR\\WinRAR.exe";
    //	String gitBashAppId = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", winrar);
            
            /**
    		 * @author Shubham Jain
    		 *To get the app id we need to open the app, use task manager and right click on it and see properties and copy the id
    		 *Add !App at the end of the id and paste in above capability 
    		 */
            
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @AfterClass
    public static void TearDown()
    {
        CalculatorResult = null;
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @Test
    public void shubhamtest()
    {
    	driver.findElementByName("File").click();
    	driver.findElementByName("Exit").click();
    }


}
