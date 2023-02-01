# Makefile
.PHONY: build

run-dist: build run # Build and run app

run: # Run app
	./build/install/app/bin/app

build: # Build app
	./gradlew clean
	./gradlew installDist