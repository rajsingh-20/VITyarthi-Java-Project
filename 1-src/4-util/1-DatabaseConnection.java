// Validate experience
    public static boolean isValidExperience(int experience) {
        return experience >= 0;
    }

    // Validate text input
    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }
}
