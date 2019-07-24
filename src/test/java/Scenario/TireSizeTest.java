package Scenario;

import Steps.ActionStep;
import Steps.AssertionStep;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

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
    public void widthClickability() {
        assertionStep.hiddenWidthMenuItems();
        actionStep.clickWidthButton();
        assertionStep.notEmptyWidthMenuItems();
        assertionStep.checkContentWidthMenuItems();
        actionStep.clickWidthButton();
        assertionStep.hiddenWidthMenuItems();
    }

    @Test
    public void selectWidth() {
        assertionStep.hiddenWidthMenuItems();
        actionStep.clickWidthButton();
        assertionStep.selectedValueIsInTheField("130");
    }


    @Ignore
    @Test
    public void heightClickability() {
//Допишу позже
    }


    @After
    public void remove() {
        driver.quit();
        System.out.println("Тест был запущен\nДрайвер закрыт\n-------------------------------------------------------------");
    }
}
