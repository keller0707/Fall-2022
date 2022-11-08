// Name          : Keller Sedillo-Garrido
// Date          : 10/18/2022
// Input         : No User Input
// Output        : Prints out File content
// PreCondition  : No Precondition since no 
// 		         : user input.
// PostCondition : This program will print
// 		         : out the content of the 
// 		         : given file.

// Libraries
import java.io.File;
import java.util.Scanner;

public class fileConversion {
    // Global Var
    static char stx = (char)2;  // ^B Char
    static char etx = (char)3;  // ^C Char
    public static void main(String[] args) {
        try{
            // Get File
            File file = new File("control-char.txt");      // Create file Class
            if(!file.exists()){                            // Check if file exists
                throw new Exception("File Doesn't Exist"); // throw Exception 
            }                                              // END if

            // Init. Var.
            Scanner scanner = new Scanner(file); // Scanner for file
            Boolean flag = true;                 // Flag for printing
            String stringSet = "";               // String Set to print

            // Read and print file
            while (scanner.hasNextLine()){
                // Get line
                String line = scanner.nextLine().toString();

                // Check for ^C & ^B
                for(int i = 0; i < line.length(); i++){ // Loop through String
                    if (line.charAt(i)== etx){          // Check if ^C
                        flag = false;                   // Set flag flase
                    }else if(line.charAt(i) == stx){    // Check if ^B
                        flag = true;                    // Set flag true
                    }                                   // END elseIf
                
                    // If flag is true, save char
                    if(flag) stringSet = stringSet + line.charAt(i);
                }// END FOR
                
                // Print if newline
                if (flag){                         // Check flag
                    System.out.println(stringSet); // Print String Set
                    stringSet = "";                // Clean String Set
                }                                  // END if
            }// END while

            // Close scanner once done
            scanner.close();
        }catch(Exception e){
            // Print Error
            System.err.println(e);
        }// END tryCatch
    }// END main
}// END fileConversion
