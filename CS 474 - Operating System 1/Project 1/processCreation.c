// Header files
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
  
//=-=-=-=-= Function =-=-=-=-=//

// Function: 
// 	collatz()
//
// Desc: 
// 	This function will print the
//	Collatz conjecture sequence.
//
// Inputs:
// 	num : The current number in the sequence.
// 	i   : The number assigned to the child. This is
// 	      to make the print statement clear and to
// 	      indicate which child is currently doing the
// 	      process.
//
// Output:
// 	Sequence of numbers in the terminal
int collatz(int num, int i, char *b){
	//Print current number in the sequence
	sprintf(b, "%sProcess %d: %d\n",b, i, num);

	//Check if end of sequence
	if(num == 1) return sprintf(b,"%s\n",b);

	//Apply algorithm
	if(num%2 == 0) return collatz(num/2, i, b);
	else return collatz((3*num)+1, i, b);
}//End collatz

//=-=-=-=-= Main =-=-=-=-=//
char buffer[1000];
int main(int argc, char *argv[]){

	//Check Input
	if(argc != 2 || atoi(argv[1]) < 0 || atoi(argv[1]) >= 40) {
		printf("Invalid Input\n");
		exit(EXIT_FAILURE);
	}//End if

	//Save Input
	int userNum = atoi(argv[1]);
	printf("User Inputed: %s\n", argv[1]);
		
	//Create Child Process
	pid_t pId1;
       	pid_t pId2;
	
	//Fork the first Child.
	pId1 = fork();
	if(pId1 == 0){
		//Run Process
		collatz(userNum, 1, buffer);
		
	}else{
		wait(NULL);
		//Fork the second Child
		pId2 = fork();
		if(pId2 == 0) 
			//Run Process
			collatz(userNum + 4, 2, buffer);
		else{ 
			//Wait till child process finish
			wait(NULL);
			
			//Print
			puts(buffer);
			printf("Child Complete\n");
		}//End ifElse

	}//End ifElse
	return 0;
}//End main
