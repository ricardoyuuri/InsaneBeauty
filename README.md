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
|-------|------|-------------|-----------
| nome completo  |string(50)|: sim :| nome completo do usuário para cadastrar de novo agendamento. 
| telefone |number(10)|:sim:| telefone do usuário para possível contato acerca do agendamento.
| serviço |string(25)|:sim:| nome do serviço do qual deseja realizar.
| data |date|:sim:| informar a data em que o serviço será realizado.
| hora |time|:sim:| informar o horário em que o serviço será realizado.

*Códigos de status*
201 criado com sucesso
400 validação falhou

---
DELETE /categoria/{id}

Apaga a categoria com o 'id' informado.

*Códigos de status*
204 apagado com sucesso
404 id não encontrado

---
PUT /categoria/{id}

Altera a categoria com o 'id' informado.

| campo | tipo | obrigatório | descrição 
|-------|------|-------------|-----------
| nome  |string|    sim      | novo nome curto para identificar a categoria 
| icone |string|    nao      | novo nome do icone conforme biblioteca material design

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
