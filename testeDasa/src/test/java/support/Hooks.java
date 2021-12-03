package support;


import cucumber.api.java.After;
import utils.WebUtils;

public class Hooks {

    @After
    public void afterScenario(){
        WebUtils.closeDriver();
    }
}
