#include <stdio.h>

void Hanni(int n, char a_tower, char b_tower, char c_tower ){
	if (n==1){
		printf("from %c to %c\n", a_tower, c_tower);
	}else{
		Hanni(n-1, a_tower, c_tower, b_tower);
		printf("from %c to %c\n", a_tower, c_tower);
		Hanni(n-1,b_tower, a_tower, c_tower);
	}
}

int main(){
	Hanni(3,'a','b','c');
	return 0;
}