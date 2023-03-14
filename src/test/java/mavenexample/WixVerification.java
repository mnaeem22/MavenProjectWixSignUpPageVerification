package mavenexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Iterator;
import java.util.Set;

public class WixVerification {

    public static void main(String[] args)  {
        ChromeOptions co =new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.get("https://www.wix.com");

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        WebElement getStartedButton = driver.findElement(By.className("M3I7Z2"));
        getStartedButton.click();

        Set<String> s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {

            String child_window=I1.next();


            if(!originalWindow.equals(child_window))
            {
                driver.switchTo().window(child_window);

                System.out.println(driver.switchTo().window(child_window).getTitle());

            }

        }

        WebElement getStartedHeading = driver.findElement(By.className("sign-up-title"));
        String getStartedHeadingText = getStartedHeading.getText();
        String exptedGetStartedPageText = "Sign Up";

        if(getStartedHeadingText.contains(exptedGetStartedPageText)){
            System.out.println("Test is Pass");
        }
        else{
            System.out.println("Test is Fail");
        }

        driver.quit();

    }





}
