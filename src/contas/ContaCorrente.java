package contas;

public class ContaCorrente implements IConta {
    private double saldo;

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double calcularTaxa() {
        return saldo * 0.01;
    }

    @Override
    public String obterTipo() {
        return "Conta Corrente";
    }

    @Override
    public void realizarTransacao(double valor) {
        if (valor > 0) {
            this.saldo -= valor;
        } else {
            System.out.println("Valor inválido para a transação.");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
}
