package contas;

import calculadoras.ICalculadorTaxas;
import notificacoes.INotificador;

public class ContaCorrente implements IConta {
    private double saldo;
    private ICalculadorTaxas calculadora;
    private INotificador notificador;

    public ContaCorrente(double saldo, ICalculadorTaxas calculadora, INotificador notificador) {
        this.saldo = saldo;
        this.calculadora = calculadora;
        this.notificador = notificador;
    }

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
        this.calculadora = null;
        this.notificador = null;
    }

    @Override
    public double calcularTaxa() {
        if (calculadora == null) {
            throw new IllegalStateException("Calculadora de taxas não foi inicializada.");
        }
        return calculadora.calcularTaxa(this.saldo);
    }

    @Override
    public String obterTipo() {
        return "Conta Corrente";
    }

    @Override
    public void realizarTransacao(double valor) {
        this.saldo += valor;
        System.out.println("Transação realizada. Saldo da " + obterTipo() + ": " + this.saldo);

        if (notificador != null) {
            notificador.enviarNotificacao("Transação realizada na " + obterTipo() + ". Novo saldo: " + this.saldo);
        }
    }

    public double getSaldo() {
        return saldo;
    }
}