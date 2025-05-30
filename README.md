# 🧪 Neeha Selenium Automation Framework

This is a robust Selenium Automation Framework designed to automate Flipkart's web functionalities using Java, Selenium WebDriver, TestNG, and ExtentReports. 
It supports automated testing for search, sorting, window handling, and item stock verification with detailed logging and reporting.

## 🚀 Features

- 🔍 Automated product search
- 💰 Sort by Price (Low to High)
- ⭐ Sort by Ratings (4★ and above)
- 🪟 Multiple window handling
- 📦 Item stock status checks
- 📊 ExtentReports for test reporting
- 📸 Screenshot capture on test failure (configurable)

## 🛠️ Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- ExtentReports
- Git

## 📁 Project Structure

src/
├── Base/ # Base test class and setup
├── Reports/ # ExtentReports manager
├── testcases/ # TestNG test classes
test-output/ # ExtentReports HTML files
screenshots/ # Optional: captured screenshots on failures

markdown
Copy
Edit

## 📦 Prerequisites

- Java 8 or later
- Maven
- Chrome browser & ChromeDriver
- Eclipse or IntelliJ
- Git

## 🧪 How to Run

1. Clone this repo:
git clone https://github.com/ineehaQA/NeehaSeleniumAutomationFramework.git

markdown
Copy
Edit

2. Open the project in Eclipse/IntelliJ.

3. Run the `testcases.FlipkartTestCases` class as a **TestNG Test**.

4. View detailed HTML reports at:
test-output/ExtentReport.html

bash
Copy
Edit

## 🖼️ Screenshots

(If implemented) Screenshots will be saved in `/screenshots` on test failure.

## 📄 License

MIT © [Neeharika Pasupuleti](https://github.com/ineehaQA)
