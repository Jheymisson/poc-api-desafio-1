package br.com.test.endpoints.actions;

import br.com.test.authentication.Token;
import br.com.test.configuration.EndpointConfigurations;
import br.com.test.endpoints.utils.RestStep;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static br.com.test.configuration.TipoConexaoEnum.*;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

/**
 * Ação para buscar produtos. Esta classe define os métodos para interagir com o serviço de busca de produtos.
 */
public class BuscarProdutosActions {

    // Atributo para representar as etapas da requisição e resposta REST.
    private RestStep restStep;

    /**
     * Construtor padrão. Inicializa a etapa de REST.
     */
    public BuscarProdutosActions() {
        restStep = new RestStep();
    }

    /**
     * Define a requisição para acessar o serviço de busca de produtos autenticados.
     * A requisição inclui detalhes como tipo de conteúdo e cabeçalho de autorização.
     */
    public void acessarServicoBuscarProdutosAuth() {
        restStep.setRequest(given().log().all()
                .contentType(ContentType.JSON.withCharset("UTF-8"))
                .header("Authorization", "Bearer " + Token.getTokenGerado()));
    }

    /**
     * Executa a requisição para buscar produtos autenticados.
     * @throws IOException caso ocorra um erro ao executar a requisição.
     */
    public void executarServicoBuscarProdutosAuth() throws IOException {
        restStep.setResponse(restStep
                .getRequest()
                .when().log().all()
                .get(EndpointConfigurations.getUrlApi(SICRED_BUSCAR_PRODUTOS_AUTENTICADO)));
    }

    /**
     * Define a requisição para acessar o serviço de busca de produtos sem autenticacão.
     * A requisição inclui detalhes como tipo de conteúdo.
     */
    public void acessarServicoBuscarProdutos() {
        restStep.setRequest(given().log().all()
                .contentType(ContentType.JSON.withCharset("UTF-8")));
    }

    /**
     * Executa a requisição para buscar produtos sem autenticacão.
     * @throws IOException caso ocorra um erro ao executar a requisição.
     */
    public void executarServicoBuscarProdutos() throws IOException {
        restStep.setResponse(restStep
                .getRequest()
                .when().log().all()
                .get(EndpointConfigurations.getUrlApi(SICRED_BUSCAR_PRODUTOS_SEM_AUTENTICACAO)));
    }

    /**
     * Valida os dados dos produtos na resposta do serviço.
     * @param produto1 Nome do primeiro produto.
     * @param produto2 Nome do segundo produto.
     * @param produto3 Nome do terceiro produto.
     * @param produto4 Nome do quarto produto.
     * @param produto5 Nome do quinto produto.
     */
    public void validarDadosDosProdutos(String produto1, String produto2, String produto3, String produto4, String produto5) {
        Response response = restStep.getResponse();
        response.then().statusCode(200);
        String responseBody = response.getBody().asString();
        List<String> valuesToCheck = Arrays.asList(produto1, produto2, produto3, produto4, produto5);

        for (String value : valuesToCheck) {
            Assert.assertTrue("Resposta do erro: " + value, responseBody.contains(value));
        }
    }


    /**
     * Valida o contrato da resposta do serviço de busca de produtos.
     * Esta validação usa um esquema JSON para verificar se a resposta está no formato esperado.
     */
    public void validarContratoDoServicoBuscarProdutos() {
        Response response = restStep.getResponse();
        String schemaPath = "schemas/BuscarProdutosAuthSchema.json";
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

    /**
     * Configura e executa uma solicitação para acessar o serviço de Buscar Produto por ID.
     *
     * @param id O ID do produto que deseja buscar.
     */
    public void acessarServicoBuscarProdutoID(String id) {
        restStep.setRequest(given()
                .log().all()
                .pathParam("id", id)
                .contentType(ContentType.JSON.withCharset("UTF-8")));
    }

    /**
     * Executa o serviço de Buscar Produto por ID.
     *
     * <p>A URL do serviço é obtida a partir da classe de configurações {@code EndpointConfigurations}.
     * O resultado da solicitação é armazenado para validações posteriores.</p>
     *
     * @throws IOException Caso haja problemas ao obter a URL do serviço.
     */
    public void executarServicoBuscarProdutoID() throws IOException {
        restStep.setResponse(restStep
                .getRequest()
                .when()
                .get(EndpointConfigurations.getUrlApi(SICRED_BUSCAR_PRODUTOS_COM_ID)));
    }

    /**
     * Valida os dados retornados pelo serviço de Buscar Produto por ID.
     *
     * @param ID       O ID esperado do produto.
     * @param nome     O nome esperado do produto.
     * @param preco    O preço esperado do produto.
     * @param desconto O desconto esperado do produto.
     * @param estoque  A quantidade em estoque esperada do produto.
     * @param marca    A marca esperada do produto.
     */
    public void validarDadosDoProdutoPorID(String ID, String nome, String preco, String desconto, String estoque, String marca) {
        Response response = restStep.getResponse();
        JsonPath jsonPath = response.jsonPath();
        assertEquals("Validação do ID falhou", ID, jsonPath.getString("id"));
        assertEquals("Validação do nome falhou", nome, jsonPath.getString("title"));
        assertEquals("Validação do preco falhou", preco, jsonPath.getString("price"));
        assertEquals("Validação do desconto falhou", desconto, jsonPath.getString("discountPercentage"));
        assertEquals("Validação do estoque falhou", estoque, jsonPath.getString("stock"));
        assertEquals("Validação do marca falhou", marca, jsonPath.getString("brand"));
    }

    /**
     * Valida o contrato do serviço de Buscar Produto por ID.
     *
     * <p>Este método utiliza um arquivo de esquema JSON localizado no classpath para validar
     * a estrutura do JSON retornado pelo serviço. Assumimos que o esquema está correto e reflete
     * as expectativas para a resposta do serviço.</p>
     */
    public void validarContratoDoServicoBuscarProdutoID() {
        Response response = restStep.getResponse();
        String schemaPath = "schemas/BuscarProdutoIDSchema.json";
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

}

