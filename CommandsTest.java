import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        String beforeText = driver.findElement(By.xpath("(//button[@type='button'])[2]")).getText();

        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));

        boolean isEnabled = driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled();

        if (isEnabled) {
            System.out.println("შეყვანის ველი გააქტიურდა და ტექსტი ჩანს");
        }

        String afterText = driver.findElement(By.xpath("(//button[@type='button'])[2]")).getText();

        if (beforeText.equals("Enable") && afterText.equals("Disable")) {
            System.out.println("ღილაკის ტექსტი წარმატებით შეიცვალა");
        }

        driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("Bootcamp");

        driver.findElement(By.xpath("//form[@id='input-example']/input")).clear();

        wait.until(ExpectedConditions.textToBePresentInElementValue(
                By.xpath("//form[@id='input-example']/input"), ""
        ));


        driver.navigate().to("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        int columnA_y = columnA.getLocation().getY();
        int columnB_y = columnB.getLocation().getY();

        if(columnA_y == columnB_y) {
            System.out.println("სვეტები A და B წარმატებით არიან გასწორებული");
        }
        else{
            System.out.println("სვეტები არ არის გასწორებული ");
        }


        driver.quit();
    }
}
