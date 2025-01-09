package repository;

import contas.IConta;

import java.util.List;

public interface IContaRepository {
    void save(IConta conta);

    void delete(IConta conta);

    void update(IConta conta);

    List<IConta> listarContas();

    void realizarTransacao(IConta conta, double valor);

    void calcularTaxa(IConta conta);
}
