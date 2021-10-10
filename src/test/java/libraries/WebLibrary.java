package libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebLibrary {

    public static WebDriver driver;
    private static CharSequence text;

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

    public static void clickFullScreen(){

        WebElement clickFullScreen = driver.findElement(By.cssSelector("[aria-label=\"Full screen (f)\"]"));

        clickFullScreen.click();

    }
    public static void performTrendyolSearch(String text){
        WebElement searchBar = driver.findElement(By.cssSelector("input[class=\"search-box\"]"));
        searchBar.sendKeys(text);}

    public static void popupSecme(){
        WebElement closeButton = driver.findElement(By.cssSelector("[title=\"Kapat\"]"));
        closeButton.click();
    }

    public static void searchButton(){

        WebElement playButton = driver.findElement(By.cssSelector("input[class=\"search-box\"]"));

        playButton.sendKeys(Keys.ENTER);

    }

    public static void pressImage(int number) {
        List<WebElement> resultList = driver.findElements(By.cssSelector("[class=\"p-card-wrppr\"]"));

        System.out.println(resultList.get(number).getText());

        centerElement(resultList.get(number)).click();


    }
    public static void pressButton(){

        WebElement playButton = driver.findElement(By.cssSelector("[class=\"add-to-basket\"]"));

        playButton.sendKeys(Keys.ENTER);

    }

    public static void loop(){
        List<WebElement> resultList = driver.findElements(By.cssSelector("[class=\"p-card-wrppr\"]"));
        for (WebElement productCard:resultList) {
            System.out.println(productCard.getText());


                if (productCard.getText().contains("Vans")){
                    productCard.findElement(By.cssSelector("Span")).click();
                    return;
                }

        }
    }

    public static void clickOverlay(){
        WebElement overlay = driver.findElement(By.cssSelector("[class=\"overlay\"]"));
        overlay.click();
    }





}