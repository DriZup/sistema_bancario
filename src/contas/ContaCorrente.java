package contas;

public class ContaCorrente implements  IConta{
    private double saldo;


    public ContaCorrente(double saldo) {
        this.saldo = saldo;

    }

    @Override
    public double calcularTaxa() {
        return 0;
    }

    @Override
    public void realizarTransacoes() {

    }

    @Override
    public String obterTipo() {
        return "";
    }
}
