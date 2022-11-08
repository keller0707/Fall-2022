all: build run

build: shareMemory.c
	gcc -o shareMemory shareMemory.c
run: shareMemory
	./shareMemory

clean:
	rm shareMemory
