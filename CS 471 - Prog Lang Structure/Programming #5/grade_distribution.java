/* 
 * Name          : Keller Sedillo-Garrido
 * Date          : 10/03/22
 * Input         : Takes in Grade numbers.
 * Output        : The frequency of the grades.
 * PreCondition  : Integers are Grade numbers and 
 *               : is expected to be with the range 
 *               : of [0, 100].
 * PostCondition : Will print out the frequencies of
 *		         : the grades that has been imported.
 */


// Libaries
import java.util.Scanner;

public class grade_distribution {
    public static void main(String[] args) {
        // Setting Variables
        int Freq[] = new int[10];                 // Create Array
        int New_Grade, Index, Limit_1, Limit_2;   // Create Intergers
        Scanner scanner = new Scanner(System.in); // Create Scanner

        while (true){                                   // Loop till break
            try{                                        // Check the Input of the User
                System.out.println("Input Grade:");     // Ask for input
                if(!scanner.hasNextInt()) break;        // Check if next input is int
                New_Grade = scanner.nextInt();          // Set New Grade
            }catch(java.util.InputMismatchException e){ // Throw invalid input 
                break;                                  // Break whileLoop
            }                                           // End tryCatch
            
            try{                                                                     // Update Frequency  
                if(100 >= New_Grade && New_Grade >= 0) throw new Exception("Valid"); // Check if input is VALID
                System.err.print("Error -- new grade: ");                            // PRINT ERROR
                System.err.print(New_Grade);                                         // PRINT ERROR
                System.err.print(" is out of range");                                // PRINT ERROR
            }catch(Exception e){                                                     // Catch Expection
                Index = New_Grade/10;                                                // Find Index
                if (New_Grade == 100) Freq[9] = Freq[9] + 1;                         // Check if grade is 100
                else Freq[Index] = Freq[Index] + 1;                                  // Update Frequency
            }                                                                        // End tryCatch
        }                                                                            // End while

       
        /* Print Out Frequency */
        scanner.close();                                          // Close scanner.
        System.out.println("\n  Limits           Frequency\n\n"); // Print headers
        for(Index = 0; Index <= 9; Index++){                      // Loop Through Frequency Array
            Limit_1 = 10 * Index;                                 // Set Limit_1
            Limit_2 = Limit_1 + 9;                                // Set Limit_2
            if (Index == 9) Limit_2 = 100;                        // Edit Last Upper Limit to 100
            System.out.printf("%3d - ",     Limit_1);             // Print Lower Limit
            System.out.printf("%-3d     ", Limit_2);              // Print Upper Limit
            System.out.printf("%10d\n",   Freq[Index]);           // Print Frequency 
        }                                                         // End for
    }                                                             // End main
}                                                                 // End grade_distribution