package by.bank.solution.validator;

public class EmailValidator {
    private static String REGEX = "@";

    public static boolean validate(String email) {
        return email.matches(REGEX);
    }
}
