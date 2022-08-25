/***
 * aliasing.c
 * Made By: Keller Sedillo-Garrido
 * Date: August 18
 * Input 
 ***/

//Libary
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Defines
#define ABYTE      256 // One Byte
#define BBYTE    65536 // Two Bytes
#define CBYTE 16777216 // Three Bytes

int main(){
   //Local Vars	
   int A[100];
   char *S;

   //Assign int array
   A[0] = 'K' + 'e' * ABYTE + 'l' * BBYTE + 'l' * CBYTE; // Kell 
   A[1] = 'e' + 'r' * ABYTE + ' ' * BBYTE + 'S' * CBYTE; // er S
   A[2] = 'e' + 'd' * ABYTE + 'i' * BBYTE + 'l' * CBYTE; // edil
   A[3] = 'l' + 'o' * ABYTE + '-' * BBYTE + 'G' * CBYTE; // lo-G
   A[4] = 'a' + 'r' * ABYTE + 'r' * BBYTE + 'i' * CBYTE; // arri
   A[5] = 'd' + 'o' * ABYTE;                             // do
   A[6] = '0';                                           // End String
   A[7] = 'T';
   
   //Point S to A
   S = (char *) A;

   //Print S
   printf("My name is %s\n",S);

   //Print pointer
   printf("S is located at    : %20u\n", &S);

   //Print Array
   printf("A[0] is located at : %20u\n", A[0]);

   return 0;
}//End main
