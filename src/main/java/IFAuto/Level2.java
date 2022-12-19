package IFAuto;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// this page a failure alert when (rand >0.67) and ONLY then. I have no idea why.
public class Level2 extends Level
{
    @FindBy(xpath = "/html/body/dl/dd[1]")
    public WebElement dropdown;

    @FindBy(xpath = "/html/body/dl/dd[3]")
    public WebElement radio;

    @FindBy(xpath = "/html/body/dl/dd[4]")
    public WebElement date;

    @FindBy(name = "input1")
    public WebElement dropdownInput;

    @FindBy(xpath = "//*[@type='checkbox']")
    public List<WebElement> checkboxInputs;

    @FindBy(xpath = "//*[@type='radio']")
    public List<WebElement> radioInputs;

    @FindBy(name = "dateInput")
    public WebElement dateInput;

    public Level2()
    {
        super("level-2.html");
    }

    @Override
    public void complete() {
        Select dropdownSelect = new Select(dropdownInput);
        dropdownSelect.selectByVisibleText(dropdown.getAttribute("innerHTML"));

        checkboxInputs.forEach(b ->
        {
            b.click();
        });

        String radioValue = radio.getAttribute("innerHTML");
        radioInputs.forEach(r ->
        {
            if (radioValue.equals(r.getAttribute("value")))
            {
                r.click();
            }
        });

        String dateValue = date.getAttribute("innerHTML");
        String[] strArray = dateValue.split("-");
        String fixedDate = strArray[1] + strArray[2] + strArray[0];
        dateInput.sendKeys(fixedDate);
        dateInput.submit();
    }
}