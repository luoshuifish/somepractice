#include<stdio.h>
#include<stdlib.h>

//定义堆栈
#define MAX_SIZE 100
#define  top1 1

//定义堆
typedef int DataType;

typedef struct{
	DataType stack[MAX_SIZE];
	int top;
}SeqStack;

void StackInit(SeqStack* st){	
	st->top = 0;
}

int StackIsEmpty(SeqStack* st){
	return st->top == 0;
}

int StackIsFull(SeqStack* st){
	return st->top == MAX_SIZE;
}

void StackPush(SeqStack* st, DataType data){

	if (StackIsFull(st)){
		printf("栈已满");
	}else{
		st->stack[st->top] = data;
		st->top  += 1 ;
	}
}

DataType StackPop(SeqStack* st){
	return StackIsEmpty(st)? printf("wrong\n"):st->stack[st->top - 1 ];
}

int main(){
	
	SeqStack* seqS; 
	seqS = (SeqStack*)malloc(sizeof(SeqStack));
	
	StackInit(seqS);

	for (int i=0; i<100; i++){
		StackPush(seqS,i);
	}
	for (int i=0; i<100; i++){
		StackPop(seqS);
	}
	printf("%d",seqS->top);

	free(seqS);

	return 0;

}