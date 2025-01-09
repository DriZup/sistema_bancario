package repository;

import contas.IConta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepository implements IContaRepository{

    private List<IConta> contas = new ArrayList<>();

    @Override
    public void salvarConta(IConta conta) {
        contas.add(conta);
        System.out.println("Conta salva: " + conta.obterTipo());
    }

    @Override
    public IConta buscarContaPorCpf(String cpf) {
        return contas.stream()
                .filter(conta -> conta.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<IConta> listarContas() {
        return contas;
    }
}

