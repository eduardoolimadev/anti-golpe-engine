package com.guardiao;

public class Main {
    public static void main(String[] args) {
        System.out.println("🛡️ GUARDIAO ENGINE - Heuristic Risk Analysis");
        System.out.println("---------------------------------------------");

        HeuristicEngine engine = new HeuristicEngine();

        // Mocking a suspicious URL for demonstration
        String testUrl = "http://secure-bank-verify-account.com.net/login";

        int riskLevel = engine.calculateRiskScore(testUrl);

        System.out.println("Analyzing: " + testUrl);
        System.out.println("Risk Level: " + riskLevel + "%");

        if (riskLevel > 50) {
            System.err.println("🚨 STATUS: HIGH RISK - Phishing pattern detected!");
        } else {
            System.out.println("✅ STATUS: URL appears to be safe.");
        }
    }
}