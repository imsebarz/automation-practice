# Automation Exercise Tests

A comprehensive UI automation testing suite for [automationexercise.com](https://automationexercise.com/) using Cucumber + Serenity-BDD with the Screenplay pattern.

## 🚀 Features

- **Java 21** with strict compilation settings
- **Serenity-BDD** with Screenplay pattern for maintainable and readable tests
- **Cucumber** for behavior-driven development with Gherkin syntax
- **Selenium WebDriver 4.x** for browser automation
- **Maven** build system with comprehensive plugins
- **Checkstyle** enforcement with Google Java Style Guide
- **Make** targets for simplified build and test execution

## 📋 Prerequisites

Before running the tests, ensure you have the following installed:

- **JDK 21** or higher
- **Maven 3.9.0** or higher
- **Make** utility
- **Google Chrome** or **Chromium** browser
- **Git** (for version control)

### Verification Commands

```bash
java -version    # Should show Java 21 or higher
mvn -version     # Should show Maven 3.9.0 or higher
make --version   # Should show GNU Make
google-chrome --version  # Should show Chrome version
```

## 🏗️ Project Structure

```
automation-exercise-tests/
├── Makefile                           # Build automation
├── pom.xml                           # Maven configuration
├── src/
│   ├── main/java/com/sebastian/automationexercise/
│   │   ├── screenplay/
│   │   │   ├── actors/               # Actor factory
│   │   │   ├── tasks/                # User actions/workflows
│   │   │   ├── interactions/         # Low-level interactions
│   │   │   └── questions/            # Verification queries
│   │   └── ui/                       # Page objects with locators
│   └── test/
│       ├── java/com/sebastian/automationexercise/
│       │   ├── runners/              # Cucumber test runners
│       │   └── steps/                # Step definitions
│       └── resources/
│           ├── features/             # Gherkin feature files
│           └── serenity.conf         # Serenity configuration
└── target/                           # Build outputs and reports
```

## 🧪 Test Scenarios

The test suite covers the following scenarios:

1. **User Registration** - Register a new user with random credentials
2. **Successful Login** - Login with valid existing credentials
3. **Failed Login** - Attempt login with invalid credentials
4. **User Logout** - Logout from an active session
5. **Duplicate Registration** - Attempt to register with existing email

## 🚀 How to Run

### Quick Start

```bash
# Clone and navigate to project
cd automation-exercise-tests

# Run all tests with single command
make test
```

### Available Make Targets

| Target | Description |
|--------|-------------|
| `make build` | Clean and compile with strict settings (default) |
| `make test` | Run unit + integration tests, generate Serenity report |
| `make lint` | Run Checkstyle checks |
| `make run` | Alias for test (CI-friendly) |
| `make clean` | Clean project artifacts |
| `make help` | Show available targets |

### Maven Commands (Alternative)

```bash
# Compile with strict settings
mvn clean compile -Pstrict

# Run tests and generate reports
mvn verify

# Run only Checkstyle checks
mvn checkstyle:check
```

## 📊 Test Reports

After running tests, comprehensive reports are generated:

### Serenity Report
- **Location**: `target/site/serenity/index.html`
- **Features**: Interactive HTML report with screenshots, step details, and test results
- **Access**: Open in browser to view detailed test execution results

### Cucumber Reports
- **HTML**: `target/cucumber-reports/`
- **JSON**: `target/cucumber-reports/Cucumber.json`
- **JUnit XML**: `target/cucumber-reports/Cucumber.xml`

### Maven Surefire/Failsafe Reports
- **Location**: `target/surefire-reports/` and `target/failsafe-reports/`

## ⚙️ Configuration

### Browser Configuration
Tests run in **Chrome** by default. To run in headless mode, uncomment the headless option in `Users.java`:

```java
// options.addArguments("--headless");
```

### Test Data
- **Valid Password**: `S3curePwd_2025`
- **Existing Test Account**: 
  - Email: `existing_user@example.com`
  - Name: `ExistingUser`
  - Password: `S3curePwd_2025`

### Serenity Configuration
Modify `src/test/resources/serenity.conf` to adjust:
- Screenshot capture settings
- Timeouts and delays
- Browser options
- Report configurations

## 🔍 Quality Gates

This project enforces strict quality standards:

- ✅ **Zero compiler warnings** with `-Werror -Xlint:all`
- ✅ **Checkstyle compliance** with Google Java Style Guide
- ✅ **No @SuppressWarnings** annotations allowed
- ✅ **Java 21** enforcement via Maven Enforcer Plugin
- ✅ **Maven 3.9+** version requirement

## 🏗️ CI/CD Ready

The project is designed for continuous integration:

```bash
# Single command for CI pipeline
make test
```

Add this badge to your CI system:
```markdown
![Tests](https://img.shields.io/badge/tests-passing-brightgreen)
![Java](https://img.shields.io/badge/java-21-orange)
![Maven](https://img.shields.io/badge/maven-3.9+-blue)
```

## 🛠️ Development

### Adding New Tests
1. Create feature file in `src/test/resources/features/`
2. Add step definitions in `src/test/java/.../steps/`
3. Implement tasks/questions as needed
4. Run `make test` to verify

### Code Style
- Follow Google Java Style Guide
- Use `make lint` to check compliance
- No warnings allowed in compilation

### Debugging
- Set breakpoints in step definitions
- Use `target/site/serenity/index.html` for detailed execution flow
- Check browser automation via Chrome DevTools

## 📝 Acceptance Checklist

- ✅ Compiles with Java 21 without warnings
- ✅ `make build test lint` all succeed
- ✅ All 5 test scenarios pass against live site
- ✅ Serenity report generated successfully
- ✅ Checkstyle reports 0 violations
- ✅ Maven Enforcer validates Java 21+ and Maven 3.9+
- ✅ No @SuppressWarnings annotations used
- ✅ CI-ready with single `make test` command

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Ensure all quality gates pass: `make build test lint`
4. Submit a pull request

## 📄 License

This project is intended for educational and testing purposes.
