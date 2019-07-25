package Steps;

import Test.PageObject.SelectionOfTiresPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertionStep {

    private SelectionOfTiresPage page;

    public AssertionStep(WebDriver driver) {
        page = new SelectionOfTiresPage(driver);
    }


    @Step("Выпадашка \"Ширина, мм\" не пустая")
    public void notEmptyWidthMenuItems() {
        assertThat(page.getWidthMenuItems(), is(not(empty())));

    }

    @Step("Проверка соответсвия списка ширин шин")
    public void checkContentWidthMenuItems() {
        List<String> listActual = page.getTextFromListWebElements(page.getWidthMenuItems());
        listActual.set(0, "cross");

        String stringExpected = page.getStringFromProperty("SetOfTiresWidth");
        String[] arrayExpected = stringExpected.split(", ");
        assertThat(listActual, equalTo(Arrays.asList(arrayExpected)));
    }

    @Step("Проверка, что выпадашка ширин отсутсвует на странице")
    public void hiddenWidthMenuItems() {
        assertThat(page.getWidthMenuItems(), empty());
    }

    @Step("Значение ширины шины {0}")
    public void selectedValueIsInTheField(String value) {
        page.selectItemOfList(page.getWidthMenuItems(), value);
        assertThat(page.getWidthButton().getText(), equalTo(value));
    }


}
