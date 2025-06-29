package banco.model;

import banco.interfaces.Rendimento;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Classe que demonstra HERANÇA (herda de Conta)
 * e SOBRESCRITA (override) com comportamento específico
 * Implementa a interface Rendimento
 */
public class ContaPoupanca extends Conta implements Rendimento {
    private double taxaRendimento;
    private LocalDateTime ultimaAtualizacao;

    // Construtor com SOBRECARGA (overload)
    public ContaPoupanca(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
        this.taxaRendimento = 0.005; // 0.5% ao mês
        this.ultimaAtualizacao = LocalDateTime.now();
    }

    // Construtor com SOBRECARGA (overload) - demonstra o conceito
    public ContaPoupanca(String numero, String titular, double saldoInicial, double taxaRendimento) {
        super(numero, titular, saldoInicial);
        this.taxaRendimento = taxaRendimento;
        this.ultimaAtualizacao = LocalDateTime.now();
    }

    // SOBRESCRITA (override) do método sacar da classe pai
    @Override
    public boolean sacar(double valor) {
        // Conta poupança tem limite mínimo de saldo
        double saldoMinimo = 50.0;
        if (valor > 0 && (saldo - valor) >= saldoMinimo && ativa) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saque inválido, saldo insuficiente (mínimo R$ 50,00) ou conta inativa.");
            return false;
        }
    }

    // Implementação dos métodos da interface Rendimento
    @Override
    public double calcularRendimento() {
        long meses = ChronoUnit.MONTHS.between(ultimaAtualizacao, LocalDateTime.now());
        if (meses > 0) {
            return saldo * taxaRendimento * meses;
        }
        return 0.0;
    }

    @Override
    public double aplicarRendimento() {
        double rendimento = calcularRendimento();
        if (rendimento > 0) {
            saldo += rendimento;
            ultimaAtualizacao = LocalDateTime.now();
            System.out.println("Rendimento de R$ " + rendimento + " aplicado.");
        }
        return rendimento;
    }

    @Override
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    @Override
    public void setTaxaRendimento(double taxa) {
        this.taxaRendimento = taxa;
    }

    // SOBRESCRITA (override) do método abstrato getTipoConta
    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }

    // Método específico da conta poupança (mantido para compatibilidade)
    public void aplicarRendimento() {
        aplicarRendimento();
    }

    // Getters e Setters específicos
    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    // SOBRESCRITA (override) do método toString
    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numero='" + numero + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", taxaRendimento=" + (taxaRendimento * 100) + "%" +
                ", ultimaAtualizacao=" + ultimaAtualizacao +
                ", ativa=" + ativa +
                '}';
    }
} 