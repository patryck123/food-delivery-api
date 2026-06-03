# Food Delivery API

API de delivery de comida com cardápio, pedidos, rastreamento de status e cálculo automático do valor total do pedido com base nos itens selecionados.

## Tecnologias
Java 17 · Spring Boot 3.2 · Spring Data JPA · MySQL · Maven · Swagger/OpenAPI

## Funcionalidades
- Cardápio com categorias e disponibilidade de itens
- Criação de pedidos com múltiplos itens
- Cálculo automático do valor total
- Rastreamento de status: PENDING → PREPARING → OUT_FOR_DELIVERY → DELIVERED
- Consulta de pedidos por status

## Como Executar
```bash
mvn spring-boot:run
# Acesse: http://localhost:8094/swagger-ui.html
```
**Patryck Martins Langsdorff** — Java Back End Developer Junior | [LinkedIn](https://www.linkedin.com/in/patryck-martins-langsdorff)
