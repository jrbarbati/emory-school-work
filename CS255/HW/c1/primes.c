/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR   
OR CODE WRITTEN BY OTHER STUDENTS - Joseph Barbati */

/*

to compile:
gcc -g -c main.c
gcc -g -c primes.c
gcc -g -o main main.o primes.o

*/
#include <stdio.h>
#include "header.h"

#define MAX 1000000

void clearAll();
void setBit(int n);
int  isPrime(int n);

void sieveOfE(int N)
{
	int i, j, k;
	// resets prime, just in case.
	clearAll();

	for(i = 2; i <= N; i++)
	{
		k = 0;
		for(j = i*i; j <= N; j = i*i + k*i)
		{	
			if(j % i == 0)
			{	
				setBit(j);
			}
			k++;
		}
		if (i*i > N) { break; }  
	}
}

int countPrimes(int N)
{	
	int i, count;

	count = 0;

	for(i = 2; i <= N; i++)	
	{
		if(isPrime(i))
		{
			count++;
		}
	}

	return count;
}

void printPrimes(int k1, int k2, int N)
{
	int i, diff, count;
	count = 0;
	diff = k2 - k1;

	for(i = 2; i <= N; i++)
	{
		if(isPrime(i))
		{
			count++;
			if (count >= k1)
			{
				printf("%d\n", i);
				diff--;
			}
		}

		if(diff < 0) { break; }
	}
}

void clearAll()
{
	int i;
	int len; 
	
	len = sizeof(prime)/sizeof(prime[0]);
	
	for(i = 0; i < len; i++) 
	{
		prime[i] = 0;
	}
}

// 0's mean it is prime, 1's mean not prime
void setBit(int n)
{
	int index, bit;
	
	// Want to change the (j / 32)th index in prime at the (j % 32)th bit at 
	// that index.
	index = n / 32;
	bit = n % 32;	

	// by using |, we preserve what is there, but if it is 0, we make it a 1.
	prime[index] |= (1 << bit);
}

int isPrime(int n)
{
	int index, bit;
	
	index = n / 32;
	bit = n % 32;
	
	// if prime[index] & mask creates 0, then it is prime, so return 1
	if (!(prime[index] & (1 << bit)))
	{
		return 1;
	}
	else
	{
		return 0;
	}
}