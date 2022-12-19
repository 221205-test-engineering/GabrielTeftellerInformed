package IFAuto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level1 extends Level
{
    @FindBy(id="randomString")
    public WebElement randomString;

    @FindBy(id="nameInput")
    public WebElement nameInput;

    @FindBy(xpath="/html/body/form/button")
    public WebElement submit;

    public Level1()
    {
        super("level-1.html");
    }

    @Override
    public void complete()
    {
        String name = randomString.getText();
        nameInput.sendKeys(name);
        submit.click();
    }
}
