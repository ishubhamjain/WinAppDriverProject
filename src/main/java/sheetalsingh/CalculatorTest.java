package sheetalsingh;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    private static WindowsDriver driver = null;
    private static WebElement CalculatorResult = null;

    @BeforeClass
    public void init(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");
            Assert.assertNotNull(CalculatorResult);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        CalculatorResult = null;
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    //It will clear the result before new test begin
    @BeforeMethod
    public void Clear()
    {
        driver.findElementByName("Clear").click();
        Assert.assertEquals("0", getCalculatorResult());
    }


    protected String getCalculatorResult()
    {
        String result =  CalculatorResult.getText().replace("Display is", "").trim();
        System.out.println("=============> Final Result: "+ result);
        return result;
    }


    @Test
    public void Addition(){
        System.out.println("--- Addition ---");
        driver.findElementByName("One").click();
        driver.findElementByName("Plus").click();
        driver.findElementByName("Seven").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResult());
    }



    @Test
    public void Subtraction()
    {
        System.out.println("--- Subtraction ---");
        driver.findElementByName("Nine").click();
        driver.findElementByName("Minus").click();
        driver.findElementByName("One").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResult());
    }


    @Test
    public void Multiplication()
    {
        System.out.println("--- Multiplication ---");
        driver.findElementByName("Nine").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Nine").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals("81", getCalculatorResult());
    }


    @Test
    public void Division()
    {
        System.out.println("--- Division ---");
        driver.findElementByName("Eight").click();
        driver.findElementByName("Eight").click();
        driver.findElementByName("Divide by").click();
        driver.findElementByName("One").click();
        driver.findElementByName("One").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResult());
    }


    @Test
    public void Combination()
    {
        System.out.println("--- Combination ---");
        driver.findElementByName("Seven").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Nine").click();
        driver.findElementByName("Plus").click();
        driver.findElementByName("One").click();
        driver.findElementByName("Equals").click();
        driver.findElementByName("Divide by").click();
        driver.findElementByName("Eight").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResult());
    }


    //AutomationId:	"num1Button"
    @Test
    public void verifyOtherLocators(){
        driver.findElementByAccessibilityId("num1Button").click();
        driver.findElementByXPath("//Button[@Name='Plus']").click();
        driver.findElementByXPath("//Button[@Name='One']").click();
        driver.findElementByName("Equals").click();
        Assert.assertEquals("2", CalculatorResult.getText().replace("Display is", "").trim());
    }

    @Test
    public void Menu() throws InterruptedException {

        Actions action= new Actions(driver);
        driver.findElementByName("Menu").click();
        action.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.RETURN).build().perform();

        Thread.sleep(2000);

        driver.findElementByName("Menu").click();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();


    }


}
