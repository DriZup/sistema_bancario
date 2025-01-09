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
        if (conta == null) {
            System.out.println("Conta inválida. Não é possível adicionar.");
            return;
        }
        if (!contas.contains(conta)) {
            this.contas.add(conta);
            System.out.println("Conta adicionada: " + conta.obterTipo());
        } else {
            System.out.println("A conta já existe no sistema.");
        }
    }

    public void realizarTransacao(IConta conta, double valor) {
        IConta contaEncontrada = buscarConta(conta);
        if (contaEncontrada != null) {
            contaEncontrada.realizarTransacao(valor);
            System.out.println("Transação realizada. Saldo da " + contaEncontrada.obterTipo() + ": " + contaEncontrada.getSaldo());
        }
    }

    public void calcularTaxa(IConta conta) {
        IConta contaEncontrada = buscarConta(conta);
        if (contaEncontrada != null) {
            double taxa = contaEncontrada.calcularTaxa();
            System.out.println("Taxa da " + contaEncontrada.obterTipo() + ": " + taxa);
        }
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada no sistema.");
            return;
        }
        contas.forEach(conta ->
                System.out.println(conta.obterTipo() + " - Saldo: " + conta.getSaldo())
        );
    }

    public IConta getConta(int indice) {
        if (indice >= 0 && indice < contas.size()) {
            return contas.get(indice);
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }

    private IConta buscarConta(IConta conta) {
        if (conta == null) {
            System.out.println("Conta inválida.");
            return null;
        }
        if (contas.contains(conta)) {
            return conta;
        } else {
            System.out.println("Conta não encontrada no sistema.");
            return null;
        }
    }
}