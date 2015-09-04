// ConsoleApplication1.cpp : Defines the entry point for the console application.
//
/*

Ã°ÅÝÅÅÐòµÄÊä³ö
4       6       2       1

4       2===>>>>6       1
4       2       1===>>>>6
2===>>>>4       1       6
2       1===>>>>4       6
1===>>>>2       4       6

1       2       4       6




*/
#include "stdafx.h"
void printArr(int	*a, int len);
void showArrBubble(int	*a, int len, int p, int l);
int _tmain(int argc, _TCHAR* argv[])
{
	int len = 4;
	int a[] = {4,6,2,1};
	printArr(a, len);
	printf("\n");
	for (int i = 0; i < len-1;i++){
		for (int j = 0; j < len-1-i;j++){
			if (a[j]>a[j+1]){
				int temp = a[j+1];
				a[j+1] = a[j];
				a[j] = temp;
				showArrBubble(a, len, j, j + 1);
			}
		}
	}
	printf("\n");
	printArr(a,len);
	getchar();
	return 0;
}

void printArr(int	*a, int len){
	for (int i = 0; i <= len - 1; i++){
		printf("%d\t", *a++);
	}
	printf("\n");

}
void showArrBubble(int	*a, int len, int p, int l){
	for (int i = 0; i <= len - 1; i++){
		if (i == p){
			printf("%d===>>>>", *a++);
		}
		else{
			printf("%d\t", *a++);
		}


	}
	printf("\n");

}