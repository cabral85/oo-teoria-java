package banco.interfaces;

/**
 * Interface que demonstra o conceito de INTERFACE
 * Define contratos que devem ser implementados pelas classes
 */
public interface OperacoesBancarias {
    
    /**
     * Realiza um depósito na conta
     * @param valor valor a ser depositado
     * @return true se o depósito foi realizado com sucesso
     */
    boolean realizarDeposito(double valor);
    
    /**
     * Realiza um saque na conta
     * @param valor valor a ser sacado
     * @return true se o saque foi realizado com sucesso
     */
    boolean realizarSaque(double valor);
    
    /**
     * Consulta o saldo atual da conta
     * @return saldo atual
     */
    double consultarSaldo();
    
    /**
     * Verifica se a conta está ativa
     * @return true se a conta está ativa
     */
    boolean isContaAtiva();
    
    /**
     * Obtém o número da conta
     * @return número da conta
     */
    String getNumeroConta();
    
    /**
     * Obtém o nome do titular da conta
     * @return nome do titular
     */
    String getTitularConta();
} 