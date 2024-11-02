# language: pt
Funcionalidade: registro de sensor de Qualidade do Ar
  Como usuário da APi
  Quero registrar um dado do sensor de Qualidade do Ar
  Para que fique salvo no sistema

  Cenario: registro de sensor Qualidade do Ar
    Dado que eu tenha o seguinte dado do sensor de Qualidade do Ar
      |  campo | valor|
      | ar |  60  |
    Quando eu enviar a requisição para o endpoint de Qualidade do Ar "/api/qldar/add" de registro
    Entao o status code de resposta de qualidade do ar deve ser o 201

  Cenario: Registro do sensor de Qualidade do Ar com dados incorretos
    Dado que eu tenha o seguinte dado do sensor de Qualidade do Ar
      |   campo | valor|
      | ar |  100 |
      |   data  | 20-10-20222 |
    Quando eu enviar a requisição para o endpoint de Qualidade do Ar "/api/qldar/add" de registro
    Entao O status code de resposta de qualidade do ar deve ser 400