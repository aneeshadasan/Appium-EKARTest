package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EkarDemoPage extends BasePage {

    public EkarDemoPage(WebDriver driver) {
        super(driver);
    }

    private static String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";

    By btnWhileUsingApp = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    //By loc = By.className("android.view.View");
    By loc = By.xpath("//*[@class='android.view.View'][@content-desc='Google Map']");
    By frontSideImg = By.id("in.testdemo.map:id/front_img");
    By backSideImg = By.id("in.testdemo.map:id/back_img");
    By leftSideImg = By.id("in.testdemo.map:id/left_img");
    By rightSideImg = By.id("in.testdemo.map:id/right_img");
    By txtComment = By.id("in.testdemo.map:id/cmd_txt");
    By btnNext = By.id("in.testdemo.map:id/next_btn");

    //Chosse Image
    By choseFromGallery = By.xpath("//android.widget.ListView/android.widget.TextView[1]");
    By captureFromCamera = By.xpath("//android.widget.ListView/android.widget.TextView[2]");
    //CaptureFrom Camera
    By cameraCenterbtn = By.id("com.sec.android.app.camera:id/normal_center_button");
    By cameraOK = By.className("android.widget.Button");
    By warningMsg = By.className("android.widget.Toast");

    public void whenISelectLocation() throws InterruptedException {
        Thread.sleep(5000);
        clickon(loc);

    }

    public void uploadImage(By element) {
        clickon(element);
        clickon(captureFromCamera);
        clickon(cameraCenterbtn);
        clickon(getElements(cameraOK).get(1));
    }

    public void enterCommentsAndSubmit() {
        getElement(txtComment).sendKeys("Comments Entered");
        attemptToScrollIntoView(btnNext);
        clickon(btnNext);
    }

    public void uploadAllImagesFromCamera() {
        uploadImage(frontSideImg);
        uploadImage(backSideImg);
        uploadImage(leftSideImg);
        uploadImage(rightSideImg);
    }
    public void uploadImagesFromCamera() {
        uploadImage(frontSideImg);
      //  uploadImage(backSideImg);
        //uploadImage(leftSideImg);

    }

    public void thenIVerifyWarningMessageisDisaplayed()
    {
        Assertions.assertEquals(true, getElement(btnNext).isDisplayed(),"Complaint Not accepted as all the Images are not Uploaded ");
    }

    public void thenIVerifyComplaintAcceptedMessage()
    {
        Assertions.assertEquals(true, getElement(loc).isDisplayed()," Image Upload Complete");
    }

}
