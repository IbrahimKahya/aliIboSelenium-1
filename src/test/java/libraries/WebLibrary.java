package libraries;

import org.openqa.selenium.*;
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
        List<WebElement> resultList = driver.findElements(By.cssSelector("[class='g'] a h3"));

        System.out.println(resultList.get(gülbeninci).getText());

        centerElement(resultList.get(gülbeninci)).click();

    }

    public static WebElement centerElement(WebElement element){

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }

    public static void clickPlayButton(){

        WebElement playButton = driver.findElement(By.cssSelector("[aria-label=\"Oynat\"]"));

        playButton.click();




    }
}
