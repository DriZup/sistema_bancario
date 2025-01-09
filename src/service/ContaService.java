package service;

import contas.IConta;
import repository.IContaRepository;



public class ContaService  {

    private final IContaRepository contaRepository;

    public ContaService(IContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void criarConta(IConta conta) {
        if (contaRepository.buscarContaPorCpf(conta.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe uma conta com este CPF.");
        }
        contaRepository.salvarConta(conta);
    }

    public void realizarTransacao(String cpf, double valor) {
        IConta conta = contaRepository.buscarContaPorCpf(cpf);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada para o CPF: " + cpf);
        }
        conta.realizarTransacao(valor);
    }

    public void calcularTaxa(String cpf) {
        IConta conta = contaRepository.buscarContaPorCpf(cpf);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada para o CPF: " + cpf);
        }
        double taxa = conta.calcularTaxa();
        System.out.println("Taxa da " + conta.obterTipo() + ": " + taxa);
    }

    public void listarContas() {
        contaRepository.listarContas().forEach(conta -> {
            System.out.println("Conta: " + conta.obterTipo() + ", Nome: " + conta.getNome() + ", CPF: " + conta.getCpf() + ", Saldo: " + conta.getSaldo());
        });
    }
}