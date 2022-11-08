all: build run

build: processCreation.c
	gcc -o processCreation processCreation.c
run: processCreation
	./processCreation 11

clean:
	rm processCreation
