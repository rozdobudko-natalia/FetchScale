package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import pages.GamePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ScaleStepDefs {

    GamePage gamePage;
    List<WebElement> goldBars;
    List<String> resultAsString;

    @Given("user is on the fake gold bar page")
    public void user_is_on_the_fake_gold_bar_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        gamePage = new GamePage();
        goldBars = gamePage.getAllBarsAsList();
        resultAsString = BrowserUtils.webElementsList_toStringList(goldBars);
    }

    @When("user writes {string} in {string} bowl grid")
    public void user_writes_in_bowl_grid(String amountOfBars, String leftOrRight) {
        List<WebElement> threeBoxesAsList;
        switch (leftOrRight) {
            case "left":

                if (amountOfBars.equals("first three gold bars numbers")) {
                    threeBoxesAsList = gamePage.getThreeBoxesAsList(leftOrRight);

                    for (int i = 0; i < 3; i++) {
                        threeBoxesAsList.get(i).sendKeys(resultAsString.get(i));
                    }

                }
                if (amountOfBars.equals("first gold bar number")) {
                    gamePage.firstLeftBox.sendKeys(resultAsString.get(0));

                }

                break;

            case "right":
                if (amountOfBars.equals("second three gold bars numbers")) {
                    threeBoxesAsList = gamePage.getThreeBoxesAsList(leftOrRight);

                    for (int i = 0, j = 3; i < 3; i++, j++) {
                        threeBoxesAsList.get(i).sendKeys(resultAsString.get(j));
                    }

                }

                if (amountOfBars.equals("second gold bar number")) {
                    gamePage.firstRightBox.sendKeys(resultAsString.get(1));
                }

        }

    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) throws InterruptedException {

        gamePage.clickOnButton(button);
        Thread.sleep(2000);

    }

    @Then("user should see which side weighs more or less or the same")
    public void user_should_see_which_side_weighs_more_or_less_or_the_same() {
        String numberAsString;
        List<String> temp;

        switch (gamePage.resultButton.getText()) {

            case ">":
                temp = new ArrayList<>();
                for (WebElement element : gamePage.getThreeBoxesAsList("left")) {
                    numberAsString = element.getAttribute("value");
                    temp.add(numberAsString);
                }
                resultAsString.retainAll(temp);

                break;

            case "<":
                temp = new ArrayList<>();
                for (WebElement element : gamePage.getThreeBoxesAsList("right")) {
                    numberAsString = element.getAttribute("value");
                    temp.add(numberAsString);
                }
                resultAsString.retainAll(temp);

                break;
            case "=":
                temp = new ArrayList<>();
                if (gamePage.resultList.size() == 1) {
                    for (int i = 6; i < goldBars.size(); i++) {
                        temp.add(goldBars.get(i).getText());
                    }
                    resultAsString.retainAll(temp);
                } else {
                    resultAsString.remove(0);
                    resultAsString.remove(0);
                }


        }
        System.out.println("result = " + resultAsString);

    }

    @Then("user now selects number corresponding to the fake gold")
    public void user_now_selects_number_corresponding_to_the_fake_gold() throws InterruptedException {

        for (WebElement goldBar : goldBars) {
            if (goldBar.getText().equals(resultAsString.get(0))) {
                System.out.println("goldBar.getText() = " + goldBar.getText());
                goldBar.click();
                break;
            }
        }
        Thread.sleep(2000);


    }

    @Then("user sees an alert {string}")
    public void user_sees_an_alert(String expectedAlertMessage) {
        Alert alert = Driver.getDriver().switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println("actualAlertText = " + actualAlertText);
        Assert.assertEquals(expectedAlertMessage, actualAlertText);
        alert.accept();
        Driver.getDriver().switchTo().defaultContent();


    }


}
