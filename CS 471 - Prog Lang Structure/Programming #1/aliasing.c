/***
 * aliasing.c
 * Made By: Keller Sedillo-Garrido
 * Date: August 18
 *
 ***/

//Libary
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
   //Local Vars	
   int A[100];
   char *S;

   //Assign int array
   A[0] = 'lleK'; 
   A[1] = 'S re'; 
   A[2] = 'lide';
   A[3] = 'G-ol';
   A[4] = 'irra';
   A[5] = 'od'  ;
   A[6] = '0'   ; //End String
   
   //Point S to A
   S = (char *) A;

   //Print S
   printf("My name is %s\n",S);

   return 0;
}//End main
