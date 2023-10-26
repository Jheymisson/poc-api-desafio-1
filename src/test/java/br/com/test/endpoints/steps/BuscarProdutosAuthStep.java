package br.com.test.endpoints.steps;

import br.com.test.endpoints.actions.BuscarProdutosActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class BuscarProdutosAuthStep {

    BuscarProdutosActions buscarProdutosActions;

    public BuscarProdutosAuthStep() {
        buscarProdutosActions = new BuscarProdutosActions();
    }

    @Dado("que acesso o servico de Buscar Produtos com autenticacao")
    public void acessoServicoBuscarProdutosComAutenticacao() {
        buscarProdutosActions.acessarServicoBuscarProdutosAuth();
    }

    @Quando("executo o serviço de Buscar Produtos com autenticacao")
    public void executoServicoBuscarProdutosComAutenticacao() throws IOException {
        buscarProdutosActions.executarServicoBuscarProdutosAuth();
    }

    @Então("valido a exibicao dos dados de produtos do serviço de Buscar Produtos com autenticacao {string}, {string}, {string}, {string} e {string}")
    public void validoExibicaoProdutosdoServiçoDeBuscarProdutosComAutenticacao(String produto1, String produto2, String produto3, String produto4, String produto5) {
        buscarProdutosActions.validarDadosDosProdutos(produto1, produto2, produto3, produto4, produto5);
    }

    @E("valido o contrato do servico de Buscar todos os Produtos com autenticacao")
    public void validoContratoServicoBuscarTodosOsProdutosComAutenticacao() {
        buscarProdutosActions.validarContratoDoServicoBuscarProdutos();
    }

}
