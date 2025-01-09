package contas;

import calculadoras.ICalculadorTaxas;
import notificacoes.INotificador;
import utils.ValidadorCPF;

public class ContaPoupanca implements IConta {

    private double saldo;
    private ICalculadorTaxas calculadora;
    private INotificador notificador;
    private String cpf;

    public ContaPoupanca(double saldo, ICalculadorTaxas calculadora, INotificador notificador, String cpf) {
        if (calculadora == null) {
            throw new IllegalArgumentException("Calculadora de taxas não pode ser nula.");
        }
        if (notificador == null) {
            throw new IllegalArgumentException("Notificador não pode ser nulo.");
        }
        if (!ValidadorCPF.validar(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.saldo = saldo;
        this.calculadora = calculadora;
        this.notificador = notificador;
        this.cpf = cpf;
    }

    @Override
    public double calcularTaxa() {
        return calculadora.calcularTaxa(this.saldo);
    }

    @Override
    public void realizarTransacao(double valor) {
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar a transação.");
        }
        this.saldo -= valor;
        System.out.println("Transação realizada. Saldo da " + obterTipo() + ": " + this.saldo);
        notificador.enviarNotificacao("Transação realizada: -" + valor + " na Conta Poupança. Novo saldo: " + this.saldo);
    }

    @Override
    public String obterTipo() {
        return "Conta Poupança";
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }
}