package integration.factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[text()='SPECIAL OFFER']")
    private WebElement specialOfferButton;

    @FindBy(xpath = "//button[text()='SEE OFFER']")
    private WebElement seeOfferButton;

    @FindBy(xpath = "//a[@title='SEARCH']//*[name()='svg']")
    private WebElement lupaButton;

    @FindBy(xpath = "//input[@id='autoComplete']")
    private  WebElement inputPesquisa;

    @FindBy(xpath = "//p[@class='roboto-regular ng-binding']")
    private  WebElement btnProdutoPesquisado;

    public WebElement getButtonSpecialOffer() {
        return specialOfferButton;
    }

    public WebElement getButtonSeeOffer() {
        return seeOfferButton;
    }

    public WebElement getLupaButton() { return lupaButton;}

    public WebElement getInputPesquisa(){ return inputPesquisa;}

    public WebElement getBtnProdutoPesquisado(){ return btnProdutoPesquisado;}



}