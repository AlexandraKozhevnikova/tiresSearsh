package Test.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class SelectionOfTiresPage {

    private WebDriver driver;


    @FindBy(xpath = "//div[@class=\"WheelFiltersDims\"]/div/div/div/button/span")
    @CacheLookup
    private List<WebElement> dimensionButtonsList;


    @FindBy(css = "div.MenuItem")
    private List<WebElement> widthMenuItems;


    @FindBy(css = ".WheelFiltersDims__prop_name_tyreWidth .Button__text")
    private WebElement widthButton;

    @FindBy(id = "rep")
    private WebElement textFromPictures;

    public WebElement getTextFromPictures() {
        return textFromPictures;
    }

    public WebElement getWidthButton() {
        return widthButton;
    }

    public List<WebElement> getWidthMenuItems() {
        return widthMenuItems;
    }


    public SelectionOfTiresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public void clickDimensionButton(Dimension buttonName) {
        getElementDimension(buttonName).click();

    }

    public void openTiresPage() {
        driver.get(getStringFromProperty("SelectionOfTiresURL"));
    }

    private WebElement getElementDimension(Dimension buttonName) {
        for (WebElement element : dimensionButtonsList) {
            if (dimensionButtonsList.indexOf(element) == buttonName.getIndex()) {
                return element;
            }
        }
        return null;
    }

    public List<String> getTextFromListWebElements(List<WebElement> listWE) {
        List<String> listStr = new ArrayList<String>();
        for (WebElement element : listWE) {
            listStr.add(element.getText());
        }
        return listStr;
    }

    public String getStringFromProperty(String keyProperty) {
        Properties propertyFile = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
            propertyFile.load(fis);
        } catch (IOException e) {
            System.err.println("Не прочитан файл application.properties");
        }
        return propertyFile.getProperty(keyProperty);
    }

    public void selectItemOfList(List<WebElement> list, int index) {
        list.get(index).click();
    }

    public void selectItemOfList(List<WebElement> list, String value) {
        list.get(getTextFromListWebElements(list).indexOf(value)).click();
    }


//    public void testTestTest(){
//        System.out.println(widthMenuItems.get(2).getText());
//    }


}
