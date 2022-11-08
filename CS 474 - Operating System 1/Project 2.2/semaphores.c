#define _REENTRANT
#include <pthread.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <semaphore.h>

char newChar;
File *fp;
fp = fopen("mytest.dat", "r");
while (fscanf(fp,"%c",&newChar) != EOF){
    
}// End While
close(fp);
