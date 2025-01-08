package contas;

public interface IConta {
    double calcularTaxa();
    void realizarTransacao(double valor);
    String obterTipo();
    double getSaldo();
}
