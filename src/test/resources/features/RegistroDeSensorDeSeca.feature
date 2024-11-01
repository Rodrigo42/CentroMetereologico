# language:pt
Funcionalidade:Registro de sensor de umidade
  Como usuário da API
  Quero registrar os dados de um sensor
  Para que fique salvo no sistema

  Cenario: Registro do sensor de seca
    Dado que eu tenha o seguinte dado de sensor de umidade para registrar
      |   campo | valor|
      | umidade |  32  |
    Quando eu enviar a requisição para o endpoint de umidade "/api/seca/add" de cadastro
    Entao O status code de resposta deve ser 201

  Cenario: Registro do sensor de seca com dados incorretos
    Dado que eu tenha o seguinte dado de sensor de umidade para registrar
      |   campo | valor|
      | umidade |  100 |
      |   data  | 20-10-20222 |
    Quando eu enviar a requisição para o endpoint de umidade "/api/seca/add" de cadastro
    Entao O status code de resposta deve ser 400
    E o corpo de resposta de erro da api de seca deve retornar a mensagem "JSON parse error: Cannot deserialize value of type `java.time.LocalDate` from String \"20-10-20222\": Failed to deserialize java.time.LocalDate: (java.time.format.DateTimeParseException) Text '20-10-20222' could not be parsed at index 0"

