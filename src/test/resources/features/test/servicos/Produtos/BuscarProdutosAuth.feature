#language:pt

@BuscarProdutos
Funcionalidade: Produtos

  @BuscarProdutosComAutenticacao
  Cenario: Buscar produtos informando token de autenticacao
    Dado que acesso o servico de Buscar Produtos com autenticacao
    Quando executo o serviço de Buscar Produtos com autenticacao
    Entao valido a exibicao dos dados de produtos do serviço de Buscar Produtos com autenticacao "iPhone 9", "iPhone X", "Samsung Universe 9", "OPPOF19" e "Huawei P30"
    E valido o contrato do servico de Buscar todos os Produtos com autenticacao


#    CRIAR CENARIO SEM TOKEN