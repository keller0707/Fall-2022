
//
// // from http://www.letmeknows.com/2017/04/24/wait-for-threads-to-finish-java/ //
// This is a very small set up to get people started on using threads
//
//
//
//
//  Adopted by Shaun Cooper
//  last updated November 2020
//
//  We need static variable pointers in the main class so that
//  we can share these values with the threads.
//  the threads are address separate from us, so we need to share
//  pointers to the objects that we are sharing and updating

import java.util.ArrayList;

public class MythreadTest {
    
    private static ArrayList<Thread> arrThreads = new ArrayList<Thread>();

    // we use static variables to help us connect the threads
    // to a common block
    public static int N=0;
    public static int[][] A;

    //main entry point for the process
    
    public static void main(String[] args) {
        try {
		int size = Integer.parseInt(args[0]);
		// create the array from input
		A = new int[size][size];
		//
		// fill array with random valuesvalues
		//

		// create N threads to work on each row
            for (int i = 0; i < 10; i++) 
            {
                Thread T1 = new Thread(new ThreadTest(i));                
                T1.start();                 // standard thread start
                arrThreads.add(T1);
            } 
            
	    // wait for each thread to complete
            for (int i = 0; i < arrThreads.size(); i++) 
            {
                arrThreads.get(i).join(); 
            } 

	    // all the threads are done
	    // do final calculations

	    System.out.println("Main Thread has N as value " + N) ;
            //This for loop will not stop execution of any thread, 
            //only it will come out when all thread are executed    
            
            System.out.println("Main thread exiting ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// each thread should access its row based on "ind"
// and leave results I would suggest in a static array that you need
// to create  in MythreadTest

class ThreadTest implements Runnable {
     private int i;
     ThreadTest(int ind) 
     {
        i = ind;
     }
     public void run() {
        try
        {
    	    MythreadTest.N += i ; // this is a global variable in MythreadTest we add stuff together;

            System.out.println("Thread is started " + i + "Array is " + MythreadTest.A[1][3]);
            Thread.sleep(1000);
            System.out.println("Thread is exiting " + i);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }     }
}
