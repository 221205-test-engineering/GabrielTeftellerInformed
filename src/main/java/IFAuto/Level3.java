package IFAuto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Level3 extends Level
{
    @FindBy(xpath = "//*[@type='checkbox']")
    public List<WebElement> textInputs;

    @FindBy(xpath = "/html/body/form/button")
    public WebElement button;

    public Level3()
    {
        super("level-3.html");
    }

    @Override
    public void complete()
    {
        textInputs.forEach(t ->
        {
            WebElement wait = new WebDriverWait(super.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(t));

            t.sendKeys("z");
        });

        button.submit();
    }
}
