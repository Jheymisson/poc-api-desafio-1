#language:pt

@BuscarProdutos
Funcionalidade: Produtos

  @BuscarProdutosSemAutenticacao
  Cenario: Buscar produtos sem informar token de autenticacao
    Dado que acesso o servico de Buscar Produtos sem autenticacao
    Quando executo o serviço de Buscar Produtos sem autenticacao
    Entao valido a exibicao dos dados de produtos do serviço de Buscar Produtos sem autenticacao "iPhone 9", "iPhone X", "Samsung Universe 9", "OPPOF19" e "Huawei P30"
    E valido o contrato do servico de Buscar todos os Produtos sem autenticacao
