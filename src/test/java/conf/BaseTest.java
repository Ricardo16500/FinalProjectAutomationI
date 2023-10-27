package conf;

import com.aventstack.extentreports.Status;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.factory.WebDriverFactory;
import org.example.helpers.ReportManager;
import org.example.helpers.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    private String url;

    private String browser;

    @Getter
    @Setter
    private String user;

    @Getter
    @Setter
    private String password;

    private static final Logger log = LogManager.getLogger(BaseTest.class);



    @BeforeSuite
    public void setupSuite() throws Exception {
        ReportManager.init("reports", "PurchaseSuite");



    }

    @Parameters({"browser", "url", "user", "password"})
    @BeforeMethod
    public void setup(ITestResult iTestResult, String browser, String url, String user, String password) throws Exception {
        this.setUser(user);
        this.setPassword(password);
        this.setUrl(url);
        this.setBrowser(browser.toLowerCase());
        ReportManager.getInstance().startTest(iTestResult.getMethod().getDescription());

        String os = System.getProperty("os.name").toLowerCase();

        driver = WebDriverFactory.createWebDriver(os, browser);

        log.info("Opening browser {}", browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);

        log.info("Navigate to {}", url);

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Navigate to main page");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test fails");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passes");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if (iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "Failure Image");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //wait for 5 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (driver != null)
                driver.quit();
            log.info("Closing the driver");
        }
    }

    @AfterSuite
    public static void tearDownSuite() {
        ReportManager.getInstance().flush();
    }


    private void setUrl(String url) {
        this.url = url;
    }

    private void setBrowser(String browser) {
        this.browser = browser;
    }

}