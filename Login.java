package dealdep;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login {

    private static WebDriver driver;
    private WebElement element;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\DriverChrom\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    @Test
    public void Find() {
        driver.get("http://google.com.ua");
        WebElement search = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
        search.sendKeys("Nebuchadnezzar");
        search.submit();

        Assert.assertTrue(isPresent());
    }

    public Boolean isPresent(){
        List <WebElement> allElements = driver.findElements(By.className("iUh30" ));
        int s = allElements.size();
        Boolean b = false;
        if(s>0) {
            b = true;
        }
        return b;
    }

///переписать на PageObject & Selenide

    // driver.findElement(By.tagName( "https://ru.wikipedia.org/3/"))
    //       .click();
    //Assert.assertTrue();
    //assert?

    //
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}