package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public SearchPage irparaSearchPage() throws InterruptedException {
        driver.findElement(By.id("h_search-btn")).click();
        Thread.sleep(1000);
        return new SearchPage(driver);
    }
}
