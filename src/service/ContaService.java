package service;

import contas.IConta;
import repository.IContaRepository;

import java.util.List;

public class ContaService {

    private IContaRepository contaRepository

    public ContaService(IContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void criarConta(IConta conta) throws Exception {
         contaRepository.save(conta);
    }
    public void realizarTransacao(IConta conta, double valor) throws Exception {
        contaRepository.realizarTransacao(conta, valor);
    }

    public List<IConta> listarContas() {
        return contaRepository.listarContas();
    }
    public void calcularTaxa(IConta conta) throws Exception {
        contaRepository.calcularTaxa(conta);
        System.out.println("Taxa da " + conta.obterTipo() + ": " + conta.calcularTaxa());
    }

}
