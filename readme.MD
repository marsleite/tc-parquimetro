# RFC Técnica: Sistema de Parquímetro

**Grupo 29:** Caio Lacerda, Gustavo Feitosa, Marcelo Leite  
**Repositório:** [https://github.com/marsleite/tc-parquimetro](https://github.com/marsleite/tc-parquimetro)

O sistema de parquímetro é responsável por gerenciar o tempo de estacionamento de veículos, calcular valores devidos e armazenar dados para fins de fiscalização. Esta RFC detalha a arquitetura, tecnologias e funcionalidades do sistema.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação para o desenvolvimento da lógica de negócios.
- **Spring Boot:** Framework para construção de aplicativos Java.
- **Banco de Dados:** MongoDB (NoSQL) para armazenamento de dados e caching.
- **Cache:** Redis (NoSQL) para caching de dados.

## Arquitetura do Sistema

O sistema será dividido em três camadas:

- **Controller:** Recebe requisições HTTP, valida parâmetros e chama métodos apropriados no serviço.
- **Service:** Contém a lógica de negócios, calcula valores e interage com o banco de dados.
- **Banco de Dados:** MongoDB para armazenar detalhes de estacionamento e Redis para caching.

## Funcionalidades

1. **Registrar Estacionamento:**
    - Entrada do número da placa do veículo.
    - Registra a hora de entrada e a localização do veículo.
    - Gera um ID de transação único para referência futura.

2. **Calcular Valor Devido:**
    - Com base na hora de entrada e saída, calcula o valor devido utilizando uma taxa por hora predefinida.

3. **Armazenar Dados:**
    - Armazena dados de transações no MongoDB para fins de fiscalização.
    - Utiliza Redis como cache para evitar chamadas desnecessárias ao banco de dados.

## Endpoints da API

- **POST /estacionamento:** Registra a entrada do veículo, retorna o ID da transação.
- **PUT /estacionamento/{id}/saida:** Registra a saída do veículo, calcula o valor devido e retorna o valor.
- **GET /transacoes/{placa}:** Retorna todas as transações associadas a uma placa específica.

## Considerações de Performance

- Utilizar Redis como cache para evitar consultas excessivas ao banco de dados.
- Implementar TTL (Time-To-Live) no Redis para evitar que dados desatualizados sejam utilizados.
- Configurar índices apropriados no MongoDB para otimizar consultas.

## Conclusão

O sistema de parquímetro proposto oferece funcionalidades básicas para gerenciar estacionamentos, calcular valores e armazenar dados para fiscalização. A utilização de tecnologias como Java, Spring Boot, MongoDB e Redis proporciona uma base sólida para o desenvolvimento do projeto.
