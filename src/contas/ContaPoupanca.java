package contas;

public class ContaPoupanca implements IConta {

    private double saldo;

    public ContaPoupanca(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double calcularTaxa() {
        return saldo * 0.01;
    }

    @Override
    public void realizarTransacao(double valor) {
        if (valor > 0) {
            this.saldo -= valor;
        } else {
            this.saldo += Math.abs(valor);
        }
    }

    @Override
    public String obterTipo() {
        return "Conta Poupança";
    }

    public double getSaldo() {
        return this.saldo;
    }
}
