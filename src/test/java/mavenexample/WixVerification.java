package mavenexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WixVerification {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wix.com");
        WebElement getStartedBtn = driver.findElement(By.className("M3I7Z2"));
        getStartedBtn.click();
        String expectedPageHeadingText = "ABC";
        WebElement getStartedHeading = driver.findElement(By.className("sign-up-title"));
        String actualPageHeadingText = getStartedHeading.getText();
        if(actualPageHeadingText.contains(expectedPageHeadingText)){
            System.out.println("Test is pass");
        }
        else {
            System.out.println("Test is fail");
        }
        driver.quit();
    }



}
