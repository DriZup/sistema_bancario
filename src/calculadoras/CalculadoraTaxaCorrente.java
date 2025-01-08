package calculadoras;

public class CalculadoraTaxaCorrente implements ICalculadorTaxas{


    @Override
    public double calcularTaxa(double saldo) {
        return saldo * 0.02;
    }
}
