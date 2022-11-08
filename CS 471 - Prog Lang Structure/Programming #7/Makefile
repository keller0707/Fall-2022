all: build run

build: convert.c
	gcc -o convert convert.c

run: convert
	./convert

clean:
	rm convert
