# Sistema Bancário - Conceitos de Orientação a Objetos

Este projeto demonstra todos os conceitos fundamentais de Orientação a Objetos em Java através de um sistema bancário completo.

## 📋 Conceitos Demonstrados

### 1. **ABSTRAÇÃO** 
- **Classe Abstrata**: `Conta` define o comportamento comum para todas as contas
- **Métodos Abstratos**: `calcularRendimento()` e `getTipoConta()` devem ser implementados pelas classes filhas
- **Encapsulamento**: Atributos protegidos e métodos públicos

### 2. **HERANÇA**
- **Herança Simples**: `ContaCorrente`, `ContaPoupanca` e `ContaJovem` herdam de `Conta`
- **Reutilização de Código**: Métodos comuns definidos na classe pai
- **Especialização**: Cada classe filha adiciona comportamentos específicos

### 3. **POLIMORFISMO**
- **Polimorfismo de Inclusão**: Banco gerencia diferentes tipos de conta usando referências da classe pai
- **Polimorfismo com Interfaces**: Uso de `OperacoesBancarias` e `Rendimento` para operações genéricas
- **Polimorfismo de Sobrescrita**: Cada tipo de conta implementa comportamentos específicos

### 4. **SOBRECARGA (Overload)**
- **Construtores Múltiplos**: Cada classe possui vários construtores com diferentes parâmetros
- **Flexibilidade**: Permite criar objetos com diferentes configurações iniciais

### 5. **INTERFACE**
- **OperacoesBancarias**: Define contrato para operações básicas de conta
- **Rendimento**: Define contrato para contas que possuem rendimento
- **Desacoplamento**: Permite trabalhar com diferentes implementações

### 6. **SOBRESCRITA (Override)**
- **Método `sacar()`**: Cada tipo de conta implementa regras específicas de saque
- **Método `calcularRendimento()`**: Diferentes taxas e lógicas de rendimento
- **Método `toString()`**: Representação específica de cada tipo de conta

## 🏗️ Estrutura do Projeto

```
src/main/java/banco/
├── Main.java                          # Classe principal com demonstrações
├── model/
│   ├── Conta.java                     # Classe abstrata (ABSTRAÇÃO)
│   ├── ContaCorrente.java             # Herda de Conta (HERANÇA)
│   ├── ContaPoupanca.java             # Herda de Conta (HERANÇA)
│   ├── ContaJovem.java                # Herda de Conta (HERANÇA)
│   └── Banco.java                     # Gerencia contas (POLIMORFISMO)
└── interfaces/
    ├── OperacoesBancarias.java        # Interface para operações (INTERFACE)
    └── Rendimento.java                # Interface para rendimentos (INTERFACE)
```

## 🏦 Tipos de Conta

### **Conta Corrente**
- Limite de crédito
- Taxa de manutenção
- Não possui rendimento
- Saque pode usar limite de crédito

### **Conta Poupança**
- Rendimento mensal (0.5% padrão)
- Saldo mínimo de R$ 50,00
- Aplicação automática de rendimentos

### **Conta Jovem**
- Destinada a pessoas entre 16 e 25 anos
- Limite diário de saque
- Cartão de débito incluído
- Rendimento menor (0.3%)

## 🚀 Como Executar

1. **Compilar o projeto**:
```bash
javac -d bin src/main/java/banco/**/*.java
```

2. **Executar a aplicação**:
```bash
java -cp bin banco.Main
```

## 📊 Exemplos de Saída

O programa demonstra:

- Criação de diferentes tipos de conta
- Operações bancárias (depósito, saque, transferência)
- Aplicação de rendimentos
- Polimorfismo em ação
- Estatísticas do banco

## 🎯 Objetivos Educacionais

Este projeto foi desenvolvido para fins didáticos, demonstrando:

1. **Como aplicar conceitos de OO** em um sistema real
2. **Relacionamentos entre classes** (herança, implementação de interfaces)
3. **Polimorfismo prático** com diferentes tipos de conta
4. **Encapsulamento** e controle de acesso
5. **Reutilização de código** através de herança
6. **Flexibilidade** através de interfaces

## 🔧 Extensões Possíveis

- Adicionar mais tipos de conta (Conta Empresarial, Conta Universitária)
- Implementar sistema de cartões de crédito
- Adicionar persistência de dados
- Criar interface gráfica
- Implementar sistema de notificações
- Adicionar validações mais robustas

## 📚 Conceitos Aplicados

- **Abstração**: Classe `Conta` abstrata
- **Herança**: Hierarquia de contas bancárias
- **Polimorfismo**: Banco gerencia diferentes tipos de conta
- **Sobrecarga**: Múltiplos construtores
- **Interface**: Contratos para operações e rendimentos
- **Sobrescrita**: Comportamentos específicos por tipo de conta

Este projeto serve como um exemplo completo e prático de como aplicar todos os conceitos fundamentais de Orientação a Objetos em um sistema real e funcional. 