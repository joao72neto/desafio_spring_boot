<h1 align="center" style="font-weight: bold;">Desafio Spring Boot <img src="https://devkico.itexto.com.br/wp-content/uploads/2014/08/spring-boot-project-logo.png" width=30px></h1> 

<p align="center">
 <a href="#context">Contextualização</a> •
 <a href="#tech">Tecnologias</a> •
 <a href="#begin">Primeiros Passos</a> •
 <a href="#end">Endpoints</a>
</p>

<h2 id="context">Contextualização</h2>

Projeto back-end Spring Boot que permite o cadastramento (Inserir), a listagem (Consultar todos), a exclusão (Deletar), a pesquisa (Consultar por ID) e a alteração (Atualizar) de clientes seguindo a modelagem abaixo:

<div align="center">
      <img src="https://github.com/user-attachments/assets/dffa3e6f-3053-4096-a91a-6b94d0ffdd5f"/>
</div>

Os seguintes requisitos foram atendidos:

- Ser uma API Restful
- Usar DTO
- Usar Mapper

<h2 id="tech">💻 Tecnologias</h2>

Abaixo estão listadas todas as tecnologias utilizadas para a realização deste desafio:

- Java / Spring Boot
- Oralce 21c Express
- Git

<h2 id="begin">🚀 Primeiros Passos</h2>

<p>Para rodar o projeto localmente, você pode optar por simplesmente cloná-lo, abri-lo em uma IDE como intellij ou em um editor de código como o visual studio e rodar o ClienteApplication.java</p>

<p>Para testar os endpoints, pode-se usar softwares que fazem requisições HTTP como insomnia (o qual foi usado para demonstrar os exemplos na seção de endpoints abaixo) ou postman.</p>

### Pré-requisitos

- [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Oracle Express](https://www.oracle.com/br/database/technologies/xe-downloads.html)

### Clonando

```bash
git clone https://github.com/joao72neto/desafio_spring_boot.git
```

### Iniciando o Projeto

Executar o arquivo que se encontra no caminho abaixo usando o Vs code ou uma IDE:

`clientes/src/main/java/desafio/cliente/ClienteApplication.java`

<h2 id="end">Endpoints</h2>

| Método HTTP | Endpoint                | Descrição                 |
|-------------|-------------------------|---------------------------|
| GET         | `/clientes/listall`     | Consultar todos os clientes. [exemplo](#con_all) |
| GET         | `/clientes/list/{id}`   | Consultar cliente por ID. [exemplo](#con_id)    |
| DELETE      | `/clientes/delete/{id}` | Deletar cliente pelo ID. [exemplo](#delete)     |
| PUT         | `/clientes/update`      | Atualizar dados de um cliente. [exemplo](#update)|
| POST        | `/clientes/add`         | Inserir um novo cliente. [exemplo](#insert)     |


<h2 id="insert">Inserir</h2>

Inserindo o cliente João com um meio de contato (celular):

REQUEST

```json
{
	"nome": "João",
	"contatos": [
		{
			"tipo": "Celular",
			"texto": "11944936791"
		}
	]
}
```

RESPONSE

```json
{
	"id": 1,
	"nome": "João",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"id": 1,
			"tipo": "Celular",
			"texto": "11944936791"
		}
	]
}
```
Inserindo o cliente Alberto com 2 meios de contato (celular e e-mail):

REQUEST

```json
{
	"nome": "Alberto",
	"contatos": [
		{
			"tipo": "Celular",
			"texto": "11925786881"
		},
		{
			"tipo": "e-mail",
			"texto": "albert@email.com"
		}
	]
}
```

RESPONSE

```json
{
	"id": 2,
	"nome": "Alberto",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"id": 2,
			"tipo": "Celular",
			"texto": "11925786881"
		},
		{
			"id": 3,
			"tipo": "e-mail",
			"texto": "albert@email.com"
		}
	]
}
```

Inserindo o cliente Lucas com nenhum meio de contato:

REQUEST

```json
{
	"nome": "Lucas",
	"contatos": []
}
```

RESPONSE

```json
{
	"id": 3,
	"nome": "Lucas",
	"dataCadastro": "2024-11-29",
	"contatos": []
}
```

<h2 id="con_all">Consultar Todos</h2>

Mostrando todos os clientes cadastrados no banco de dados até o momento:

RESPONSE

```json
[
	{
		"id": 1,
		"nome": "João",
		"dataCadastro": "2024-11-29",
		"contatos": [
			{
				"id": 1,
				"tipo": "Celular",
				"texto": "11944936791"
			}
		]
	},
	{
		"id": 2,
		"nome": "Alberto",
		"dataCadastro": "2024-11-29",
		"contatos": [
			{
				"id": 2,
				"tipo": "Celular",
				"texto": "11925786881"
			},
			{
				"id": 3,
				"tipo": "e-mail",
				"texto": "albert@email.com"
			}
		]
	},
	{
		"id": 3,
		"nome": "Lucas",
		"dataCadastro": "2024-11-29",
		"contatos": []
	}
]
```

<h2 id="con_id">Consultar por ID</h2>

Fazendo uma pesquisa pelo cliente de ID 1:

`/clientes/list/1`

RESPONSE

```json
{
	"id": 1,
	"nome": "João",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"id": 1,
			"tipo": "Celular",
			"texto": "11944936791"
		}
	]
}
```

<h2 id="update">Atualizar</h2>

Mudando o nome do cliente com ID 3 (Lucas) para Joel:

REQUEST

```json
{
	"id": 3,
	"nome": "Joel",
	"dataCadastro": "2024-11-29",
	"contatos": []
}
```

RESPONSE

```json
{
	"id": 3,
	"nome": "Joel",
	"dataCadastro": "2024-11-29",
	"contatos": []
}
```

Adicionando um tipo de contato (celular) para o cliente com ID 3 (Joel):

REQUEST

```json
{
	"id": 3,
	"nome": "Joel",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"tipo": "Celular",
			"texto": "11911224346"
		}
	]
}
```

RESPONSE

```json
{
	"id": 3,
	"nome": "Joel",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"id": 4,
			"tipo": "Celular",
			"texto": "11911224346"
		}
	]
}
```

Retirando o contato “celular” do cliente com ID 2 (Alberto):

REQUEST

```json
{
	"id": 2,
	"nome": "Alberto",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"id": 3,
			"tipo": "e-mail",
			"texto": "albert@email.com"
		}
	]
}
```

RESPONSE

```json
{
	"id": 2,
	"nome": "Alberto",
	"dataCadastro": "2024-11-29",
	"contatos": [
		{
			"id": 3,
			"tipo": "e-mail",
			"texto": "albert@email.com"
		}
	]
}
```

<h2 id="delete">Deletar</h2>

Deletando o usuário com ID 1 (João):

`/clientes/delete/1`

