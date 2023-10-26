#language:pt

@BuscarProdutos
Funcionalidade: Produtos

  @BuscarProdutosPorID
  Cenario: Buscar produtos por ID
    Dado que acesso o servico de Buscar Produto por ID "5"
    Quando executo o serviço de Buscar Produto com o ID
    Entao valido a exibicao dos dados de produtos do serviço de Buscar Produto por ID "5", "Huawei P30", "499", "10.58", "32" e "Huawei"
    E valido o contrato do servico de Buscar Produto por ID

