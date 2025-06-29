package banco.interfaces;

/**
 * Interface que demonstra o conceito de INTERFACE específica
 * Define contratos para contas que possuem rendimento
 */
public interface Rendimento {
    
    /**
     * Calcula o rendimento da conta
     * @return valor do rendimento calculado
     */
    double calcularRendimento();
    
    /**
     * Aplica o rendimento na conta
     * @return valor do rendimento aplicado
     */
    double aplicarRendimento();
    
    /**
     * Obtém a taxa de rendimento da conta
     * @return taxa de rendimento (em decimal)
     */
    double getTaxaRendimento();
    
    /**
     * Define a taxa de rendimento da conta
     * @param taxa nova taxa de rendimento
     */
    void setTaxaRendimento(double taxa);
} 