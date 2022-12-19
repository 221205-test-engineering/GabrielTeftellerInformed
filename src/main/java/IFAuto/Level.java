package IFAuto;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Level
{
    public static String path;
    public static WebDriver driver;
    String fileName;

    public Level(String fileName)
    {
        this.fileName = fileName;
        PageFactory.initElements(driver, this);
    }

    abstract void complete();

    public void run()
    {
        driver.get(path + "\\" + fileName);

        complete();

        Alert alert = driver.switchTo().alert();

        if (alert.getText().contains("SUCCESS"))
        {
            System.out.println(fileName + ": " + alert.getText());
        }
        else
        {
            System.out.println(fileName + ": " + alert.getText());
        }

        alert.accept();
    }
}

