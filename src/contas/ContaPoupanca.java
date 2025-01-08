package contas;

public class ContaPoupanca implements IConta {

    private double saldo;

    public ContaPoupanca(double saldo) {
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
