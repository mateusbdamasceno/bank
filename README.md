# Sistema 'bank': Um banco onde é possível realizar transferência
- Utilizado a arquitetura MVC por oferecer Segurança e Eficiência. Também permite que o meu código fique mais organizado e melhor pra visualizar.
- O sistema é dividido em 
- Controller: Onde chega a requisição do usuário e pega os atributos que são passados como parâmetro
- Service: Aqui e onde acontece e implementação das regras de negócio, onde as validações são feitas e onde é possível ver as funcionalidades do sistema
- Repository: Essa camada é responsável por executar as ações no banco de dados
- O seguinte SCRIPT foi usado na criação do banco de dados e seus atributos:
- DROP TABLE IF EXISTS TRANSACTION;
- CREATE TABLE TRANSACTION(ID INT PRIMARY KEY, sourceAccount VARCHAR(255), targetAccount VARCHAR(255), VALUETRANSFER DOUBLE, RATE DOUBLE, transferDate DATE, schedulingDate DATE);
- No application.properies estão as configurações utilizadas pra inicializar o banco de dados H2
- O projeto está no repositório do git: https://github.com/mateusbdamasceno/bank
- Pra fazer o projeto rodar na máquina é necessário
- Fazer o git pull do projeto
- Abrir na IDE
- Utilizar o link do banco de dados pra abir no navegador e entrar com usuário e senha (no caso não tem)
- Criar a tabela e colunas
- No caso da utilização do postman o seguinte body pode ser utilizado
- {
  "id": 1,
  "sourceAccount" : "1212666666",
  "targetAccount" : "1313555555",
  "value" : 1000.00,
  "transferDate" : "2024-01-24",
  "description" : "Description"
  }