package runners;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Util;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features/",
        glue = "steps",
        tags = "@funcionais",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = true
)
public class Runner {

    @BeforeClass
    public static void resetar(){
        System.setProperty("webdriver.chrome.driver", Util.retornaPathChromeDriver());
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("evanymaciel@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("Karlinha1");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
