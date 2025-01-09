import calculadoras.CalculadoraTaxaCorrente;
import calculadoras.CalculadoraTaxaPoupanca;
import calculadoras.ICalculadorTaxas;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import notificacoes.INotificador;
import notificacoes.NotificadorEmail;

public class Main {
    public static void main(String[] args) {
        ICalculadorTaxas calculadora = new CalculadoraTaxaCorrente();
        ICalculadorTaxas calculadoraPoupanca = new CalculadoraTaxaPoupanca();
        INotificador notificador = new NotificadorEmail();

        ContaCorrente contaCorrente = new ContaCorrente(1000.0, calculadora, notificador);
        ContaPoupanca contaPoupanca = new ContaPoupanca(1000.0, calculadoraPoupanca, notificador);

        contaCorrente.realizarTransacao(200.0);
        contaCorrente.realizarTransacao(-150.0);

        contaPoupanca.realizarTransacao(100.0);
        contaPoupanca.realizarTransacao(-50.0);

        System.out.println("Saldo final: " + contaCorrente.getSaldo());
        System.out.println("Taxa calculada: " + contaCorrente.calcularTaxa());

        System.out.println("Saldo final contaPoupança: " + contaPoupanca.getSaldo());
        System.out.println("Taxa calculada conataPoupança: " + contaPoupanca.calcularTaxa());
    }
}