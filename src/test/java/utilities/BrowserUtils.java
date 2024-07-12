package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    public static List<String> webElementsList_toStringList
            (List<WebElement> webElementList) {

        List<String> result = new ArrayList<>();

        for (WebElement eahWebElement : webElementList) {
            result.add(eahWebElement.getText());
        }
        return result;

    }
}
