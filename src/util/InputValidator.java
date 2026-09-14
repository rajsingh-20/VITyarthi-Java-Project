package util;

public class InputValidator {

    // Validate name
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    // Validate age
    public static boolean isValidAge(int age) {
        return age > 0;
    }

    // Validate phone number
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    // Validate ID
    public static boolean isValidId(int id) {
        return id > 0;
    }

    // Validate fees
    public static boolean isValidFee(double fee) {
        return fee >= 0;
    }

    // Validate experience
    public static boolean isValidExperience(int experience) {
        return experience >= 0;
    }

    // Validate text input
    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }
}
