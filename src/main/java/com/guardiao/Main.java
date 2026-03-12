package com.guardiao;

public class Main {
    public static void main(String[] args) {
        System.out.println("🛡️ GUARDIAO ENGINE v2.0 - Weighted Heuristic Analysis");
        System.out.println("=====================================================");

        HeuristicEngine engine = new HeuristicEngine();

        // CASE 1: High Risk (HTTP + Keywords + Shady TLD)
        String suspiciousUrl = "http://secure-bank-verify-update.xyz/login";

        // CASE 2: Trusted (On Whitelist)
        String trustedUrl = "https://github.com/security/updates";

        // CASE 3: Medium Risk (Contains keyword but uses HTTPS and a normal TLD)
        // This will trigger the "Proceed with caution" (⚠️)
        String cautionUrl = "https://my-personal-blog.com/update-info";

        analyze(engine, suspiciousUrl);
        analyze(engine, trustedUrl);
        analyze(engine, cautionUrl);
    }

    private static void analyze(HeuristicEngine engine, String url) {
        int score = engine.calculateRiskScore(url);

        // Cores ANSI para sincronizar a saída sem atropelar
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";

        System.out.println("\n-----------------------------------------------------");
        System.out.println("Target URL: " + url);
        System.out.println("Risk Score: " + score + "%");

        if (score >= 60) {
            System.out.println(RED + "🚨 VERDICT: MALICIOUS PATTERN DETECTED" + RESET);
        } else if (score > 0) {
            System.out.println(YELLOW + "⚠️ VERDICT: SUSPICIOUS - Proceed with caution" + RESET);
        } else {
            System.out.println(GREEN + "✅ VERDICT: TRUSTED/SAFE" + RESET);
        }
    }
}