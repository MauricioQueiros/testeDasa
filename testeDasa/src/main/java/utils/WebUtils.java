package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebUtils {

    static WebDriver driver;

    public WebDriver getSite(String url){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    public static void closeDriver(){
        driver.close();
    }

    public void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void sendKeys(String xpath, String text){
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void validateText(String xpath ,String text){
        String textToBeValidate = driver.findElement(By.xpath(xpath)).getText();
        if(!textToBeValidate.contains(text)){
            Assert.fail("Não foi possivel localizar o texto "+ text);
        }
    }

    public void validateTextNotExist( String xpath){
        if(driver.findElements(By.xpath(xpath)).isEmpty()){
            Assert.fail("O xpath ainda esta presente na tela");
        }
    }

    public void waitTime(int time){
        try {
            Thread.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
