package sheetalsingh;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NotepadTest {

    private static WindowsDriver driver = null;

    @BeforeClass
    public void init(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    @Test
    public void testNotepad(){
        driver.findElementByClassName("Edit").sendKeys("Hello Friends, This is WinAppDriver!!");
    }


}
