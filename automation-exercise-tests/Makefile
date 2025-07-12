# Automation Exercise Tests Makefile
.PHONY: build test lint run clean help

# Default target
build: clean compile

# Clean and compile with strict settings
compile:
	@echo "Compiling with Java 21 and strict settings..."
	mvn -q clean compile -Pstrict

# Run all tests (unit + integration) and generate Serenity report
test:
	@echo "Running tests and generating Serenity report..."
	mvn -q verify

# Run Checkstyle checks
lint:
	@echo "Running Checkstyle checks..."
	mvn -q checkstyle:check

# Alias for test (useful for CI)
run: test

# Clean target
clean:
	@echo "Cleaning project..."
	mvn -q clean

# Help target
help:
	@echo "Available targets:"
	@echo "  build   - Clean and compile with strict settings (default)"
	@echo "  test    - Run unit + integration tests, generate Serenity report"
	@echo "  lint    - Run Checkstyle checks"
	@echo "  run     - Alias for test (CI-friendly)"
	@echo "  clean   - Clean project artifacts"
	@echo "  help    - Show this help message"
