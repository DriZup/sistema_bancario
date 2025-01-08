package contas;

public interface IConta {
    double calcularTaxa();
    String obterTipo();
    void realizarTransacao(double valor);
}
