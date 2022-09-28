package integration.factory.funcs;

import integration.factory.pages.HomePage;
import integration.factory.web.common.BaseTest;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeFunc extends BaseTest {

    HomePage homePage = new HomePage(driver);

    public void acessoSite(){
        driver.get("https://advantageonlineshopping.com/#/");
    }

    public void clicarSpecialOffer(){
      homePage.getButtonSeeOffer().isDisplayed();
      homePage.getButtonSpecialOffer().click();
    }

    public void clicarSeeOffer()  {
        homePage.getButtonSeeOffer().isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getButtonSeeOffer()));
        homePage.getButtonSeeOffer().click();

    }
    /*
    Realiza a pesquisa do produto buscando os dados no banco de dados
     */
    public void pesquisaLupa(String produto) throws InterruptedException {
        homePage.getLupaButton().isEnabled();
        homePage.getLupaButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getInputPesquisa()));
        homePage.getInputPesquisa().sendKeys(produto + "  ");
        Thread.sleep(5000);
        homePage.getBtnProdutoPesquisado().click();
    }

}