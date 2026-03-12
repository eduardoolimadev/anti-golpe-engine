package com.guardiao;

import java.util.Arrays;
import java.util.List;

/**
 * PROBLEM: Real-time Phishing detection without relying solely on static databases.
 * ALGORITHM: Heuristic Scoring System based on URL Anatomy.
 */
public class HeuristicEngine {

    // Keywords commonly used in Social Engineering attacks
    private final List<String> suspiciousKeywords = Arrays.asList(
            "login", "verify", "update", "security", "bank", "token", "account"
    );

    /**
     * Analyzes the URL and returns a risk score from 0 to 100.
     * @param url The string to be analyzed.
     * @return Risk percentage.
     */
    public int calculateRiskScore(String url) {
        int score = 0;
        String urlLower = url.toLowerCase();

        // 1. Protocol Validation (Weight: 40)
        // Insecure HTTP is a major red flag for phishing in 2026.
        if (urlLower.startsWith("http://")) {
            score += 40;
        }

        // 2. Semantic Analysis (Weight: 10 per keyword)
        // Scammers use urgency-inducing words to trick users.
        for (String key : suspiciousKeywords) {
            if (urlLower.contains(key)) {
                score += 10;
            }
        }

        // 3. Structural Analysis - Subdomain Complexity (Weight: 20)
        // Excessive dots often indicate attempts to camouflage the real domain.
        long dotCount = urlLower.chars().filter(ch -> ch == '.').count();
        if (dotCount > 3) {
            score += 20;
        }

        // Cap the score at 100%
        return Math.min(score, 100);
    }
}