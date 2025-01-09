package repository;

import contas.IConta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepositoryImpl implements IContaRepository {

    private List<IConta> contas = new ArrayList<>();

    @Override
    public void save(IConta conta) {
        contas.add(conta);
        System.out.println("Conta salva: " + conta.obterTipo());
    }

    @Override
    public void delete(IConta conta) {

    }

    @Override
    public void update(IConta conta) {

    }

    @Override
    public List<IConta> listarContas() {
        return contas;
    }
}
