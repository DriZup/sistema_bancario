package sistema;

import contas.IConta;

import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {

    private List<IConta> contas;

    public SistemaBancario() {
        this.contas = new ArrayList<>();
    }

    // Adiciona uma conta ao sistema
    public void adicionarConta(IConta conta) {
        this.contas.add(conta);
    }

    public void realizarTransacao(IConta conta, double valor) {
        conta.realizarTransacao(valor);
        System.out.println("Saldo da " + conta.obterTipo() + ": " + conta.getSaldo());
    }

    public void calcularTaxa(IConta conta) {
        double taxa = conta.calcularTaxa();
        System.out.println("Taxa da " + conta.obterTipo() + ": " + taxa);
    }
}
