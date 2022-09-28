package integration.factory.steps;


import integration.factory.database.DBConfig;
import integration.factory.funcs.HomeFunc;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.sql.SQLException;


public class HomeStep {

    HomeFunc homeFunc = new HomeFunc();
    DBConfig dbConfig = new DBConfig();


    @Dado("que eu acesse o site")
    public void queEuAcesseOSite() {
        homeFunc.acessoSite();
    }

    @Dado("tenha pesquisado o produto no icone da lupa conforme o banco de dados")
    public void tenhaPesquisadoOProdutoNoIconeDaLupaConformeOBancoDeDados() throws SQLException, ClassNotFoundException, InterruptedException {
        String nomeProduto = dbConfig.validaCampos().get("nameProduct");
        homeFunc.pesquisaLupa(nomeProduto);
    }
    @Quando("clicar em Special Offer")
    public void clicarEmSpecialOffer() {
        homeFunc.clicarSpecialOffer();
    }
    @Quando("clicar em See offer")
    public void clicarEmSeeOffer() {
        homeFunc.clicarSeeOffer();
    }


}
