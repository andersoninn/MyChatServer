# 💬 MyChatServer - Servidor de Chat Escalável

Este repositório contém o **MyChatServer**, um servidor de chat escalável desenvolvido em **Java** como parte de um exercício da **Code for All_**. O objetivo do projeto foi criar um servidor de chat robusto que permite a comunicação entre usuários de forma eficiente, utilizando a arquitetura de servidor-cliente.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver o servidor e a lógica de comunicação.
- **Java Sockets**: Tecnologia para comunicação em rede entre o cliente e o servidor.
- **Threading**: Implementação de múltiplas threads para permitir a conexão de vários clientes simultaneamente.

## 🎨 Funcionalidades

- **Comunicação em tempo real**: Permite que os clientes enviem e recebam mensagens em tempo real.
- **Escalabilidade**: O servidor é capaz de lidar com múltiplos clientes ao mesmo tempo, utilizando threads para gerenciar a comunicação.
- **Salas de chat**: Clientes podem se conectar a uma sala de chat específica, permitindo conversas privadas e em grupo.
- **Persistência de mensagens**: As mensagens são gerenciadas e transmitidas de forma eficiente entre os usuários conectados.

## 🚀 Como Usar

1. Clone o repositório:
   ```bash
   git clone https://github.com/andersoninn/MyChatServer.git
   
2. Compile o código:
   ```bash
   javac *.java

3. Inicie o servidor:
   ```bash
   java Server
 
4. Para testar, execute o cliente em outro terminal:
   ```bash
   java ClientHandler

## 📝 Lições Aprendidas
Desenvolvimento de um servidor de chat escalável utilizando Java e Sockets.
Implementação de comunicação em tempo real entre múltiplos clientes.
Gerenciamento de conexões simultâneas utilizando Threading para permitir que vários clientes se conectem ao servidor sem perda de desempenho.
Como estruturar e organizar um servidor de chat eficiente para comunicação entre vários usuários.

---

✨ **Vamos nos conectar!**  
Se você gostou do projeto ou quer trocar ideias, [me encontre no LinkedIn](https://www.linkedin.com/in/andersoninn/). 😊
