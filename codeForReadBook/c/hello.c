#include<stdio.h>
int main(){
	/**
	int start,stop,step;
	int c;float f;
	start =0,stop=300,step=20;c=start;
	while(c<stop){
		f=(c-32)*5/9.0;
		printf("%d\t%f\n",c,f);
		c=c+step;
	}
	int ch;
	while((ch=getchar())!=EOF)putchar(ch);
	// ./a.out <hello.c >text		
	printf("%d,%c\n",EOF,EOF);
	
	**/
		
	int ch, chs=2,lines=0;
	while((ch=getchar())!=EOF){
	if(ch=='\n')lines++;
	chs++;
	}
	printf("%dL\t%dC\n",lines,chs);
	printf("--------------------------\n");
}
