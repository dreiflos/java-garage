<h2>O Sistema de Garagem de Carros é uma aplicação desenvolvida para o gerenciamento de veículos em uma garagem de vendas, permitindo operações de consulta, inclusão e remoção de veículos, além de um sistema de cadastro e autenticação de usuários com diferentes níveis de acesso (Comum e Administrador).</h2>

A aplicação possui uma interface interativa e intuitiva, projetada para facilitar o uso por usuários com diferentes níveis de experiência.


<b>Tela Inicial</b><br>
A tela principal exibe o nome do sistema ("GARAGEM DE CARROS") e apresenta duas abas no rodapé: Autenticação e Usuários.

Autenticação: Contém as opções para Login e Cadastro de usuários.
Usuários: Contém a opção para Listar Usuários

<b>Gerenciamento de Usuários</b><br>
Cadastro de Usuário
Permite o registro de novos usuários no sistema. A senha é criptografada antes de ser armazenada. O campo "Permissão" (visível apenas para administradores na tela de listagem de usuários) utiliza uma variável booleana para diferenciar entre Usuário Comum e Administrador.

<b>Login de Usuário</b><br>
Funciona como uma barreira de segurança, validando as credenciais (login e senha) inseridas com os registros no banco de dados. A senha digitada é criptografada antes da consulta, garantindo a proteção dos dados.

<b>Usuários Cadastrados (Exclusivo para Administradores)</b><br>
Esta interface é acessível apenas por administradores e permite o gerenciamento completo dos usuários.

  Funcionalidades:
    Consultar usuários por nome.
    Listar usuários.
    Remover usuários.
    Adicionar novos usuários administradores.
    Catálogo de Veículos

As funcionalidades e privilégios de acesso ao catálogo de veículos são determinados pelo nível de permissão do usuário.
