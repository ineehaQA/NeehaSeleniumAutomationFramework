package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Reports.ExtentReportManager;
import Utils.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;
    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReportInstance();
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        driver.get("https://www.flipkart.com");
    }

    @AfterClass
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            test.fail("Test Failed. Screenshot attached.")
                .addScreenCaptureFromPath(screenshotPath);
        }
        driver.quit();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
