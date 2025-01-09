package utils;

public class ValidadorCPF {
    public static boolean validar(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("\\D+")) {
            return false;
        }
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        // Verifica o primeiro dígito verificador
        if (!verificarDigito(cpf, 9, 10)) {
            return false;
        }

        // Verifica o segundo dígito verificador
        if (!verificarDigito(cpf, 10, 11)) {
            return false;
        }

        return true;
    }

    private static boolean verificarDigito(String cpf, int tamanho, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < tamanho; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (pesoInicial - i);
        }
        int resto = soma % 11;
        int digitoVerificador = (resto < 2) ? 0 : 11 - resto;
        return Character.getNumericValue(cpf.charAt(tamanho)) == digitoVerificador;
    }
}
