# language:pt
Funcionalidade:Registro de sensor de chuva
  Como usuário da API
  Quero registrar os dados de um sensor
  Para que fique salvo no sistema

  Cenario: Registro do sensor de chuva
    Dado que eu tenha o seguinte dado para registrar
      |   campo      | valor|
      | precipitacao |  43  |
    Quando eu enviar a requisição para o endpoint "/api/chuva/add" de cadastro
    Entao O status code de resposta da chuva deve ser 201

  Cenario: Registro do sensor de chuva incorretos
    Dado que eu tenha o seguinte dado para registrar
      |   campo      | valor|
      | precipitacao |  43  |
      | data | 10-10-20222 |
    Quando eu enviar a requisição para o endpoint "/api/chuva/add" de cadastro
    Entao O status code de resposta da chuva deve ser 400
    E o corpo de resposta de erro da api de chuva deve retornar a mensagem "JSON parse error: Cannot deserialize value of type `java.time.LocalDate` from String \"10-10-20222\": Failed to deserialize java.time.LocalDate: (java.time.format.DateTimeParseException) Text '10-10-20222' could not be parsed at index 0"

