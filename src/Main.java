import calculadoras.CalculadoraTaxaCorrente;
import contas.ContaCorrente;
import notificacoes.NotificadorEmail;

public class Main {
    public static void main(String[] args) {

        CalculadoraTaxaCorrente calculadoraTaxaCorrente = new CalculadoraTaxaCorrente();

        NotificadorEmail notificadorEmail = new NotificadorEmail();

        ContaCorrente contaCorrente = new ContaCorrente(1000.0, calculadoraTaxaCorrente, notificadorEmail);

        contaCorrente.realizarTransacao(100.0);
        System.out.println("Saldo após transação: " + contaCorrente.getSaldo());
        System.out.println("Taxa da Conta Corrente: " + contaCorrente.calcularTaxa());
    }
}