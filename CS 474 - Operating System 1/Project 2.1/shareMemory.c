/* 
 * Name   : Keller Sedillo-Garrido
 * Date   : 17/10/22
 * Input  : No input required
 * Output : The counter from the child
 *        : process.
 */
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <stdio.h>

#define SHM_KEY ((key_t) 1497)

typedef struct{
  int value;
} shared_mem;
shared_mem *total;

void process(int num){         
    int i;                     // Create incrment 
    for (i = 0; i < num; i++){ // Loop 
        total->value++;        // Update Value
    }                          // End For
}                              // End Process

int main(){
    //Init Int
    int shmid, ID, status;
    int pids[4];
    int pid;
    int increment[] = {100000,200000,300000,500000};
    char *shmadd;
    shmadd = (char *) 0;

    printf("\n");
    /*Create and connect to a shared memory segment*/
    if ((shmid = shmget (SHM_KEY, sizeof(int), IPC_CREAT | 0666)) < 0){
        perror ("shmget");
        return 1;     
    }// End if

    if ((total = (shared_mem *) shmat (shmid, shmadd, 0)) == (shared_mem *) -1) {
        perror ("shmat");
        return 0;
    }// End if

    total->value = 0; // Set Value
    int i;            // Create Increment

    // Create & Run Child processes.
    for(i = 0; i < 4; i++){                                                 // Loop through 4 times
        if(fork() == 0){                                                    // Check if Child was created
            process(increment[i]);                                          // Call Process
            printf("From Process %d: counter = %d.\n", i+1,  total->value); // Print Counter
            exit(0);                                                        // Terminate CHILD!
        }                                                                   // End if
    }                                                                       // End For

    // Wait for process to end
    pids[0] = wait(NULL);
    pids[1] = wait(NULL);
    pids[2] = wait(NULL);
    pids[3] = wait(NULL);

    //Print exit process.
    for(i = 0; i < 4; i++)printf("Child with ID: %d has just exited.\n", pids[i]);
   
    //Detach Memory
    if (shmdt(total) == -1) {
        perror("shmdt");
        return 1;
    }// End if

    // Destroy the shared memory
    if (shmctl(shmid, IPC_RMID, NULL) == -1) {
      perror("shmctl");
      return 1;
    }// End if 
}// End Main