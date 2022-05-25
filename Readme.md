<h1 align="center">🚀 Meetups Scheduler 🚀</h1>
<p align="center">Projeto de cadastro de pessoas com score</p>

## Implementações

- [x] SWAGGER com acessos aos Endpoints
- [x] Criação de cadastro de pessoa
- [x] Trazer um pessoa por id
- [x] Listar todas as pessoas

### 🛠 Tecnologias e Dependências
* [Git](#Git)
* [Java11](#Java11)
* [Maven](#Maven)
* [Springboot2.5.13](#Springboot2.5.13)
* [JPA](#JPA)
* [Lombok](#Lombok)
* [BancoH2](#BancoH2)
* [Swagger](#Swagger) 


### Como Utilizar?
- Swagger url
```bash
- Rode o projeto localmente e build
$ Access http://localhost:8080/swagger-ui.html#/pessoa-controller/getByIdUsingGET
```


## Endpoints
### :heavy_check_mark: Adicionar uma pessoa
Input:
POST:"/pessoa"
```bash
{
	"nome": "Lorenna Lima",
	"telefone": "61 99613-2589",
	"idade": "23",
	"cidade": "Brasília",
	"estado": "DF",
	"score": "-1"
}

```
### :heavy_check_mark: Pegar uma pessoa por id
Input:
GET:"/pessoa/id"
```bash
{
        "nome": "Lorenna Lima",
        "cidade": "Brasília",
        "estado": "DF",
        "scoreDescricao": "Recomendável"
}

```

### :heavy_check_mark: Trazer todas as pessoas
Input:
GET:"/pessoa"
 ```bash
[
    {
        "nome": "Lorenna Lima",
        "cidade": "Brasília",
        "estado": "DF",
        "scoreDescricao": "Recomendável"
    },
     {
        "nome": "Laura Santos Lima",
        "cidade": "Brasília",
        "estado": "DF",
        "scoreDescricao": "Inaceitável"
    },
     {
        "nome": "Letícia Ferreira Lima",
        "cidade": "Brasília",
        "estado": "DF",
        "scoreDescricao": "Aceitável"
    },
    {
        "nome": "Lucas Santos Lima",
        "cidade": "Brasília",
        "estado": "DF",
        "scoreDescricao": "Insuficiente"
    }
]
```


