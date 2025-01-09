package repository;

import contas.IConta;

import java.util.List;

public interface IContaRepository {


    void salvarConta(IConta conta);

    IConta buscarContaPorCpf(String cpf);

    List<IConta> listarContas();
}
