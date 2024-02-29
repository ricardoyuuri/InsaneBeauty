# InsaneBeauty

Repositório criado para o fim de guardar informações sobre o software da InsaneBeauty

## Requisitos 

- [ ] CRUD Agendamento
- [ ] CRUD Cadastro
- [ ] CRUD Login
- [ ] Interface de telas da solução, como:
- Unidades
- Serviços
- Profissionais
- Sobre Nós
- Contato
- Home
- Páginas de sucesso na conclução do Agendamento, Cadastro e Login.
- [ ] Dashboard
- [ ] Autenticação

# Endpoints 

## Agendamento 

GET /agendamento/

Lista todos os dados necessários para realizar um agendamento de serviço no software da InsaneBeauty. O sistema irá requisitar dados como: Nome completo, telefone, serviço, data e hora.

*Códigos de status*
200 sucesso

---
GET /agendamento/{id}

Retorna os detalhes de uma categoria com o 'id' informado.

*Códigos de status*
200 sucesso
404 id não encontrado

---
POST/agendamento 

Cadastrar um novo agendamento no banco de dados.

| campo | tipo | obrigatório | descrição 
|-------|------|:-----------:|-----------
| nome completo  |string(50)|sim| nome completo do usuário para cadastrar de novo agendamento. 
| telefone |number(10)|sim| telefone do usuário para possível contato acerca do agendamento.
| serviço |string(25)|sim| nome do serviço do qual deseja realizar.
| data |date|sim| data em que o serviço será realizado.
| hora |time|sim| horário em que o serviço será realizado.

*Códigos de status*
201 criado com sucesso
400 validação falhou

---
DELETE /agendamento/{id}

Deletar/cancelar agendamento com o 'id' informado.

*Códigos de status*
204 apagado/cancelado com sucesso
404 id não encontrado

---
PUT /agendamento/{id}

Altera o agendamento com o 'id' informado.

| campo | tipo | alterável | descrição 
|-------|------|:-----------:|-----------
| nome completo  |string(50)|sim| novo nome completo do usuário para cadastrar de novo agendamento. 
| telefone |number(10)|sim| novo telefone do usuário para possível contato acerca do agendamento.
| serviço |string(25)|sim| novo nome do serviço do qual deseja realizar.
| data |date|sim| nova data em que o serviço será realizado.
| hora |time|sim| novo horário em que o serviço será realizado.

*Códigos de status*
200 sucesso
404 id não encontrado
400 validação falhou 

*Scheme*

js
{
    "id": 1,
    "nome": "Alimentação",
    "icone": "fast-food"
}
