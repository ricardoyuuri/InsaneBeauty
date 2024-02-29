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

Lista todos os dados necessários para realizar um agendamento de serviço no software da InsaneBeauty. O sistema irá requisitar dados como: 
- Nome completo
- Telefone
- Serviço
- Data
- Hora

*Códigos de status*
- 200 sucesso

---
GET /agendamento/{id}

Retorna os detalhes de um agendamento com o 'id' informado.

*Códigos de status*
- 200 sucesso
- 404 id não encontrado

---
POST/agendamento 

Cadastra um novo agendamento no banco de dados da InsaneBeauty.

| campo | tipo | obrigatório | descrição 
|-------|------|:-----------:|-----------
| nome completo  |string(50)|sim| nome completo do usuário para cadastrar novo agendamento. 
| telefone |varchar(14)|sim| telefone do usuário para possível contato acerca do agendamento.
| serviço |ENUM|sim| nome do serviço do qual deseja realizar.
| data |date|sim| data em que o serviço será realizado.
| hora |time|sim| horário em que o serviço será realizado.

*Códigos de status*
- 201 criado com sucesso
- 400 validação falhou

---
DELETE /agendamento/{id}

Deleta/cancela agendamento com o 'id' informado.

*Códigos de status*
- 204 apagado/cancelado com sucesso
- 404 id não encontrado

---
PUT /agendamento/{id}

Altera o agendamento com o 'id' informado.

| campo | tipo | alterável | descrição 
|-------|------|:-----------:|-----------
| nome completo  |string(50)|sim| novo nome completo do usuário para atualizar agendamento. 
| telefone |varchar(14)|sim| novo telefone do usuário para possível contato acerca do agendamento.
| serviço |ENUM|sim| novo nome do serviço do qual deseja realizar.
| data |date|sim| nova data em que o serviço será realizado.
| hora |time|sim| novo horário em que o serviço será realizado.

*Códigos de status*
- 200 sucesso
- 404 id não encontrado
- 400 validação falhou 

*Scheme*

```
{
    "id": 1,
    "nome_completo": "Beyoncé Giselle Knowles-Carter",
    "telefone": "11995547959",
    "servico": "Manicure",
    "data": "2024-02-13",
    "hora": "10:00:00"
}
```

## Cadastro

GET /cadastro/

Lista todos os dados necessários para realizar um cadastro de um novo usuário no software da InsaneBeauty. O sistema irá requisitar dados como: 
- Nome completo
- Telefone
- E-mail
- Senha
- CPF
- CEP
- Número Residencial

*Códigos de status*
- 200 sucesso

---
GET /cadastro/{id}

Retorna os detalhes de um cadastro com o 'id' informado.

*Códigos de status*
- 200 sucesso
- 404 id não encontrado

---
POST/cadastro 

Cadastra um novo usuário no banco de dados da InsaneBeauty.

| campo | tipo | obrigatório | descrição 
|-------|------|:-----------:|-----------
| nome completo  |string(50)|sim| nome completo do usuário para cadastrar na plataforma. 
| telefone |varchar(14)|sim| telefone do usuário para cadastramento na plataforma.
| e-mail |varchar(100)|sim| e-mail do usuário para cadastramento na plataforma.
| senha |varchar(20)|sim| senha do usuário para cadastramento na plataforma.
| CPF |string(14)|sim| solicitação de CPF para cadastramento na plataforma.
| CEP |varchar(10)|sim| solicitação de CEP para cadastramento do endereço na plataforma.
| numero residencial |varchar(5)|sim| número da residencia para cadastramento do endereço na plataforma.

*Códigos de status*
- 201 criado com sucesso
- 400 validação falhou

---
DELETE /cadastro/{id}

Deleta cadastro com o 'id' informado.

*Códigos de status*
- 204 apagado/cancelado com sucesso
- 404 id não encontrado

---
PUT /cadastro/{id}

Altera o cadastro do usuário com o 'id' informado.

| campo | tipo | alterável | descrição 
|-------|------|:-----------:|-----------
| nome completo  |string(50)|sim| nome completo atualizado do usuário para cadastrar na plataforma. 
| telefone |varchar(14)|sim| telefone atualizado do usuário para cadastramento na plataforma.
| e-mail |varchar(100)|sim| e-mail atualizado do usuário para cadastramento na plataforma.
| senha |varchar(20)|sim| senha atualizada do usuário para cadastramento na plataforma.
| CPF |string(14)|sim| solicitação de CPF para cadastramento na plataforma.
| CEP |varchar(10)|sim| solicitação de CEP atualizado para cadastramento do endereço na plataforma.
| numero residencial |varchar(5)|sim| número da residencia atualizado para cadastramento do endereço na plataforma.

*Códigos de status*
- 200 sucesso
- 404 id não encontrado
- 400 validação falhou 

*Scheme*

```
{
    "id": 1,
    "nome_completo": "Beyoncé Giselle Knowles-Carter",
    "telefone": "11995547959",
    "email": "beyonce@hotmail.com",
    "senha": "123bananinha",
    "CPF": "123.456.789.10",
    "CEP": "09981-890",
    "numero_residencial": "456"
}
```
