<h1 align="center" style="font-weight: bold;">Desafio Spring Boot <img src="https://devkico.itexto.com.br/wp-content/uploads/2014/08/spring-boot-project-logo.png" width=30px></h1> 

<p align="center">
 <a href="#end">Endpoints</a> •
 <a href="#insert">Inserir</a> • 
 <a href="#del">Deletar</a> • 
 <a href="#update">Atualizar</a> • 
 <a href="#con_all">Consultar Todos</a> • 
 <a href="#con_id">Consultar por ID</a>
</p>

<hr>

Projeto back-end Spring Boot que permite o cadastramento (Inserir), a listagem (Consultar todos), a exclusão (Deletar), a pesquisa (Consultar por ID) e a alteração (Atualizar) de clientes seguindo a modelagem abaixo:


<img src="https://github.com/user-attachments/assets/dffa3e6f-3053-4096-a91a-6b94d0ffdd5f"/>

Os seguintes requisitos foram atendidos:

- Ser uma API Restful
- Usar DTO
- Usar Mapper

<h2 id="end">Endpoints</h2>

| Método HTTP | Endpoint                | Descrição                 |
|-------------|-------------------------|---------------------------|
| GET         | `/clientes/listall`     | Consultar todos os clientes. [response]() |
| GET         | `/clientes/list/{id}`   | Consultar cliente por ID. [response]()    |
| DELETE      | `/clientes/delete/{id}` | Deletar cliente pelo ID.     |
| PUT         | `/clientes/update`      | Atualizar dados de um cliente. [request]()|
| POST        | `/clientes/add`         | Inserir um novo cliente. [request]()     |


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

<h2 id="con_all">Consultar por ID</h2>

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

<h2 id="insert">Atualizar</h2>

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
