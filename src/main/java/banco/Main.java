package banco;

import banco.model.*;
import banco.interfaces.OperacoesBancarias;
import banco.interfaces.Rendimento;
import java.time.LocalDate;

/**
 * Classe principal que demonstra todos os conceitos de Orientação a Objetos
 * ABSTRAÇÃO, HERANÇA, POLIMORFISMO, SOBRECARGA, INTERFACE, SOBRESCRITA
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCÁRIO - CONCEITOS DE ORIENTAÇÃO A OBJETOS ===\n");
        
        // Criando o banco
        Banco banco = new Banco("Banco do Brasil", "00.000.000/0001-00");
        System.out.println("Banco criado: " + banco);
        
        // ========================================
        // DEMONSTRANDO ABSTRAÇÃO
        // ========================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("1. ABSTRAÇÃO - Classe abstrata Conta");
        System.out.println("=".repeat(50));
        System.out.println("A classe Conta é abstrata e define o comportamento comum");
        System.out.println("para todas as contas bancárias, com métodos abstratos que");
        System.out.println("devem ser implementados pelas classes filhas.\n");
        
        // ========================================
        // DEMONSTRANDO HERANÇA E SOBRECARGA
        // ========================================
        System.out.println("=".repeat(50));
        System.out.println("2. HERANÇA E SOBRECARGA (Overload)");
        System.out.println("=".repeat(50));
        
        // Criando contas com diferentes construtores (SOBRECARGA)
        ContaCorrente cc1 = new ContaCorrente("001", "João Silva", 1000.0);
        ContaCorrente cc2 = new ContaCorrente("002", "Maria Santos", 2000.0, 2000.0);
        ContaCorrente cc3 = new ContaCorrente("003", "Pedro Costa", 1500.0, 1500.0, 20.0);
        
        ContaPoupanca cp1 = new ContaPoupanca("101", "Ana Oliveira", 500.0);
        ContaPoupanca cp2 = new ContaPoupanca("102", "Carlos Lima", 1000.0, 0.006);
        
        ContaJovem cj1 = new ContaJovem("201", "Lucas Ferreira", 300.0, LocalDate.of(2005, 5, 15));
        ContaJovem cj2 = new ContaJovem("202", "Julia Rodrigues", 400.0, LocalDate.of(2003, 8, 22), 800.0);
        
        // Adicionando contas ao banco (HERANÇA - todas herdam de Conta)
        banco.adicionarConta(cc1);
        banco.adicionarConta(cc2);
        banco.adicionarConta(cc3);
        banco.adicionarConta(cp1);
        banco.adicionarConta(cp2);
        banco.adicionarConta(cj1);
        banco.adicionarConta(cj2);
        
        // ========================================
        // DEMONSTRANDO SOBRESCRITA (Override)
        // ========================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("3. SOBRESCRITA (Override) - Comportamentos específicos");
        System.out.println("=".repeat(50));
        
        System.out.println("Testando saques com comportamentos diferentes:");
        cc1.sacar(1500.0); // Usa limite de crédito
        cp1.sacar(400.0);  // Respeita saldo mínimo
        cj1.sacar(600.0);  // Respeita limite diário
        
        // ========================================
        // DEMONSTRANDO INTERFACES
        // ========================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("4. INTERFACES - Contratos implementados");
        System.out.println("=".repeat(50));
        
        System.out.println("Todas as contas implementam OperacoesBancarias:");
        for (OperacoesBancarias conta : banco.getContas()) {
            System.out.println("- " + conta.getTitularConta() + " (Conta: " + conta.getNumeroConta() + ")");
        }
        
        System.out.println("\nContas que implementam Rendimento:");
        for (Conta conta : banco.getContas()) {
            if (conta instanceof Rendimento) {
                Rendimento rendimento = (Rendimento) conta;
                System.out.println("- " + conta.getTitular() + " (Taxa: " + (rendimento.getTaxaRendimento() * 100) + "%)");
            }
        }
        
        // ========================================
        // DEMONSTRANDO POLIMORFISMO
        // ========================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("5. POLIMORFISMO - Referências polimórficas");
        System.out.println("=".repeat(50));
        
        // Listando todas as contas (polimorfismo)
        banco.listarContas();
        
        // Aplicando rendimentos (polimorfismo)
        banco.aplicarRendimentos();
        
        // Realizando operações bancárias (polimorfismo)
        banco.realizarOperacoesBancarias();
        
        // Transferências entre contas (polimorfismo)
        System.out.println("\n=== TRANSFERÊNCIAS ===");
        banco.transferirEntreContas("001", "101", 200.0);
        banco.transferirEntreContas("002", "201", 150.0);
        
        // Gerando estatísticas (polimorfismo)
        banco.gerarEstatisticas();
        
        // ========================================
        // DEMONSTRANDO POLIMORFISMO COM INTERFACES
        // ========================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("6. POLIMORFISMO COM INTERFACES");
        System.out.println("=".repeat(50));
        
        // Criando array de OperacoesBancarias (polimorfismo)
        OperacoesBancarias[] operacoes = {
            cc1, cp1, cj1
        };
        
        System.out.println("Operações usando interface OperacoesBancarias:");
        for (OperacoesBancarias op : operacoes) {
            System.out.println("Conta: " + op.getNumeroConta() + " - Saldo: R$ " + op.consultarSaldo());
            op.realizarDeposito(100.0);
        }
        
        // Criando array de Rendimento (polimorfismo)
        Rendimento[] rendimentos = {
            cp1, cj1
        };
        
        System.out.println("\nAplicando rendimentos usando interface Rendimento:");
        for (Rendimento rend : rendimentos) {
            double valor = rend.aplicarRendimento();
            System.out.println("Rendimento aplicado: R$ " + valor);
        }
        
        // ========================================
        // RESUMO DOS CONCEITOS DEMONSTRADOS
        // ========================================
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMO DOS CONCEITOS DE ORIENTAÇÃO A OBJETOS");
        System.out.println("=".repeat(50));
        System.out.println("✓ ABSTRAÇÃO: Classe abstrata Conta com métodos abstratos");
        System.out.println("✓ HERANÇA: ContaCorrente, ContaPoupanca e ContaJovem herdam de Conta");
        System.out.println("✓ POLIMORFISMO: Banco gerencia diferentes tipos de conta");
        System.out.println("✓ SOBRECARGA: Múltiplos construtores com parâmetros diferentes");
        System.out.println("✓ INTERFACE: OperacoesBancarias e Rendimento definem contratos");
        System.out.println("✓ SOBRESCRITA: Cada tipo de conta implementa comportamentos específicos");
        System.out.println("\nSistema bancário completo demonstrando todos os conceitos!");
    }
} 