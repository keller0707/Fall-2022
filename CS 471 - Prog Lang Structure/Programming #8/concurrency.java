/*
 * Name          : Keller Sedillo-Garrido
 * Date          : 11/10/2022
 * Input         : Input the size of the matrix
 *               : (N X N)
 * Output        : Output the max, min, and average
 *               : of the whole matrix
 * Precondition  : The input for N is expected to be
 *               : a positive nonzero number
 * Postcondition : The program is expected to print
 *               : out the max, min, and avg of the
 *               : whole matrix.
 */

import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

public class concurrency {
    
    //Global Var.
    private static ArrayList<Thread> arrThreads = new ArrayList<Thread>(); // List of Threads
    public static int[][] matrix;                                          // Matrix of Ints
    public static int[] arrMax;                                            // Matrix of Maxs
    public static int[] arrMin;                                            // Matrix of Mins
    public static int[] arrAvg;                                            // Matrix of Args
    public static int n;                                                   // Size of Array
    public static void main(String[] args) {

        // Inital Var.
        int totalMax;    // Holds the max of the whole matrix
        int totalMin;    // Holds the min of the whole matrix
        int totalAvg;    // Holds the avg of the whole matrix
        long startTime;  // Holds start time
        long endTime;    // Holds end time
        long totalTime;  // Holds total time
        double totalSec; // Holds total time in sec

        /* Get array size from command line */
        if (args.length != 1){                          // Check if we have been given only one input
            System.err.println("ERROR: Invalid Input"); // Print ERROR
            System.exit(0);                             // Exit System.
        }                                               // End if

        // Get Size from args
        n = Integer.valueOf(args[0]);
        
        // Create Matrix
        matrix = new int[n][n];

        /* Create random values */
        Random rand = new Random();       // Random Class
        double upper = Math.pow(2, 32-n); // Upper Bound
        double lower = Math.pow(2, 31-n); // Lower Bound
        int randNum;                      // Holds Random number

        for/*  */(int row = 0; row < n; row++){                                     // Loop through rows
            for(int col = 0; col < n; col++){                                 // Loop through columns
                randNum = (int)((upper - lower) * rand.nextDouble() + lower); // Calculate random value
                matrix[row][col] = randNum;                                   // Save number
            }                                                                 // End for
        }                                                                     // End For

        /* START TIMER */
        startTime = System.nanoTime();

        // Initialize arrays
        arrMax = new int[n]; 
        arrMin = new int[n]; 
        arrAvg = new int[n]; 

        try{

            // Start Threads
            for (int i = 0; i < n; i++){                         // Loop through N rows
                Thread thread = new Thread(new threadMatrix(i)); // Create thread
                thread.start();                                  // Start thread
                arrThreads.add(thread);                          // Add thread to array list
            }                                                    // End for
            
            // Wait for Threads
            for(int i = 0; i < arrThreads.size(); i++){ // Loop through threads
                arrThreads.get(i).join();               // Wait for thread to die
            }                                           // End for 

            // Set values
            totalMax = arrMax[0];
            totalMin = arrMin[0];
            totalAvg = arrAvg[0];

            // Loop through arrays
            for(int i = 1; i < n; i++){                        // Loop through the arrays
                if(arrMax[i] > totalMax) totalMax = arrMax[i]; // Update Max
                if(arrMin[i] < totalMin) totalMin = arrMin[i]; // Update Min
                totalAvg += arrAvg[i];                         // Update Avg
            }                                                  // End for
            totalAvg = totalAvg/n;                             // Final update on avg

            /* STOP TIMER */
            endTime = System.nanoTime();            // Get End Time
            totalTime = endTime - startTime;        // Calculate Total Time
            totalSec = totalTime / Math.pow(10, 9); // Adjust time to Sec

            /* Print Values */
            System.out.println("=-=-=-=-=-=-=-=-=-=-= " + n + " =-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Total Max:             " + totalMax);
            System.out.println("Total Min:             " + totalMin);
            System.out.println("Total Average:         " + totalAvg);
            System.out.println("Time Elapsed(NanoSec): " + totalTime);
            System.out.println("Time Elapsed(Sec):     " + totalSec);

        }catch(Exception e){
            // Print Error
            System.err.println(e.getMessage());
        } // End tryCatch
    } // End main
} // End concurrency

class threadMatrix implements Runnable {

    // Local Var
    private int max;
    private int min;
    private int avg;
    private int rowIndex;

    threadMatrix(int index){ // Constructor
        rowIndex = index;    // Save row index
    }                        // End threadMatrix

    public void run(){
        
        try{
            // Set values to the first element in the row.
            max = concurrency.matrix[rowIndex][0];
            min = concurrency.matrix[rowIndex][0];
            avg = concurrency.matrix[rowIndex][0];

            
            int curser;                                   // Walk down the array.
            for(int i = 1; i < concurrency.n; i++){       // Loop through the col in the row
                curser = concurrency.matrix[rowIndex][i]; // Set curser
                if(curser > max) max = curser;            // Update Max
                if(curser < min) min = curser;            // Update Min
                avg += curser;                            // Update Avg
            } // End for

            // Set final result.
            concurrency.arrMax[rowIndex] = max;               // Set final max
            concurrency.arrAvg[rowIndex] = avg/concurrency.n; // Set final avg
            concurrency.arrMin[rowIndex] = min;               // Set final min

        }catch(Exception e){
            // Print error.
            System.err.println(e.getMessage());
        } // End tryCatch
    } // End run
} // End 
