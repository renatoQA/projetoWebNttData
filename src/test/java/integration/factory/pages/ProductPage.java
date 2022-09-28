package integration.factory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[text()='ADD TO CART']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[text()='SEE OFFER']")
    private WebElement seeOfferButton;

    @FindBy(xpath = "//h1[@class='roboto-regular screen768 ng-binding']")
    private WebElement nomeProduto;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='Simplicity']")
    private WebElement customization;

    @FindBy(xpath = "//label[contains(text(),'15.6-inch diagonal Full HD WLED-backlit Display (1')]")
    private WebElement display;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='1920x1080']")
    private WebElement displayResolution;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='15.6']")
    private WebElement displaySize;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='16GB DDR3 - 2 DIMM']")
    private WebElement memory;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='Windows 10']")
    private WebElement operatingSystem;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='AMD Quad-Core A10-8700P Processor + AMD Radeon(TM) R6 Graphics']")
    private WebElement processor;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='Yes']")
    private WebElement touchscreen;

    @FindBy(xpath = "//label[@class='value ng-binding'][text()='5.51 lb']")
    private WebElement weight;

    @FindBy(xpath = "//span[@title='BLUE'][@id='bunny']")
    private WebElement colorBlue;

    @FindBy(xpath = "//span[@title='BLACK'][@id='bunny']")
    private WebElement colorBlack;

    @FindBy(xpath = "//span[@title='GRAY'][@id='bunny']")
    private WebElement colorGray;

    @FindBy(xpath = "//span[@title='PURPLE'][@id='bunny']")
    private WebElement colorPurple;

    @FindBy(xpath = "//span[@title='RED'][@id='bunny']")
    private WebElement colorRed;

    @FindBy(xpath = "//span[@title='YELLOW'][@id='bunny']")
    private WebElement colorYellow;

    @FindBy(xpath = "(//label[contains(@class,'ng-binding')]/span[@class='ng-binding'])[1]")
    private WebElement corSelecionada;

    @FindBy(xpath = "//a[@id='shoppingCartLink']//span[@class='cart ng-binding'][normalize-space()='1']")
    private WebElement carrinhoAddProduto;

    @FindBy(xpath = "//div[@class='plus']")
    private WebElement btnMaisQuantidade;

    @FindBy(xpath = "//button[@id='checkOutPopUp']")
    private WebElement btnPopUpFinalize;

    @FindBy(xpath = "//label[@class='roboto-regular ng-binding']")
    private WebElement btnQuantidadeValidator;

    @FindBy(xpath = "//body/div[@class='uiview ng-scope']/section[@class='ng-scope']/article[contains(@class,'max-width')]/div[@id='product_2']/div[@id='Description']/h2[1]")
    private WebElement btnValorDaUnidade;

    @FindBy(xpath = "//*[@id='shoppingCart']/table/tbody/tr/td[5]/label[2]")
    private WebElement btnQuantidadeTotalModal;

    @FindBy(xpath = "//a[@id='shoppingCartLink']")
    private WebElement btnShoppingCart;

    @FindBy(xpath = "//span[@class='roboto-medium totalValue ng-binding']")
    private WebElement spanValorTotal;

    @FindBy(xpath = "//button[@data-ng-click='checkout()' ]")
    private WebElement btnCheckout;

    @FindBy(xpath = "(//div[@class='removeProduct iconCss iconX'])[1]")
    private WebElement btnRemoveProduct;

    @FindBy(xpath = "//label[@class='center roboto-medium ng-scope']")
    private WebElement messagemCarrinhoVazio;


    public WebElement getCor(String cor){
        if(cor.equals("GRAY")){
            return colorBlack;
        }if (cor.equals("BLACK")){
            return colorBlue;
        }if (cor.equals("BLUE")){
            return colorRed;
        }if (cor.equals("RED")){
            return colorPurple;
        }if (cor.equals("PURPLE")){
            return colorYellow;
        }if (cor.equals("YELLOW")){
            return colorGray;
        }else {
            return null;
        }
    }

    public WebElement getCorIgual(String cor){
        if(cor.equals("GRAY")){
            return colorGray;
        }if (cor.equals("BLACK")){
            return colorBlack;
        }if (cor.equals("BLUE")){
            return colorBlue;
        }if (cor.equals("RED")){
            return colorRed;
        }if (cor.equals("PURPLE")){
            return colorPurple;
        }if (cor.equals("YELLOW")){
            return colorYellow;
        }else {
            return null;
        }
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getButtonSeeOffer() {
        return seeOfferButton;
    }

    public WebElement getNomeProduto() { return  nomeProduto;}

    public WebElement getCustomization() { return  customization;}

    public WebElement getDisplay() { return  display;}

    public WebElement getDisplayResolution() { return  displayResolution;}

    public WebElement getDisplaySize() { return  displaySize;}

    public WebElement getMemory() { return  memory;}

    public WebElement getOperatingSystem() { return  operatingSystem;}

    public WebElement getProcessor() { return  processor;}

    public WebElement getTouchscreen() { return  touchscreen;}

    public WebElement getWeight() { return  weight;}

    public WebElement getColorBlue() { return  colorBlue;}

    public WebElement getColorBlack() { return  colorBlack;}

    public WebElement getColorGray() { return  colorGray;}

    public WebElement getColorPurple() { return  colorPurple;}

    public WebElement getColorRed() { return  colorRed;}

    public WebElement getColorYellow() { return  colorYellow;}

    public WebElement getValidaProdutoCarrinho(){return carrinhoAddProduto;}

    public WebElement getBtnMaisQuantidade() {
        return btnMaisQuantidade;
    }

    public WebElement getBtnPopUpFinalize(){
        return btnPopUpFinalize;
    }

    public WebElement getBtnValorDaUnidade(){ return btnValorDaUnidade;}

    public WebElement getBtnQuantidadeTotal(){ return btnQuantidadeTotalModal;}

    public WebElement getBtnShoppingCart() {
        return btnShoppingCart;
    }

    public WebElement getSpanValorTotal() {
        return spanValorTotal;
    }

    public WebElement getBtnCheckout() {
        return btnCheckout;
    }
    public WebElement getBtnRemoveProduct(){ return btnRemoveProduct;}

    public WebElement getMessagemCarrinhoVazio(){ return messagemCarrinhoVazio;}

    public WebElement getCorSelecionada(){ return corSelecionada;}
}