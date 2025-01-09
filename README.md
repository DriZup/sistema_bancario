# Sistema de Gerenciamento de Contas Bancárias

## Enunciado

Este projeto consiste em um sistema para gerenciar contas bancárias, desenvolvido com base nos princípios **SOLID**. O sistema permite:

1. **Criar diferentes tipos de contas**:
   - Conta Corrente
   - Conta Poupança

2. **Calcular taxas específicas** para cada tipo de conta:
   - Conta Corrente: Taxa calculada com base em uma lógica específica.
   - Conta Poupança: Taxa calculada com base em uma lógica específica.

3. **Enviar notificações**:
   - Por e-mail ou SMS, quando uma transação for realizada ou uma conta for criada.

---

## Funcionalidades

### 1. Criação de Contas
- O sistema solicita ao usuário as seguintes informações:
  - Nome
  - CPF
  - E-mail
  - Telefone
  - Tipo de conta (Corrente ou Poupança)
- Após a validação dos dados, a conta é criada e armazenada.

### 2. Cálculo de Taxas
- Cada tipo de conta possui uma lógica específica para o cálculo de taxas:
  - **Conta Corrente**: Taxa calculada por meio da classe `CalculadoraTaxaCorrente`.
  - **Conta Poupança**: Taxa calculada por meio da classe `CalculadoraTaxaPoupanca`.

### 3. Notificações
- O sistema envia notificações para o usuário:
  - **E-mail**: Notifica o usuário sobre a criação da conta.
  - **SMS**: Notifica o usuário sobre a criação da conta.

### 4. Listagem de Contas
- O sistema exibe todas as contas cadastradas no repositório.

---

## Estrutura do Projeto

### Pacotes e Classes

#### 1. **Pacote `calculadoras`**
- Contém as classes responsáveis pelo cálculo de taxas:
  - `CalculadoraTaxaCorrente`
  - `CalculadoraTaxaPoupanca`

#### 2. **Pacote `contas`**
- Contém as interfaces e classes relacionadas às contas:
  - `IConta`: Interface que define o contrato para as contas.
  - `ContaCorrente`: Implementação de uma conta corrente.
  - `ContaPoupanca`: Implementação de uma conta poupança.

#### 3. **Pacote `notificacoes`**
- Contém as classes responsáveis pelo envio de notificações:
  - `NotificadorEmail`: Envia notificações por e-mail.
  - `NotificadorSMS`: Envia notificações por SMS.

#### 4. **Pacote `repository`**
- Contém a classe `ContaRepository`, que gerencia o armazenamento das contas.

#### 5. **Pacote `service`**
- Contém a classe `ContaService`, que implementa a lógica de negócios, como criação de contas e cálculo de taxas.

#### 6. **Pacote `utils`**
- Contém classes utilitárias para validação:
  - `ValidadorCPF`: Valida o CPF.
  - `ValidadorEmail`: Valida o e-mail.
  - `ValidadorTelefone`: Valida o número de telefone.

#### 7. **Classe `Main`**
- Ponto de entrada do sistema. Gerencia a interação com o usuário e orquestra as funcionalidades.

---

## Fluxo do Sistema

1. O usuário inicia o sistema e insere os dados necessários (nome, CPF, e-mail, telefone).
2. Escolhe o tipo de conta a ser criada (Corrente ou Poupança).
3. O sistema valida os dados fornecidos.
4. A conta é criada e armazenada no repositório.
5. O sistema calcula a taxa associada à conta.
6. Notificações são enviadas ao usuário por e-mail e SMS.
7. Todas as contas cadastradas são listadas.

---

## Exemplo de Execução

### Entrada do Usuário:
```
Bem-vindo ao sistema de criação de conta!
Por favor, insira o seu nome: João Silva
Por favor, insira o CPF (apenas números): 12345678900
Por favor, insira o seu e-mail: joao@email.com
Por favor, insira o número de telefone (apenas números): 11999999999
Escolha o tipo de conta:
1. Conta Corrente
2. Conta Poupança
1
```

### Saída do Sistema:
```
Conta criada com sucesso para o usuário: João Silva
Enviando e-mail para joao@email.com: Sua conta foi criada com sucesso, João Silva!
Enviando SMS para 11999999999: Sua conta foi criada com sucesso, João Silva!

Contas cadastradas:
Conta Corrente - Nome: João Silva, CPF: 12345678900
```

---

## Requisitos Técnicos

- **Linguagem**: Java
- **Princípios**: SOLID
- **Ferramentas**:
  - IDE de sua escolha (Eclipse, IntelliJ, etc.)
  - JDK 8 ou superior

---

## Como Executar

1. Clone o repositório do projeto.
2. Compile o código usando sua IDE ou o terminal:
   ```bash
   javac Main.java
   ```
3. Execute o programa:
   ```bash
   java Main
   ```
4. Siga as instruções exibidas no terminal.

---

## Melhorias Futuras

- Adicionar persistência em banco de dados.
- Implementar autenticação para maior segurança.
- Criar uma interface gráfica para melhorar a experiência do usuário.
- Adicionar suporte a mais tipos de contas e notificações.

---

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou novas funcionalidades. Envie um pull request ou abra uma issue no repositório.

---

## Licença

Este projeto é de uso livre e está sob a licença MIT.
