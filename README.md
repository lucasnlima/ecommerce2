# E-Commerce2 API
API para gerenciamento de lojas e categorias de produtos em um sistema de e-commerce para estudo e desafio de conhecimento.

> "Os maiores obstáculos ao implementar esse desafio foram lidar com as dependências e com alguns *annotations* que não existem ou são diferente do Spring, a parte do Mock de classes para testes, definição da estrutura das pastes também foi um ponto de dúvida, pois não estou acostumado a trabalhar no dia a dia com projetos dessa stack. Por outro lado a experiência previa com Spring foi de grande ajuda e os conhecimentos sobre WEP APIs também." - Lucas Lima
## Instalação
---------
Faça o clone do projeto para sua máquina:

~~~
git clone https://github.com/lucasnlima/ecommerce2.git
~~~
Dentro da pasta do projeto execute o comando de instalação do Maven:
~~~
mvn install
~~~
Isso irá baixar todas as dependências do projeto e realizar o build.

Para iniciar a API, basta executar o seguinte comando:

~~~
mvn run
~~~
## API
---------

A API estará disponível na porta 8080. As operações de CRUD para lojas e categorias podem ser acessadas nas seguintes rotas:

- **/shop:** operações de CRUD para lojas
- **/category:** operações de CRUD para categorias

Além disso, é possível filtrar lojas por categoria e categorias por loja nas seguintes rotas:

- **/shop?category={categoryName}:** lista as lojas que possuem a categoria com o nome especificado
- **/category?shopId={shopId}:** lista as categorias associadas à loja com o ID especificado

## Testes
---------
## Detalhes
---------

O projeto utiliza o framework Micronaut e o banco de dados H2 embarcado. As configurações podem ser encontradas no arquivo application.yml.

O projeto foi desenvolvido em Java 11 e utiliza o framework Micronaut. O banco de dados embarcado H2 é utilizado para armazenamento dos dados e biblioteca JUnit para fazer os testes. O projeto não possui dependências externas e todas as dependências são gerenciadas pelo Maven.

## Referências
---------
## Micronaut 3.8.0 Documentation

- [User Guide](https://docs.micronaut.io/3.8.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


