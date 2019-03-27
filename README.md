# Trabalho Final de Arquitetura Java EE

Nestre repositório encontra-se o trabalho final da disciplina de Arquitetura de Software na plataforma Java EE do curso de Arquitetura de Software Distribuído turma 10 da instituição de ensino PUC-MG. Neste trabalho é apresentado um projeto de Mercado de Ações, onde o sistema deverá tratar a compra de ações para pessoas físicas.

### Definições de Requisitos


  - Uma Empresa possui um número limitado de ações para serem vendidas;
  
  - As Empresas podem emitir novas ações, porém não podemos diminuir o número de ações atuais;
  
  - Cada ação pode pertencer a somente um comprador;
  
  - Uma Ação deve possuir a informação de quando foi comprada e de qual seu valor inicial e atual, juntamente das informações do seu Comprador;
  
  - Um Comprador pode possuir várias Ações;
  
  - O sistema precisa tratar de formar assíncrona a compra e venda das Ações;
  
  - Dura uma compra ou venda, seu Comprador antigo e o novo precisam receber um e-mail com a informação adequada sobre a operação.


### Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias listadas abaixo e sus respectivas definições dentro do mesmo:

* Java Mail API - Para o envio de e-mail comunicando as pessoas das transações de compra e venda de ações foi utilizada esta api independente de plataforma e protocolo para a criação e envio de mensagens eletrônicas. Ela provê um conjunto de classes abstratas que abrangem um sistema de e-mail.

* Lombok - Para aumentar a produtividade e a redução de código foi utilizada a biblioteca Lombok que por meio de anotações adicionadas ao código do projeto é ensinado ao compilador (maven) durante o processo de compilação a criar código Java.

* Spring MVC com REST - Para simplificar o processo de criação dos serviços RESTful foram utilizados o Spring MVC Framework com REST.

* Swagger / Swagger UI - Para realizar o desenho, a construção, a documentação e o consumo dos serviços web RESTful foi utilizado o framework Swagger, que define um padrão de interface, para APIs REST para permitir o entendimento das características do serviço. Com a ferramenta Swagger UI é possível consultar as informações da API através de uma interface HTML.

* Spring Data MongoDB - O Spring Data MongoDB fornece uma integração com a base de dados de documentos MongoDB. No trabalho esta tecnologia foi utilizada para criar as coleções de dados respectivos ao projeto e a definição do estilo Repository na camada de acesso a dados.

* RabbitMQ - Para trabalhar com mensageria no projeto foi utilizada a tecnologia RabbitMQ que é uma solução de message broker open source muito conhecida no mercado. Implementando um padrão aberto para envio de mensagens de negócio entre aplicações(AMQP). Com a facilidade do Spring em implementar o conceito de mensageria do RabbitMQ, o mesmo foi utilizado para tratar as filas de mensagens de compra e venda de ações no projeto.

* Docker - Utilizando esta tecnologia de containerização no projeto ela foi designada para diponibilizar os serviços de mensageria (RabbitMQ) e repositório de dados (MongoDB) que estão rodando sobre containers.


### Como utilizar

* Você irá precisar de uma IDE do Java com o SDK 8 (1.8). 
É possível também rodar o projeto com o Visual Studio Code (Windows, Linux ou MacOS)

* Será necessário instalar o [Docker] localmente para a execução das imagens na sequência abaixo.

* Para iniciar a imagem docker do MongoDB basta utilizar o seguinte comando: 

```sh
docker run -p 27017:27017 --name mongodb -d mongo
```

* Para iniciar a imagem docker do RabbitMQ com o console Web basta utilizar o seguinte comando:

```sh
docker run -d --hostname rabbitmq --name rabbitmq-management -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:management
```

* Para acessar a API com a documentação do Swagger basta acessar o endereço:

```sh
http://localhost:8080/swagger-ui.html
```

* Para acessar o console de administrador do RabbitMQ, é preciso acessar o seguinte link `http://localhost:15672` informando o ***usuário*** e ***senha***, ***guest*** e ***guest*** respectivamente. 
Neste console, podemos acessar as abas de Exchanges e Queues para visualizar nossos exchanges e queues criados.

[Docker]: <https://www.docker.com/get-started>
