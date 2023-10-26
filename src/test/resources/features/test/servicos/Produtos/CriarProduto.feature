#language:pt

@Produtos
Funcionalidade: Criar Produtos

Funcionalidade: Gestão de Produtos

  @CriarProdutos
  Cenário: Criar produtos com sucesso
    Dado acesso o serviço de Criar Produtos com os dados:
      | titulo        | descricao                             | preco | desconto | avaliar | estoque | marca                 | categoria    | img                                                       |
      | "Perfume Oil" | "Mega Discount, Impression of A..."   | 8.00  | 8.26     | 4.26    | 65      | "Impression of Ac..." | "fragrances" | "https://i.dummyjson.com/data/products/11/thumbnail.jpg" |
    Quando executo o serviço de Criar Produtos
    Então o produto é criado com sucesso
    E o contrato do serviço de Criar Produtos é validado


