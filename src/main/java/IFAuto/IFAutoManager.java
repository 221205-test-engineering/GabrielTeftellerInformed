package IFAuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class IFAutoManager
{
    static WebDriver driver;
    File chrome;

    public IFAutoManager()
    {
        chrome = new File("src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

        driver = new ChromeDriver();

        Level.path = "file:///" + new File(".").getAbsolutePath() + "\\src\\main\\resources";
        Level.driver = driver;
    }

    public void run()
    {
        Level1 level1 = new Level1();
        level1.run();

        Level2 level2 = new Level2();
        level2.run();

        Level3 level3 = new Level3();
        level3.run();

        driver.quit();
    }
}
