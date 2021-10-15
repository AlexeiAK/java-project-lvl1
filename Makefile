# Clean results of previous build, and generate executable file
install:
	./gradlew clean install

# Run executable file (do this after build)
run-dist:
	./build/install/app/bin/app

# Check updates for dependencies (libraries; plugins from build.gradle)
check-updates:
	./gradlew dependencyUpdates

# Compile project and run from console
run:
	./gradlew clean
	./gradlew run

# Check code-style
lint:
	./gradlew checkstyleMain

#
build:
	./gradlew clean build

.PHONY: build