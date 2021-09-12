package steps;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import libraries.WebLibrary;

public class WebSteps {

    @Before
    public void initialize(){ WebLibrary.setup(); }

    @After
    public void kill(){ WebLibrary.driver.quit(); }

    @Given("Go to {}")
    public void getUrl(String url){WebLibrary.driver.get("https://"+url);}

    @Given("Perform a google search for {}")
    public void performGoogleSearch(String Gülben){
        WebLibrary.performSearch(Gülben);

    }

    @Given("Wait for {} seconds")
    public void waitFor(double Gülben) throws InterruptedException {
        WebLibrary.waitFor(Gülben);
    }
    @Given("Press enter")
    public void pressEnter(){
        WebLibrary.pressEnter();
    }
    
    @Given("Click result number {}")
    public void clickNTh(int Gülben){
        WebLibrary.clickNthResult(Gülben);
    }

    @Given("Click play button")
    public void clickPlayButton(){
        WebLibrary.clickPlayButton();
    }

}
