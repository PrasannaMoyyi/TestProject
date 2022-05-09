package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
//      System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);
        WebElement accountAndLists = driver.findElement(By.xpath("//div[@id = 'nav-tools']/a[contains(@href, 'https://www.amazon.in/ap/signin?')]"));
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
        //Hover over account and lists
        //click on sign in button
        act.moveToElement(accountAndLists).moveToElement(signInButton).click().build().perform();
        //Enter username
        driver.findElement(By.id("ap_email")).sendKeys("");
        //click on continue
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        //Enter password
        driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("");
        //click on sign-in
        driver.findElement(By.id("signInSubmit")).click();

        //verify if logo is present
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        if (logo.isDisplayed()){
            System.out.println("signin successful");
        }
        driver.close();
    }
}

