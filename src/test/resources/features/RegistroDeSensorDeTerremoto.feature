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
      Entao o status code de resposta deve ser o 201

    Cenario: Registro do sensor de terremoto com dados incorretos
      Dado que eu tenha o seguinte dado do sensor de terremoto
        |   campo | valor|
        | sismico |  100 |
        |   data  | 20-10-20222 |
      Quando eu enviar a requisição para o endpoint de terremoto "/api/terremoto/add" de registro
      Entao O status code de resposta deve ser 400