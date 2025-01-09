import calculadoras.CalculadoraTaxaCorrente;
import calculadoras.CalculadoraTaxaPoupanca;
import contas.IConta;
import notificacoes.NotificadorEmail;
import notificacoes.NotificadorSMS;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import repository.ContaRepository;
import service.ContaService;
import utils.ValidadorCPF;
import utils.ValidadorEmail;
import utils.ValidadorTelefone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaRepository contaRepository = new ContaRepository();
        ContaService contaService = new ContaService(contaRepository);

        System.out.println("Bem-vindo ao sistema de criação de conta!");

        System.out.print("Por favor, insira o seu nome: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.print("Por favor, insira o CPF (apenas números): ");
            cpf = scanner.nextLine();
            if (ValidadorCPF.validar(cpf)) {
                break;
            }
            System.out.println("O CPF informado é inválido. Tente novamente.");
        }

        String email;
        while (true) {
            System.out.print("Por favor, insira o seu e-mail: ");
            email = scanner.nextLine();
            if (ValidadorEmail.validar(email)) {
                break;
            }
            System.out.println("O e-mail informado é inválido. Tente novamente.");
        }

        String telefone;
        while (true) {
            System.out.print("Por favor, insira o número de telefone (apenas números): ");
            telefone = scanner.nextLine();
            if (ValidadorTelefone.validar(telefone)) {
                break;
            }
            System.out.println("O número de telefone informado é inválido. Tente novamente.");
        }

        IConta conta;
        while (true) {
            System.out.println("Escolha o tipo de conta:");
            System.out.println("1. Conta Corrente");
            System.out.println("2. Conta Poupança");
            int tipoConta = scanner.nextInt();
            scanner.nextLine();

            if (tipoConta == 1) {
                conta = new ContaCorrente(10000.0, new CalculadoraTaxaCorrente(), new NotificadorEmail(), cpf, nome);
                break;
            } else if (tipoConta == 2) {
                conta = new ContaPoupanca(10000.0, new CalculadoraTaxaPoupanca(), new NotificadorSMS(), cpf, nome);
                break;
            } else {
                System.out.println("Tipo de conta inválido. Tente novamente.");
            }
        }

        try {
            contaService.criarConta(conta);
            System.out.println("Conta criada com sucesso para o usuário: " + nome);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        contaService.calcularTaxa(cpf);

        enviarNotificacaoEmail(email, "Sua conta foi criada com sucesso, " + nome + "!");
        enviarNotificacaoSMS(telefone, "Sua conta foi criada com sucesso, " + nome + "!");

        System.out.println("\nContas cadastradas:");
        contaService.listarContas();

        scanner.close();
    }

    private static void enviarNotificacaoEmail(String email, String mensagem) {
        System.out.println("Enviando e-mail para " + email + ": " + mensagem);
    }

    private static void enviarNotificacaoSMS(String telefone, String mensagem) {
        System.out.println("Enviando SMS para " + telefone + ": " + mensagem);
    }
}