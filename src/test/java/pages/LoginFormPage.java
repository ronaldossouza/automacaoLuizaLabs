package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{
    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    //Parametros para logar na aplicaçao
    public HomePage login(String login, String senha){
        driver.findElement(By.xpath("//*[@id=\"h_usr-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"h_usr-signin\"]")).click();
        getElement(By.name("email")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
        return new HomePage(driver);
    }
}
