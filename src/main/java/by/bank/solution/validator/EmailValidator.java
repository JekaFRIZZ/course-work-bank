package by.bank.solution.validator;

public class EmailValidator {
    private static String REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";

    public static boolean validate(String email) {
        return email.matches(REGEX);
    }
}
