package utils;

public class ValidadorTelefone {
    public static boolean validar(String telefone) {

        return telefone != null && telefone.matches("\\d{10,11}");
    }
}
