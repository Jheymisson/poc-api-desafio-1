package br.com.test.authentication;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static br.com.test.utilitarios.bodies.bodyProdutoAuth;
import static com.jayway.restassured.RestAssured.given;

/**
 * Classe responsável por gerenciar a obtenção de tokens de autenticação.
 * Esta classe fornece funcionalidades para gerar e recuperar tokens de autenticação a partir
 * de um serviço de autenticação especificado.
 */
public class Token {

	private static final String USERNAME = "kminchelle";
	private static final String PASSWORD = "0lelplR";
	private static String tokenGerado;
	private static final String AMBIENTE_SICRED = "https://dummyjson.com/auth/login";

	/**
	 * Recupera o token gerado.
	 *
	 * @return Retorna o token gerado para autenticação.
	 */
	public static String getTokenGerado() {
		geraToken();
		return tokenGerado;
	}

	/**
	 * Gera um novo token fazendo uma requisição ao serviço de autenticação.
	 */
	protected static void geraToken() {
		RequestSpecification request = createGetTokenRequest();
		tokenGerado = requestToken(request);
	}

	/**
	 * Cria a especificação de requisição para obter o token.
	 *
	 * @return Retorna a especificação de requisição com os detalhes necessários para obter o token.
	 */
	protected static RequestSpecification createGetTokenRequest() {
		return given()
				.contentType(ContentType.JSON.withCharset("UTF-8"))
				.body(bodyProdutoAuth(USERNAME, PASSWORD));
	}

	/**
	 * Realiza a requisição para obter o token.
	 *
	 * @param request Especificação da requisição preparada para obter o token.
	 * @return Retorna o token gerado pela requisição.
	 */
	protected static String requestToken(RequestSpecification request) {
		Response response = request.when().log().all().post(getUrlToken());
		JsonPath jsonPathEvaluator = response.jsonPath();
		tokenGerado = jsonPathEvaluator.get("token");
		return tokenGerado;
	}

	/**
	 * Retorna a URL do serviço de autenticação.
	 *
	 * @return Retorna a URL onde o serviço de autenticação pode ser acessado.
	 */
	private static String getUrlToken() {
		return AMBIENTE_SICRED;
	}

}

