# language:pt
Funcionalidade:Registro de sensor de qualidade da agua
  Como usuário da API
  Quero registrar os dados de um sensor
  Para que fique salvo no sistema
  Cenario: Registro do sensor de Qualidade da Agua
    Dado que eu tenha o seguinte dado de sensor qualidade da agua  para registrar
      |  campo | valor|
      | agua   |  64  |
    Quando eu enviar a requisição para o endpoint de qualidade da agua "/api/qldagua/add" de cadastro
    Entao O status code de resposta da qualidade da agua deve ser 201


  Cenario: Registro do sensor de Qualidade da Agua incorretors
    Dado que eu tenha o seguinte dado de sensor qualidade da agua  para registrar
      |  campo | valor|
      | agua   |  64  |
      | data | 10-10-20222 |
    Quando eu enviar a requisição para o endpoint de qualidade da agua "/api/qldagua/add" de cadastro
    Entao O status code de resposta da qualidade da agua deve ser 400
    E o corpo de resposta de erro da api deve retornar a mensagem "JSON parse error: Cannot deserialize value of type `java.time.LocalDate` from String \"10-10-20222\": Failed to deserialize java.time.LocalDate: (java.time.format.DateTimeParseException) Text '10-10-20222' could not be parsed at index 0"