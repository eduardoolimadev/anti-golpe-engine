package com.guardiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROBLEM: Static blacklists fail against ephemeral phishing sites.
 * ALGORITHM: Weighted Heuristic Scoring Engine (WHSE).
 * This engine analyzes URL anatomy, TLD reputation, and semantic triggers.
 */
public class HeuristicEngine {

    // Keywords with specific risk weights
    private static final Map<String, Integer> RISK_KEYWORDS = new HashMap<>();
    static {
        RISK_KEYWORDS.put("login", 15);
        RISK_KEYWORDS.put("verify", 20);
        RISK_KEYWORDS.put("bank", 25);
        RISK_KEYWORDS.put("update", 10);
        RISK_KEYWORDS.put("secure", 15);
        RISK_KEYWORDS.put("account", 15);
    }

    // High-risk Top Level Domains (commonly used in scams)
    private final List<String> highRiskTlds = Arrays.asList(".xyz", ".top", ".tk", ".ml", ".ga");

    // Trusted domains to avoid false positives (Whitelisting)
    private final List<String> whiteList = Arrays.asList("google.com", "microsoft.com", "github.com");

    public int calculateRiskScore(String url) {
        String urlLower = url.toLowerCase();

        // STEP 0: Whitelist check (Immediate 0 score)
        for (String trusted : whiteList) {
            if (urlLower.contains(trusted)) return 0;
        }

        int totalScore = 0;

        // STEP 1: Protocol Security (Weight: 35)
        if (urlLower.startsWith("http://")) {
            totalScore += 35;
        }

        // STEP 2: Weighted Semantic Analysis
        for (Map.Entry<String, Integer> entry : RISK_KEYWORDS.entrySet()) {
            if (urlLower.contains(entry.getKey())) {
                totalScore += entry.getValue();
            }
        }

        // STEP 3: TLD Reputation Analysis (Weight: 20)
        for (String tld : highRiskTlds) {
            if (urlLower.endsWith(tld) || urlLower.contains(tld + "/")) {
                totalScore += 20;
            }
        }

        // STEP 4: Structural Complexity (Dots count)
        long dotCount = urlLower.chars().filter(ch -> ch == '.').count();
        if (dotCount > 3) totalScore += 15;

        return Math.min(totalScore, 100);
    }
}