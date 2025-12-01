package com.example.demo;

public class BadCode {

    // 1. Unused variable
    public void unusedVariable() {
        int a = 10;
        int b = 20; // SonarQube will detect "b" as unused
    }

    // 2. Hardcoded password
    public void credentials() {
        String password = "Admin@123"; // Sensitive data - critical issue
        System.out.println("Password: " + password);
    }

    // 3. Duplicate code
    public void duplicateLines() {
        System.out.println("Duplicate line");
        System.out.println("Duplicate line");
    }

    // 4. Empty catch block
    public void emptyCatch() {
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            // ignored
        }
    }

    // 5. Possible division by zero
    public int divide(int a, int b) {
        return a / b; // Sonar will warn "possible division by zero"
    }

    // 6. Null pointer risk
    public void nullPointer() {
        String s = null;
        if (s.length() > 0) {    // SonarQube flags NPE risk
            System.out.println(s);
        }
    }
}
