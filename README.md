
# Measure Code Coverage in a Running Java Application Using JaCoCo

## Description

When developing software, it's crucial to know how much of your codebase is covered by tests. This repository demonstrates how to use the JaCoCo (Java Code Coverage) tool to measure code coverage in a running Java application.

## Full Article

For a detailed explanation, check out the full article: [JaCoCo Code Coverage Guide](https://dev.to/arturmkr/how-to-measure-code-coverage-in-a-running-java-application-using-jacoco-5b13)

## Usage

### Download JaCoCo Tools

To download the required JaCoCo tools, run the following `curl` commands:

```bash
curl -O https://repo1.maven.org/maven2/org/jacoco/org.jacoco.cli/0.8.12/org.jacoco.cli-0.8.12-nodeps.jar
curl -O https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/0.8.12/org.jacoco.agent-0.8.12-runtime.jar
```

### Build the Project

```bash
./gradlew build
```

### Run the Java Application with JaCoCo Agent

```bash
java '-javaagent:org.jacoco.agent-0.8.12-runtime.jar=port=6300,address=0.0.0.0,destfile=jacoco.exec,includes=com.example.*,append=true,output=tcpserver' -jar build/libs/demo_api_server-0.0.1-SNAPSHOT.jar
```

### Interact with the Application

Example API call:

```bash
curl http://localhost:8080/multiple?num1=11&num2=2
```

### Dump Coverage Data

After running your tests or interacting with the application, dump the coverage data:

```bash
java -jar org.jacoco.cli-0.8.12-nodeps.jar dump --address localhost --port 6300 --destfile jacoco.exec --reset
```

### Generate HTML Coverage Report

Generate the coverage report to view in the browser:

```bash
java -jar org.jacoco.cli-0.8.12-nodeps.jar report jacoco.exec --classfiles build/classes/java/main --sourcefiles src/main/java --html coverage_report
```

### Notes
- Adjust the paths and package names (`com.example.*`) according to your project structure if they differ.
