#include <pthread.h>
#include <iostream>
using namespace std;

void *worker(void *arg)
{
	int *p;
	int x;
	p = (int *) arg; // casting (void *) to (int *)
	x = *p;

	cout << "Hi, my input parameter is " << x << endl;
	return NULL; // Thread exits (dies)
}

int main(int argc, char *argv[])
{
	pthread_t tid;
	int param;
	param = 12345;

	pthread_create(&tid, NULL, worker, &param);
	cout << "Waiting for thread to finish...." << endl;
	pthread_join(tid, NULL);
	return 0;
}