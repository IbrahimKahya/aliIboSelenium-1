package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebLibrary {

    public static WebDriver driver;

    public static void setup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
    }

    public static void performSearch(String text){
        WebElement searchBar = driver.findElement(By.cssSelector("input[name=\"q\"]"));
        searchBar.sendKeys(text);

    }
    public static void waitFor(double seconds) throws InterruptedException {
        Thread.sleep((long) (seconds * 1000));
    }

    public static void pressEnter(){
        WebElement searchBar = driver.findElement(By.cssSelector("input[name=\"q\"]"));
        searchBar.sendKeys(Keys.ENTER);
    }

    public static void clickNthResult(int gülbeninci){
        List<WebElement> resultList = driver.findElements(By.cssSelector("[class='g']"));
        for (WebElement result:resultList) {

            System.out.println(result.getText());

        }
    }
}
