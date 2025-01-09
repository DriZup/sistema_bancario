package contas;

import calculadoras.ICalculadorTaxas;
import notificacoes.INotificador;
import utils.ValidadorCPF;

public class ContaCorrente implements IConta {
    private double saldo;
    private ICalculadorTaxas calculadora;
    private INotificador notificador;
    private String cpf;
    private String nome;

    public ContaCorrente(double saldo, ICalculadorTaxas calculadora, INotificador notificador, String cpf, String nome) {
        if (!ValidadorCPF.validar(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.saldo = saldo;
        this.calculadora = calculadora;
        this.notificador = notificador;
        this.cpf = cpf;
        this.nome = nome;
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

    public String getCpf() {
        return cpf;
    }
    @Override
    public String getNome() {
        return nome;
    }
}