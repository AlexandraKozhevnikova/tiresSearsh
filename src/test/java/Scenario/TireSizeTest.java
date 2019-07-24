package Scenario;

import Steps.ActionStep;
import Steps.AssertionStep;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

@DisplayName("Блок размеров шин")
public class TireSizeTest {

    private WebDriver driver;
    private ActionStep actionStep;
    private AssertionStep assertionStep;

    @Before

    public void prepare() {
        driver = new ChromeDriver();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        actionStep.goToSearchTiresPage();
        System.out.println("-------------------------------------------------------------\nПодготовка к запустку теста прошла успешна, драйвер стартанул");
        if (driver.getTitle().contains("Ой")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите значение с картинок: ");
            String string = in.nextLine();
            in.close();
            actionStep.bypassProtection(string);
        }

    }



    @Test
    @Flaky
    @DisplayName("Кликабельность выпадшки для ширны шины")
    @Issue("1")
    public void widthClickability() {
        assertionStep.hiddenWidthMenuItems();
        actionStep.clickWidthButton();
        assertionStep.notEmptyWidthMenuItems();
        assertionStep.checkContentWidthMenuItems();
        actionStep.clickWidthButton();
        assertionStep.hiddenWidthMenuItems();
    }

    @Test
    @DisplayName("Выбор ширины шины")
    @Description("Выбор значения ширины шины, сброс, перевыбор, запоминание значения после обновления страницы")
    public void selectWidth() {
        assertionStep.hiddenWidthMenuItems();
        actionStep.clickWidthButton();
        assertionStep.selectedValueIsInTheField("130");
    }


    @Ignore
    @Test
    @DisplayName("Кликабельность поля выборы Высоты шины")
    public void heightClickability() {
//Допишу позже
    }


    @After
    public void remove() {
        driver.quit();
        System.out.println("Тест был запущен\nДрайвер закрыт\n-------------------------------------------------------------");
    }
}
