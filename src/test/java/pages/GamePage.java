package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GamePage {

    public GamePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
