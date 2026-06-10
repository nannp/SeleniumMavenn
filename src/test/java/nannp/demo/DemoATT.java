package nannp.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class DemoATT {

        public static void main(String[] args) {
            //khởi tạo browser
            WebDriver driver = new ChromeDriver();

            //2 hàm chờ đợi
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // chờ tối đa 10s nếu không tìm được element đã chỉ định thì báo lỗi
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // chờ tối da 20s nếu chưa load xong trang thì sẽ báo lỗi ( thực hiện load trang trước rồi mới thực hiện load element) - thời gian chờ đợi để load trang

            //2 hàm để maximize/ minimize cửa sổ trình duyệt
            driver.manage().window().maximize(); //mục đích chọn maximize là để chứa thanh taskbar phía trên ( có theer thấy được URL), chứa thanh taskbar phía dưới ( có thể kiểm soát bật được browser chưa...)
            //driver.manage().window().fullscreen(); // tương đương F11
            //driver.manage().window().minimize();

            //mở website
            driver.navigate().to("https://crm.anhtester.com/admin/authentication");
            //driver.navigate().to("https://cms.anhtester.com/login");
            //driver.navigate().to("https://rise.anhtester.com/signin");

            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");

//        String labelEmail = driver.findElement(By.xpath("//label[normalize-space()='Email Address']")).getText();
//        System.out.println(labelEmail);

            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //get title
            System.out.println("title +  " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // đóng browser
            //driver.quit();










        }


}
