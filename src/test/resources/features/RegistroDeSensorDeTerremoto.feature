# language: pt
  Funcionalidade: registro de sensor de terremoto
    Como usuário da APi
    Quero registrar um dado do sensor de terremoto
    Para que fique salvo no sistema

    Cenario: registro de sensor terremoto
      Dado que eu tenha o seguinte dado do sensor de terremoto
        |  campo | valor|
        | sismico |  3  |
      Quando eu enviar a requisição para o endpoint de terremoto "/api/terremoto/add" de registro
      Entao O status code de resposta do terremoto deve ser 201
      E que o arquivo de contrato esperado é o "contrato-terremoto"
      Então a resposta da requisição deve estar em conformidade com o contrato selecionado

    Cenario: Registro do sensor de terremoto com dados incorretos
      Dado que eu tenha o seguinte dado do sensor de terremoto
        |   campo | valor|
        | sismico |  100 |
        |   data  | 20-10-20222 |
      Quando eu enviar a requisição para o endpoint de terremoto "/api/terremoto/add" de registro
      Entao O status code de resposta do terremoto deve ser 400