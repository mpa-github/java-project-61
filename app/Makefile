# Makefile
.PHONY: build

run-dist: build lint run # Build, check and run app

run: # Run app
	./build/install/app/bin/app

build: # Build app
	./gradlew clean
	./gradlew installDist

lint: # Check code style
	./gradlew checkstyleMain