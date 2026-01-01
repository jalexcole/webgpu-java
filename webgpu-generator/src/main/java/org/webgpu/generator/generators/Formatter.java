package org.webgpu.generator.generators;

public class Formatter {
    
    private Formatter() {}

    public static String toPascalCase(String input) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : input.toCharArray()) {
            if (c == '_' || c == ' ' || c == '-') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static String toCamelCase(String input) {
        String pascalCase = toPascalCase(input);
        if (pascalCase.isEmpty()) {
            return pascalCase;
        }
        return Character.toLowerCase(pascalCase.charAt(0)) + pascalCase.substring(1);
    }

    public static String toUpperSnakeCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c) && result.length() > 0) {
                result.append('_');
            }
            result.append(Character.toUpperCase(c));
        }
        return result.toString();
    }

    public static String addPrefix(String input) {
        return "WGPU" + input;
    }
}
