# 🍕 Food Delivery API

Sistema de delivery com cardápio, pedidos e rastreamento de status de entrega.

## 📋 Sobre o Projeto

Backend para um aplicativo de delivery de comida. Gerencia o cardápio do restaurante (categorias, pratos, preços), recebe pedidos com múltiplos itens e rastreia o status desde o recebimento até a entrega.

## ✨ Funcionalidades

- ✅ Gerenciar cardápio (pratos e categorias)
- ✅ Ativar/desativar itens do cardápio
- ✅ Criar pedido com múltiplos itens
- ✅ Calcular valor total do pedido
- ✅ Acompanhar status: RECEIVED → PREPARING → ON_THE_WAY → DELIVERED
- ✅ Cancelar pedido (apenas em RECEIVED)
- ✅ Histórico de pedidos

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/menu` | Listar / Adicionar item |
| PUT/DELETE | `/api/menu/{id}` | Editar / Remover item |
| GET/POST | `/api/orders` | Listar / Criar pedido |
| PATCH | `/api/orders/{id}/status` | Avançar status |
| DELETE | `/api/orders/{id}` | Cancelar pedido |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · MySQL · Maven · Lombok
