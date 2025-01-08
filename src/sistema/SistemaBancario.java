package sistema;

import contas.IConta;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {

    private List<IConta> contas;

    public SistemaBancario() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(IConta conta) {
        if (!contas.contains(conta)) {
            this.contas.add(conta);
            System.out.println("Conta adicionada: " + conta.obterTipo());
        } else {
            System.out.println("A conta já existe no sistema.");
        }
    }

    public void realizarTransacao(IConta conta, double valor) {
        if (contas.contains(conta)) {
            conta.realizarTransacao(valor);
            System.out.println("Transação realizada. Saldo da " + conta.obterTipo() + ": " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada no sistema.");
        }
    }

    public void calcularTaxa(IConta conta) {
        if (contas.contains(conta)) {
            double taxa = conta.calcularTaxa();
            System.out.println("Taxa da " + conta.obterTipo() + ": " + taxa);
        } else {
            System.out.println("Conta não encontrada no sistema.");
        }
    }
}
