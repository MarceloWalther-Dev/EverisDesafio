## DESAFIO EVERIS 2021
<h4 align="center"> 
	🚧   🚀 ## Concluido ## 🚀   🚧
</h4>
## CHALLENGE EVERIS
### FLORIANOPOLIS - 2021.1
Este Projeto é uma api simples sem autenticação, utilizamos Spring Booat como framework, IDE eclipse e MySQL para persistir os dados.

------------------------------------
## Instruções iniciais

Após fazer o Download e extrair o arquivo para um local seguro, será necessário fazer algumas alteraçoes no arquivo.

#Conexao com banco
spring.datasource.url=jdbc:mysql://localhost:3306/challengeeveris?useTimezone=true&serverTimezone=UTC
spring.datasource.username= `Coloque o seu usuario do banco de dados.`
spring.datasource.password= `Coloque a senha do seu banco`
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

------------------------------------

## Pré - Requisitos e Recomendações

- **JAVA** - Recomendo sempre a última versão - [Baixar OpenJDK](http://jdk.java.net/archive/) :computer:

- **MySQL** - Recomendo o MySQL como Banco de Dados - [Baixar MySQL](https://www.mysql.com/downloads/) :bank:

------------------------------------
## Endpoint's

Users:
	GET -> http://localhost:8080/users<br>
        POST -> http://localhost:8080/users <br>
        PUT -> http://localhost:8080/users <br>
        DELETE -> http://localhost:8080/users/admin/{id}<br>
    
------------------------------------    
Product:
   GET -> http://localhost:8080/products  `Retorna uma lista de Produtos`
     
   GET -> http://localhost:8080/products/menor/preco  `filtra por price, retornando uma lista de produtos ordenada por menor price`
     
   GET -> http://localhost:8080/products/admin/{id}  	`Para fazer a consulta é necessario ser um usuario admin`
     
   POST -> http://localhost:8080/products
     
   PUT -> http://localhost:8080/products 
     
   DELETE -> http://localhost:8080/products/admin/{id} `Para deletar um usuario é necessario ser um usuario admin`
     
     
------------------------------------
Bag:
   GET -> http://localhost:8080/bag `Retorna uma lista com os pedidos,total da compra, status da sacola, a data que foi realizada o pedido, o usuario com endereço.`
    
   POST -> http://localhost:8080/bag
    
   PUT -> http://localhost:8080/bag
    
   DELETE -> http://localhost:8080/bag/admin/3 `É necessario ser um usuario admin para deletar`
    
------------------------------------    
Payment:
   GET -> http://localhost:8080/payment
    
   POST -> http://localhost:8080/payment
    
   PUT -> http://localhost:8080/payment
    
   DELETE -> http://localhost:8080/payment/admin/1 `É necessario ser um usuario admin para deletar` 
    
------------------------------------

## Exemplos

Users:
 
 JSON: 
  POST -> http://localhost:8080/users
 
   
 ``` yaml
 {
   "name":"Marcelo Walther da Silva",
   "age":90,
   "address":[
      {
         "street":"Servidao Domingos Manoel Silveira 2",
         "district":"Norte",
         "houseNumber":"943"
      },
      {
         "street":"Teste2",
         "district":"Rio vermelho",
         "houseNumber":"58"
      }
   ],
   "telephone":"2222222222",
   "email":"marcelowdsilva@gmail.com",
   "cpf":"111111111",
   "paymentMethods":"DEBIT_CARD"
}
``` 

PUT -> http://localhost:8080/users


```yaml
{ 
    "id": 1,
    "name" : "Marcelo Walther da Silva",
    "age" : 33,
    "address" : [
        {
            "street" : "Servidao Domingos Manoel Silveira 2",
            "district" : "Rio vermelho",
            "houseNumber" : "43"            
        }, 
        {
            "street" : "Servidão Fabriciana de Souza Avila",
            "district" : "vermelho",
            "houseNumber" : "58"
        }
    ],
    "telephone" : "(48)999469036",
    "email" : "marcelowdsilva@gmail.com",
    "cpf" : "012345678910",
    "paymentMethods" : "DEBIT_CARD"
 }
 ```


------------------------------------

Product:
 
POST -> http://localhost:8080/products


```yaml
{

 "description" : "PlayStation 4",
 "price" : 1000.00
 
} 
```

PUT -> http://localhost:8080/products 
  

```yaml
{

   "id" : 3,
   "description" : "PlayStation 4",
   "price" : 1000.00
   
}    
```  

------------------------------------

Bag:

POST -> http://localhost:8080/bag 
 
 


```yaml
{

  "userId" : 1,
  "products" : [
  {"productId" : 1, "quantity" : 1},
       {"productId" : 2, "quantity" : 2},
       {"productId" : 3, "quantity" : 3}
   ]
   
}
```



PUT -> http://localhost:8080/bag
  

```yaml
{
    "id" : 2,
    "userId" : 3,
    "products" : [
        {"productId" : 1, "quantity" : 1},
        {"productId" : 2, "quantity" : 2},
        {"productId" : 3, "quantity" : 3}
    ]
}
```

------------------------------------

Payment:

POST -> http://localhost:8080/payment




```yaml
{
    "id" : 1,    
    "paymentType" : "MONEY",
        "bag" : {
         "id" : 1
     }
}    
```
 
  

  
PUT -> http://localhost:8080/payment
  

```yaml
{
    "id" : 1,
    "paymentType" : "CREDIT",
    "bag" : {
    "id" : 1
    }
}
 
 ```


## Autores

:grinning: Marcelo Walther da Silva

## Contato

:mailbox: marcelowdsilva@gmail.com
