# Test Automation Framework

This repository contains a **Java-based Test Automation Framework** designed for efficient and scalable testing. The framework is built with modern tools and libraries to ensure robustness and maintainability, with the ability to execute tests locally or on the cloud via LambdaTest.

## Features
- **Language**: Java 21
- **Test Framework**: TestNG
- **Data-Driven Testing**: OpenCSV
- **Fake Data Creation**: Faker Library
- **Cloud Testing**: LambdaTest Integration
- **Headless Testing**: Run tests faster in headless mode
- **Command Line Execution**: Maven Surefire Plugin with configurable parameters
- **Reports and Logs**:
  - **Reports**: Generated using ExtentReports
  - **Logs**: Generated using Log4j

---

## Prerequisites

### Software Requirements
- **Java Development Kit (JDK)**: Version 21
   - Ensure `JAVA_HOME` is set correctly.
- **Maven**: Ensure Maven is installed and configured.
- **Git**: To clone this repository.

### Dependencies
All dependencies are managed via Maven and are defined in the `pom.xml` file. They include:
- Selenium
- Webdrivermanager
- TestNG
- OpenCSV
- Faker Library
- ExtentReports
- Log4j
---









## Setup Instsructions

Clone the repository

```bash
  git clone https://github.com/abhishk0037/selenium_personal_project.git

  cd selenium_personal_project
```

**Running tests on LambdaTest-**

  mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadLess=true -X 


**Running tests on chrome browser on local machine in Headless mode-**

  mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadLess=true -X


## Reports and Logs

### Reports
- Test execution results are generated using **ExtentReports**.
- Report file: `reports.html`
- Open the HTML file in any browser to view detailed test results.

### Logs
- Logs are generated using **Log4j**.
- Log directory: `logs/`
- Check the log files for detailed debugging information.


## 🚀 About Me
Hi, My name is Abhishek Yadav and I have 6 years of experience in software testing including 3 years of experience in automation testing using technologies like Selenium Webdriver, restAssured.

My major expertise in Java programming language.


## Author

- [@abhishk0037](https://github.com/abhishk0037/selenium_personal_project)
- EmailAddress- abhishekydv9099@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/abhishk0037)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abhishek-yadav-72945423a/)



