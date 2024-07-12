package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class GamePage {

    public GamePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "left_0")
    public WebElement firstLeftBox;
    @FindBy(id = "right_0")
    public WebElement firstRightBox;
    @FindBy(xpath = "(//button[@id ='reset'])[1]")
    public WebElement resultButton;
    @FindBy(xpath = "//ol/li")
    public List<WebElement> resultList;


    public void clickOnButton(String buttonName) {
        Driver.getDriver().findElement
                (By.xpath("//button[. = '" + buttonName + "']")).click();
    }

    public List<WebElement> getAllBarsAsList() {
        return Driver.getDriver().findElements
                (By.xpath("//div[@class = 'coins']/button"));
    }

    public List<WebElement> getThreeBoxesAsList(String leftOrRight) {
        leftOrRight = leftOrRight.toLowerCase();
        List<WebElement> boxes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            boxes.add(Driver.getDriver().findElement(By.id(leftOrRight + "_" + i)));
        }

        return boxes;
    }


}
