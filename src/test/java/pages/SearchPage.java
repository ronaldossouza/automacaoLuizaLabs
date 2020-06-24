package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends BasePage{

    String itemCountSpan = "/html/body/div[2]/div[2]/div[1]/div[1]/header/div/div[1]/div/div/div[2]/div[1]/div[4]/div/div[1]/span";
    String validaItemNaSacola = "//p[text()='iPhone 11 Pro Apple 64GB Cinza Espacial 4G - Tela 5,8” Retina Câmera Tripla 12MP + Selfie 12MP ']/descendant-or-self::p";
    String clicaNaSacola = "/html/body/div[2]/div[2]/div[1]/div[1]/header/div/div[1]/div/div/div[2]/div[1]/a[1]/div/i";
    String clicaNaSacola2 = "/html/body/div[2]/div[2]/div[1]/div[1]/header/div/div[1]/div/div/div[2]/div[1]/a[1]/div";
    String cliqueVoltarParaHome = "//*[@id=\"root\"]/div/div[1]/div/div[1]/div/a";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search() {
        driver.findElement(By.id("btnHeaderSearch")).click();
        driver.findElement(By.cssSelector(".content-search")).click();
        driver.findElement(By.id("inpHeaderSearch")).click();
    }
    public void pesquisaProduto(String pesquisa) {
        driver.findElement(By.id("inpHeaderSearch")).sendKeys(pesquisa);
        driver.findElement(By.id("btnHeaderSearch")).click();
    }
    public void selecionaProduto() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");

        String text = getElement(By.xpath("//*[@id=\"product_155562400\"]/div[3]/h2")).getText();

        if(text.contains("iPhone 11 Pro Apple 64GB Cinza Espacial 4G")){
            getElement(By.xpath("//*[@id=\"product_155562400\"]/div[3]/h2")).click();
        }else {
            System.out.println("Item não encontrado!");
        }
    }
    public void addProdutoNaSacola() {
        driver.findElement(By.cssSelector(".button__buy-product-detail > .button__icon")).click();
    }
    public void  voltaParaPaginaInicial() {
        driver.findElement(By.xpath(cliqueVoltarParaHome)).click();
    }
    public String validaSetemItensNaSacola() throws InterruptedException {

        //Função para sobre por o mouse no menu da sacola para que o item esteja visivel
        Actions builder = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(clicaNaSacola2));
        builder.moveToElement(we).perform();
        Thread.sleep(3000);
        return getElement(By.xpath(itemCountSpan)).getText();

    }
    public String comparaItem() throws InterruptedException {
        driver.findElement(By.xpath(clicaNaSacola)).click();
        Thread.sleep(5000);
        return getElement(By.xpath(validaItemNaSacola)).getText();
    }
}


