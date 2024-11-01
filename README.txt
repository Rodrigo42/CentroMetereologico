# Centro Metereologico

* O projeto esta em conteiner no Dockerhub também.
Segue link abaixo.

https://hub.docker.com/repository/docker/rodrigo42/cmc/general

URL Swagger: https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/swagger-ui/index.html

* Nos GETs do swagger passar body vazio.
* Para reproduzir o pipeline de CI/CD basta fazer push para a branch 'main' no github.
* A url base da api é a uri do azure + /api/endpoint/metodo exemplo https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/api/chuva/listar
* Github: https://github.com/Rodrigo42/CentroMetereologico

* Testes
    * Os testes são executados em pipeline do github actions. Após um push acontece um actions de deploy, após o deploy
    acontece um actions de continuous integration que realiza os testes do cucumber. Tenho testes unitarios do Java/Junit
    que não consegui incluir na automação mas estão na pasta src/test/java/br/com/fiap/test
    Link do Github