package sheetalsingh;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AlarmTest {

    private static WindowsDriver driver = null;

    @BeforeClass
    public void init(){
        try {
            // Launch the Alarms & Clock app
            DesiredCapabilities appCapabilities = new DesiredCapabilities();
            appCapabilities.setCapability("app", "Microsoft.WindowsAlarms_8wekyb3d8bbwe!App");
            driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities);
            System.out.println("Successfully created session ........... ");
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @AfterClass
    public static void TearDown() throws InterruptedException {
        //Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testWorldClock() throws InterruptedException {
    	
    	driver.findElementByName("Alarm").click();
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Good morning")));

    	//Toggle alarm
        driver.findElementByName("Good morning").click();
        //Thread.sleep(3000);
        //Add a world clock
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Clock")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Clock")));
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Clock")));
        driver.findElement(By.name("Clock")).click();

        Thread.sleep(3000);
        //Right click and delete added clock
        Actions action= new Actions(driver);
        WebElement mexico = driver.findElementByAccessibilityId("WorldClockItemGrid");

        action.contextClick(mexico).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

    }



}


