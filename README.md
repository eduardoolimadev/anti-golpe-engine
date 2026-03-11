# 🛡️ Guardião Anti-Golpe (Anti-Phishing Engine)

A robust Java backend engine designed to analyze and identify potential phishing threats in URLs and communication patterns. This project focuses on applying **Heuristic Analysis** to protect users from social engineering attacks.

## 🚀 Key Features

- **Heuristic Engine:** Real-time analysis of URL structures and suspicious keywords.
- **Protocol Validation:** Identifies insecure connections (HTTP vs HTTPS) commonly used in scams.
- **Scalable Architecture:** Built with Clean Code principles, making it easy to integrate with web APIs or database blacklists.

## 🛠️ Tech Stack

- **Language:** Java 17+
- **Build Tool:** Maven
- **Core Logic:** Heuristic Pattern Matching

## 🧠 How it Works

The engine currently operates on two layers of defense:
1. **Structural Analysis:** Checks if the URL uses secure protocols.
2. **Behavioral Analysis:** Scans for high-pressure keywords often used in scams (e.g., "verify", "login", "bank-update").

## 📂 Project Structure

- `src/main/java/com/guardiao/Main.java`: The entry point and simulation controller.
- `src/main/java/com/guardiao/HeuristicEngine.java`: The core logic for threat detection.

## 🚧 Roadmap

- [ ] Implement a Logging system for detected threats.
- [ ] Integration with public malicious URL blacklists.
- [ ] Development of a Spring Boot API for remote analysis.

---
Developed by [Eduardo de Oliveira Lima](https://github.com/eduardoolimadev)
