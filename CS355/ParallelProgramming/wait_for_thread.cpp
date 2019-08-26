#include <pthread.h>
#include <iostream>
using namespace std;

void *worker(void *arg)
{
	char dummy[10];
	printf("Worker thread: hit enter to exit......");
	scanf("%s", dummy);
	return NULL;
}

int main(int argc, char *argv[])
{
	pthread_t tid;
	pthread_create(&tid, NULL, worker, NULL);
	cout << "Waiting for thread to finish...." << endl;
	pthread_join(tid, NULL);
}