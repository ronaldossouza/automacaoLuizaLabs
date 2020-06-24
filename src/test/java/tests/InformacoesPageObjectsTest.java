package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.web;

public class InformacoesPageObjectsTest {
    private WebDriver driver;
    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        driver = web.createChrome();
    }
    @Test
    public void deveSerPossivelPesquisarEInserirProdutoNaSacola() throws InterruptedException {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.search();
        searchPage.pesquisaProduto("iPhone 11 Pro Apple 64GB Cinza Espacial 4G - Tela 5,8” Retina Câmera Tripla 12MP + Selfie 12MP");
        searchPage.selecionaProduto();
        searchPage.addProdutoNaSacola();
        searchPage.voltaParaPaginaInicial();

        String itemsBag = searchPage.validaSetemItensNaSacola();
        Integer itemCount = Integer.parseInt(itemsBag.split(" ")[0]);
        Assert.assertEquals(1L, itemCount.longValue());


        Assert.assertEquals("iPhone 11 Pro Apple 64GB Cinza Espacial 4G - Tela 5,8” Retina Câmera Tripla 12MP + Selfie 12MP", searchPage.comparaItem());

        //Tira screenshot da tela da sacola
        String screenshotArquivo = "C:\\Users\\ronaldo.silva\\Pictures\\Evidencias"
                + Generator.dataHoraParaArquivo() + test.getMethodName() +".png";
        Screenshot.tirar(driver,screenshotArquivo );
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}