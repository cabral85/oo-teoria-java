package banco.model;

import banco.interfaces.Rendimento;
import java.time.LocalDate;
import java.time.Period;

/**
 * Classe que demonstra HERANÇA (herda de Conta)
 * e SOBRESCRITA (override) com regras específicas para jovens
 * Implementa a interface Rendimento
 */
public class ContaJovem extends Conta implements Rendimento {
    private LocalDate dataNascimento;
    private double limiteSaque;
    private boolean cartaoDebito;
    private double taxaRendimento;

    // Construtor com SOBRECARGA (overload)
    public ContaJovem(String numero, String titular, double saldoInicial, LocalDate dataNascimento) {
        super(numero, titular, saldoInicial);
        this.dataNascimento = dataNascimento;
        this.limiteSaque = 500.0;
        this.cartaoDebito = true;
        this.taxaRendimento = 0.003; // 0.3% ao mês
        validarIdade();
    }

    // Construtor com SOBRECARGA (overload) - demonstra o conceito
    public ContaJovem(String numero, String titular, double saldoInicial, LocalDate dataNascimento, double limiteSaque) {
        super(numero, titular, saldoInicial);
        this.dataNascimento = dataNascimento;
        this.limiteSaque = limiteSaque;
        this.cartaoDebito = true;
        this.taxaRendimento = 0.003; // 0.3% ao mês
        validarIdade();
    }

    // Método privado para validar idade
    private void validarIdade() {
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 16 || idade > 25) {
            System.out.println("Aviso: Conta Jovem é destinada a pessoas entre 16 e 25 anos.");
            this.ativa = false;
        }
    }

    // SOBRESCRITA (override) do método sacar da classe pai
    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo && valor <= limiteSaque && ativa) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
            return true;
        } else {
            if (valor > limiteSaque) {
                System.out.println("Saque excede o limite diário de R$ " + limiteSaque);
            } else {
                System.out.println("Saque inválido, saldo insuficiente ou conta inativa.");
            }
            return false;
        }
    }

    // Implementação dos métodos da interface Rendimento
    @Override
    public double calcularRendimento() {
        // Conta jovem tem rendimento menor que poupança
        return saldo * taxaRendimento;
    }

    @Override
    public double aplicarRendimento() {
        double rendimento = calcularRendimento();
        saldo += rendimento;
        System.out.println("Rendimento de R$ " + rendimento + " aplicado na conta jovem.");
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
        return "Conta Jovem";
    }

    // Métodos específicos da conta jovem
    public void solicitarCartaoDebito() {
        if (cartaoDebito) {
            System.out.println("Cartão de débito já está disponível para esta conta.");
        } else {
            this.cartaoDebito = true;
            System.out.println("Cartão de débito solicitado com sucesso.");
        }
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    // Getters e Setters específicos
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public boolean isCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(boolean cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    // SOBRESCRITA (override) do método toString
    @Override
    public String toString() {
        return "ContaJovem{" +
                "numero='" + numero + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", idade=" + getIdade() +
                ", limiteSaque=" + limiteSaque +
                ", cartaoDebito=" + cartaoDebito +
                ", ativa=" + ativa +
                '}';
    }
} 