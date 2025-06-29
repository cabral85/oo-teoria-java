package banco.model;

/**
 * Classe que demonstra HERANÇA (herda de Conta)
 * e SOBRESCRITA (override) de métodos
 */
public class ContaCorrente extends Conta {
    private double limiteCredito;
    private double taxaManutencao;

    // Construtor com SOBRECARGA (overload)
    public ContaCorrente(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
        this.limiteCredito = 1000.0;
        this.taxaManutencao = 15.0;
    }

    // Construtor com SOBRECARGA (overload) - demonstra o conceito
    public ContaCorrente(String numero, String titular, double saldoInicial, double limiteCredito) {
        super(numero, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
        this.taxaManutencao = 15.0;
    }

    // Construtor com SOBRECARGA (overload) - mais parâmetros
    public ContaCorrente(String numero, String titular, double saldoInicial, double limiteCredito, double taxaManutencao) {
        super(numero, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
        this.taxaManutencao = taxaManutencao;
    }

    // SOBRESCRITA (override) do método sacar da classe pai
    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (valor <= saldo + limiteCredito) && ativa) {
            if (valor <= saldo) {
                this.saldo -= valor;
            } else {
                // Usa o limite de crédito
                double valorLimite = valor - saldo;
                this.saldo = 0;
                this.limiteCredito -= valorLimite;
            }
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saque inválido, saldo + limite insuficiente ou conta inativa.");
            return false;
        }
    }

    // SOBRESCRITA (override) do método abstrato calcularRendimento
    @Override
    public double calcularRendimento() {
        // Conta corrente não rende juros
        return 0.0;
    }

    // SOBRESCRITA (override) do método abstrato getTipoConta
    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }

    // Método específico da conta corrente
    public void cobrarTaxaManutencao() {
        if (saldo >= taxaManutencao) {
            saldo -= taxaManutencao;
            System.out.println("Taxa de manutenção de R$ " + taxaManutencao + " cobrada.");
        } else {
            System.out.println("Saldo insuficiente para cobrar taxa de manutenção.");
        }
    }

    // Getters e Setters específicos
    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    // SOBRESCRITA (override) do método toString
    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero='" + numero + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", limiteCredito=" + limiteCredito +
                ", taxaManutencao=" + taxaManutencao +
                ", ativa=" + ativa +
                '}';
    }
} 