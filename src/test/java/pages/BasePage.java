package pages;


import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }


    public WebElement getElement(By elt) {
        WebElement element = driver.findElement(elt);
        return element;
    }

    public List<WebElement> getElements(By elt) {
        List<WebElement> elements = driver.findElements(elt);
        return elements;
    }

    public void clickon(By ele) {
        WebElement element = getElement(ele);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ele));
        element.click();
    }

    public void clickon(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.click();

    }

    protected void attemptToScrollIntoView(By by) {
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.5);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y))
                .release()
                .perform();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
