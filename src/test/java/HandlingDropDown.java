
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HandlingDropDown {
    /**
     * class description
     */
    WebDriver driver;

    /**
     * Set up browser settings and open the application
     */

    @BeforeMethod
    public void setUp() {


// Opened the application
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/ASUS/Desktop/test.html");
        driver.manage().window().maximize();
    }

    /**
     * Test to select the dropdown values
     *
     * @throws InterruptedException
     */

    @Test
    public void testSelectFunctionality() throws InterruptedException {

// Go to google
        driver.findElement(By.partialLinkText("Goog")).click();

// navigate back to previous webpage
        driver.navigate().back();
        Thread.sleep(5000);

// select the first operator using "select by value"
        Select selectByValue = new Select(driver.findElement(By.id("SelectID_One")));
        selectByValue.selectByValue("greenvalue");
        Thread.sleep(5000);

// select the second dropdown using "select by visible text"
        Select selectByVisibleText = new Select(driver.findElement(By.id("SelectID_Two")));
        selectByVisibleText.selectByVisibleText("Lime");
        Thread.sleep(5000);

// select the third dropdown using "select by index"
        Select selectByIndex = new Select(driver.findElement(By.id("SelectID_Three")));
        selectByIndex.selectByIndex(2);
        Thread.sleep(5000);

        driver.findElement(By.tagName("button")).click();
    }

    /**
     * Tear down the setup after test completes
     */

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

