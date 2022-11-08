// Name          : Keller Sedillo-Garrido
// Date          : 10/31/2022
// Input         : No User Input
// Output        : Prints out File content
// PreCondition  : We expect a valid file input 
// 		         : under the name "ConvertCSVinput"
// PostCondition : This program will save
// 	     	     : the content of the process 
// 		         : to a file called "out"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    
    FILE *fileIn  = fopen("ConvertCSVinput", "r"); // Set Input File
    FILE *fileOut = fopen("out", "w");             // Set Output File

    // Check if File Exists
    if(fileIn == NULL || fileOut == NULL){
        printf("ERROR: Unable to access FIle");
        exit(-1);
    }// End if

    
    char line[100];                 // Holds Line input
    char buffer[500];               // Holds String
    const char *delimiters = ", ."; // Holds delimiters for parsing
    

    // Loop through file
    while ( fgets( line, 100, fileIn ) != NULL ){ 
        line[strlen(line) - 1] = ' ';             // Remove New Line
        sprintf(buffer, line );                   // Save Line into Buffer
        sprintf(buffer + strlen(buffer), " ; ");  // Save ;

        char * token = strtok(line, delimiters); // Create Token
        char * last;                             // Save last token

        while( token != NULL ) {                        // Loop till no more tokens
            if(token[0] >= 97)token[0] = token[0] - 32; // Capitalize Letters
            sprintf(buffer + strlen(buffer), token);    // Save Token to buffer
            sprintf(buffer + strlen(buffer), " ; ");    // Save ;
            last = token;                               // Save Token
            token = strtok(NULL, delimiters);           // Get next token
        }                                               // End while
        
        buffer[strlen(buffer) - (strlen(last) + 3)] = '\n'; // Set New Line
        buffer[strlen(buffer) - (strlen(last) + 2)] = '\0'; // Set End Line
        fprintf(fileOut, "%s", buffer);                     // Writes Line to output
    }                                                       // End While
    
    fclose(fileIn);  // Close File In
    fclose(fileOut); // Close File Out
    return 0;
}// End Main