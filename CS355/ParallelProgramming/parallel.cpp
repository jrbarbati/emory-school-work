#include <pthread.h>
#include <iostream>
using namespace std;

/* ==================================
    Thread prints "Hello World"
    ================================== */
 void *worker(void *arg)
 {
   cout << "Hello World !" << endl;

   return(NULL);     /* Thread exits (dies) */
 }

 /* =================================================
    MAIN: create a trhead and wait for it to finish
    ================================================= */
 int main(int argc, char *argv[])
 {
    pthread_t  tid;

    /* ---------------------                                         
       Create threads                                                
       (Use default thread attribute values)                         
       --------------------- */                                      
    if ( pthread_create(&tid, NULL, worker, NULL) )                  
    {	                                                             
       cout << "Cannot create thread" << endl;                       
       exit(1);                                                      
    }	                                                             
 	    
    cout << "Main waits for thread to finish...." << endl ;
 	    
    pthread_join(tid, NULL);
 	    
    exit(0);
 }