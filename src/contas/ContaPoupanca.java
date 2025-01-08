package contas;

import calculadoras.ICalculadorTaxas;
import notificacoes.INotificador;

public class ContaPoupanca implements IConta {

    private double saldo;
    private ICalculadorTaxas calculadora;
    private INotificador notificador;

    public ContaPoupanca(double saldo, ICalculadorTaxas calculadora, INotificador notificador) {
        this.saldo = saldo;
        this.calculadora = calculadora;
        this.notificador = notificador;
    }

    @Override
    public double calcularTaxa() {
        return calculadora.calcularTaxa(this.saldo);
    }

    @Override
    public void realizarTransacao(double valor) {
        this.saldo -= valor;
        notificador.enviarNotificacao("Transação realizada: -" + valor + " na Conta Poupança.");
    }

    @Override
    public String obterTipo() {
        return "Conta Poupança";
    }

    public double getSaldo() {
        return saldo;
    }
}