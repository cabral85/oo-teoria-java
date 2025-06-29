package banco.model;

import banco.interfaces.OperacoesBancarias;
import java.time.LocalDateTime;

/**
 * Classe abstrata que demonstra o conceito de ABSTRAÇÃO
 * Define o comportamento comum para todas as contas bancárias
 * Implementa a interface OperacoesBancarias
 */
public abstract class Conta implements OperacoesBancarias {
    protected String numero;
    protected String titular;
    protected double saldo;
    protected LocalDateTime dataCriacao;
    protected boolean ativa;

    // Construtor
    public Conta(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.dataCriacao = LocalDateTime.now();
        this.ativa = true;
    }

    // Métodos abstratos - devem ser implementados pelas classes filhas
    public abstract double calcularRendimento();
    public abstract String getTipoConta();

    // Implementação dos métodos da interface OperacoesBancarias
    @Override
    public boolean realizarDeposito(double valor) {
        if (valor > 0 && ativa) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Depósito inválido ou conta inativa.");
            return false;
        }
    }

    @Override
    public boolean realizarSaque(double valor) {
        return sacar(valor);
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public boolean isContaAtiva() {
        return this.ativa;
    }

    @Override
    public String getNumeroConta() {
        return this.numero;
    }

    @Override
    public String getTitularConta() {
        return this.titular;
    }

    // Métodos concretos - implementação comum
    public void depositar(double valor) {
        realizarDeposito(valor);
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo && ativa) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saque inválido, saldo insuficiente ou conta inativa.");
            return false;
        }
    }

    public void transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
        }
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", tipo='" + getTipoConta() + '\'' +
                ", ativa=" + ativa +
                '}';
    }
} 