package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EKarTest extends BaseTest {

    @Test
    @DisplayName("Ekar App Test : To Verify that the  User is able to upload 4 Images and Proceed. ")
    public void TestOne()
    {
        try {
            ekarDemoPage.whenISelectLocation();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ekarDemoPage.uploadAllImagesFromCamera();
        ekarDemoPage.enterCommentsAndSubmit();
        ekarDemoPage.thenIVerifyComplaintAcceptedMessage();
    }

    @Test
    @DisplayName("Ekar App Test :  To verify that the User is  not be able to proceed if he failed to upload all the  images")
    public void TestTwo()
    {
        try {
            ekarDemoPage.whenISelectLocation();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ekarDemoPage.uploadImagesFromCamera();
        ekarDemoPage.enterCommentsAndSubmit();
        ekarDemoPage.thenIVerifyWarningMessageisDisaplayed();

    }



}
