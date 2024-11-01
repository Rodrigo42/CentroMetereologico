# Centro Metereologico

* O projeto esta em conteiner no Dockerhub também.
Segue link abaixo.

https://hub.docker.com/repository/docker/rodrigo42/cmc/general

URL Swagger: https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/swagger-ui/index.html

* Nos GETs do swagger passar body vazio.
* Para reproduzir o pipeline de CI/CD basta fazer push para a branch 'main' no github.
* A url base da api é a uri do azure + /api/endpoint/metodo exemplo https://fiap-cmc-api-dev-a0cfbcc0e4epexhb.eastus2-01.azurewebsites.net/api/chuva/listar
* Github: https://github.com/Rodrigo42/CentroMetereologico
