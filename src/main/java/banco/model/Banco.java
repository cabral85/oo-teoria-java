package banco.model;

import banco.interfaces.OperacoesBancarias;
import banco.interfaces.Rendimento;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que demonstra POLIMORFISMO
 * Gerencia diferentes tipos de conta usando referências polimórficas
 */
public class Banco {
    private String nome;
    private String cnpj;
    private List<Conta> contas;

    public Banco(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = new ArrayList<>();
    }

    /**
     * Demonstra POLIMORFISMO - aceita qualquer tipo de conta
     */
    public void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta " + conta.getTipoConta() + " adicionada ao banco.");
    }

    /**
     * Demonstra POLIMORFISMO - trabalha com diferentes tipos de conta
     */
    public void listarContas() {
        System.out.println("\n=== CONTAS DO BANCO " + nome.toUpperCase() + " ===");
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    /**
     * Demonstra POLIMORFISMO - aplica rendimento em contas que implementam Rendimento
     */
    public void aplicarRendimentos() {
        System.out.println("\n=== APLICANDO RENDIMENTOS ===");
        for (Conta conta : contas) {
            if (conta instanceof Rendimento) {
                Rendimento contaComRendimento = (Rendimento) conta;
                double rendimento = contaComRendimento.aplicarRendimento();
                System.out.println("Rendimento aplicado na conta " + conta.getNumero() + ": R$ " + rendimento);
            }
        }
    }

    /**
     * Demonstra POLIMORFISMO - realiza operações usando a interface
     */
    public void realizarOperacoesBancarias() {
        System.out.println("\n=== OPERAÇÕES BANCÁRIAS ===");
        for (OperacoesBancarias conta : contas) {
            if (conta.isContaAtiva()) {
                System.out.println("Conta: " + conta.getNumeroConta() + " - Titular: " + conta.getTitularConta());
                System.out.println("Saldo atual: R$ " + conta.consultarSaldo());
                
                // Demonstra polimorfismo em ação
                if (conta instanceof ContaCorrente) {
                    ContaCorrente cc = (ContaCorrente) conta;
                    cc.cobrarTaxaManutencao();
                } else if (conta instanceof ContaJovem) {
                    ContaJovem cj = (ContaJovem) conta;
                    cj.solicitarCartaoDebito();
                }
                System.out.println("---");
            }
        }
    }

    /**
     * Demonstra POLIMORFISMO - busca conta por número
     */
    public Conta buscarConta(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }

    /**
     * Demonstra POLIMORFISMO - transfere entre contas
     */
    public void transferirEntreContas(String numeroOrigem, String numeroDestino, double valor) {
        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);
        
        if (origem != null && destino != null) {
            origem.transferir(destino, valor);
        } else {
            System.out.println("Conta(s) não encontrada(s).");
        }
    }

    /**
     * Demonstra POLIMORFISMO - estatísticas por tipo de conta
     */
    public void gerarEstatisticas() {
        System.out.println("\n=== ESTATÍSTICAS DO BANCO ===");
        
        int totalContas = contas.size();
        int contasCorrente = 0;
        int contasPoupanca = 0;
        int contasJovem = 0;
        double saldoTotal = 0.0;

        for (Conta conta : contas) {
            saldoTotal += conta.getSaldo();
            
            if (conta instanceof ContaCorrente) {
                contasCorrente++;
            } else if (conta instanceof ContaPoupanca) {
                contasPoupanca++;
            } else if (conta instanceof ContaJovem) {
                contasJovem++;
            }
        }

        System.out.println("Total de contas: " + totalContas);
        System.out.println("Contas Corrente: " + contasCorrente);
        System.out.println("Contas Poupança: " + contasPoupanca);
        System.out.println("Contas Jovem: " + contasJovem);
        System.out.println("Saldo total do banco: R$ " + saldoTotal);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Conta> getContas() {
        return contas;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", totalContas=" + contas.size() +
                '}';
    }
} 