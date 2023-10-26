package br.com.test.endpoints.utils;

import br.com.test.configuration.EndpointConfigurations;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.Before;

import java.io.IOException;

/**
 * Classe responsável por gerenciar as ações relacionadas a chamadas REST.
 * Ela armazena a especificação da requisição e a resposta recebida após a execução da chamada REST.
 */
public class RestStep {

    // Especificação da requisição a ser realizada.
    private RequestSpecification request;

    // Resposta obtida após a execução da chamada REST.
    private Response response;

    /**
     * Define a especificação da requisição.
     *
     * @param request Especificação da requisição.
     */
    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    /**
     * Define a resposta obtida após a execução da chamada REST.
     *
     * @param response Resposta da chamada.
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * Obtém a especificação da requisição atual.
     *
     * @return Especificação da requisição.
     */
    public RequestSpecification getRequest() {
        return request;
    }

    /**
     * Obtém a resposta da chamada REST atual.
     *
     * @return Resposta da chamada.
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Configurações iniciais a serem executadas antes de qualquer chamada REST.
     * Reinicializa as configurações do RestAssured e define a URI base.
     *
     * @throws IOException Caso haja problemas ao configurar os endpoints.
     */
    @Before
    public static void setUPInicial() throws IOException {
        new EndpointConfigurations();
        RestAssured.reset();
        RestAssured.baseURI = System.getProperty("cob.ambiente");
    }
}