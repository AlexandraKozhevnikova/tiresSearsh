package Steps;

import Test.PageObject.Dimension;
import Test.PageObject.SelectionOfTiresPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class ActionStep {

    private SelectionOfTiresPage page;

    public ActionStep(WebDriver driver) {
        page = new SelectionOfTiresPage(driver);
    }

    public void bypassProtection(String string){
        page.getTextFromPictures().sendKeys(string);
    }


    @Step
    public void goToSearchTiresPage() {
        page.openTiresPage();
    }

    @Step
    public void clickWidthButton() {
        page.clickDimensionButton(Dimension.WIDTH);
    }



//    @Step
//    public void testTest(){
//        page.testTestTest();
//    }


}
