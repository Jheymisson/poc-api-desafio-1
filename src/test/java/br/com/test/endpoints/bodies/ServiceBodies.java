package br.com.test.endpoints.bodies;

import java.util.HashMap;

/**
 * Classe de utilidade para criar corpos de requisição para serviços específicos.
 * Esta classe fornece funcionalidades para construir corpos de requisição em formato de mapa,
 * que são utilizados nas chamadas de serviço.
 */
public class ServiceBodies {

    /**
     * Constrói e retorna um corpo de requisição em formato de mapa para o serviço de criar produto.
     *
     * @param titulo Título do produto.
     * @param descricao Descrição detalhada do produto.
     * @param preco Preço do produto.
     * @param desc Porcentagem de desconto para o produto.
     * @param avalia Avaliação/rating do produto.
     * @param estoque Quantidade de produtos em estoque.
     * @param marca Marca associada ao produto.
     * @param categoria Categoria a qual o produto pertence.
     * @param linkimg URL da imagem (thumbnail) do produto.
     * @return Um mapa contendo o corpo da requisição formatado com os valores fornecidos.
     */
    public static HashMap<String, Object> bodyCriarProduto(String titulo, String descricao, float preco,
                                                           float desc, float avalia, int estoque,
                                                           String marca, String categoria, String linkimg) {

        HashMap<String, Object> produtoBody = new HashMap<>();
        produtoBody.put("title", titulo);
        produtoBody.put("description", descricao);
        produtoBody.put("price", preco);
        produtoBody.put("discountPercentage", desc);
        produtoBody.put("rating", avalia);
        produtoBody.put("stock", estoque);
        produtoBody.put("brand", marca);
        produtoBody.put("category", categoria);
        produtoBody.put("thumbnail", linkimg);
        return produtoBody;
    }
}
