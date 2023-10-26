#language:pt

@Usuarios
Funcionalidade: Usuarios

  @BuscarUsuariosJaCadastrado
  Esquema do Cenario: Buscar Usuarios já cadastrados no sistema
    Dado que acesso o servico de Buscar Usuarios já cadastrados
    Quando executo o serviço de Buscar Usuarios
    Entao valido a exibicao dos dados <firstName>, <lastName>, <maidenName>, <age>, <gender>, <email>, <phone>, <username>, <password> e <birthDate>
    E valido o contrato do servico de Buscar Usuarios

    Exemplos:
      | firstName  | lastName   | age  | maidenName | gender | email              | phone               | username  | password    | birthDate    |
      | "Alison"   | "Reichert" | "21" | "Yundt"    | "male" | "kmeus4@upenn.edu" | "+372 285 771 1911" | "kmeus4"  | "aUTdmmmbH" | "1968-11-03" |


  @BuscarUsuariosNaoCadastrado
  Cenario: Buscar Usuarios já cadastrados no sistema
    Dado que acesso o servico de Buscar Usuarios já cadastrados
    Quando executo o serviço de Buscar Usuarios
    Entao valido que não existe o usuário "JoaquimSicred"

