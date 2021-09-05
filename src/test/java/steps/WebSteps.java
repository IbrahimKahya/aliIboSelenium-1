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
}
