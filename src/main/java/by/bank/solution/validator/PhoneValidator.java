package by.bank.solution.validator;

public class PhoneValidator {
    private static String REGEX = "^\\+375\\d{9}";

    public static boolean validate(String phone) {
        return phone.matches(REGEX);
    }
}
