package nannp.tests;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import nannp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();  // ← khởi tạo driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ← thêm dòng này
        driver.get("https://crm.anhtester.com/admin/authentication");
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        // Chạy SAU mỗi test case
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void loginSuccess(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com","123456");

    }

    @Test
    public void login_wrongEmail_showError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ad@example.com","123456");
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg, "Username is required");
    }



}
