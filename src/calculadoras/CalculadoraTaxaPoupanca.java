package calculadoras;

public class CalculadoraTaxaPoupanca implements ICalculadorTaxas{


    @Override
    public double calcularTaxa(double saldo) {
        return saldo * 0.01;
    }
}
