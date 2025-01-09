package utils;

import java.util.regex.Pattern;

public class ValidadorEmail {
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean validar(String email) {
        return email != null && Pattern.matches(EMAIL_REGEX, email);
    }
}

