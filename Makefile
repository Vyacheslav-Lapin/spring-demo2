.DEFAULT_GOAL := build-run

build-run: build run

build:
	./mvnw verify

run:
	./mvnw spring-boot:start -Dspring.profiles.active=local

test:
	./mvnw test

update:
	./mvnw versions:update-properties versions:display-plugin-updates

delombok: clean
	mkdir -p ./target/generated-sources/delombok ./target/generated-test-sources/delombok
	./mvnw lombok:delombok lombok:testDelombok

clean:
	./mvnw clean
