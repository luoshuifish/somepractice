#include <stdio.h>
#include "genlib.h"

#define  MIN_INDEX 0
#define  MAX_INDEX 100

int Fib(int n);
int AdditiveSequence(int n, int t0, int t1);

int main(){
	int i;

	printf("This program lists the Fibonacci sequence.\n");
	for (i = MIN_INDEX; i<MAX_INDEX; i++){
		printf("Fib(%d)", i);
		if (i < 10) printf(" ");
		printf(" = %4d\n", Fib(i));
	}
	return 0;
}

//没有效率
/*int Fib(int n){
	if (n < 2){
		return n;
	}else{
		return (Fib(n-1) + Fib(n-2));
	}
}*/

//一个更有效率的版本
int Fib(int n){
	
	return AdditiveSequence(n, 0 , 1);

}

int AdditiveSequence(int n, int t0, int t1){
	
	if (n == 0) return t0;
	if (n == 1) return t1;
	return AdditiveSequence(n-1, t1, t0+t1);

}