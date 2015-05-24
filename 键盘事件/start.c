//#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
void open();//打开浏览器
void close();//关闭浏览器
void input(char *c);//输入文字
void click();//点击鼠标

main()
{
//定义需要搜索的 计数 长度
char *sa[]={"JAVA","XIANHUA","NIUREN","C","MEINV"};
int i=0,len=5;
while(1){
	open();
    input(sa[i%len]);
	click();
    close();
    i++;
    }

}
void open(){
ShellExecute(0,"open","www.baidu.com",0,0,1);//异步打开
Sleep(1500);//等待打开
}
void input(char *c){
Sleep(1000);
char temc='n';
while(*c){
temc=*c++;
//printf("%c",temc);
keybd_event( temc,0,0,0 );
keybd_event( temc,0,2,0);
Sleep(20);//输入字符  等待键盘
}
Sleep(500);
keybd_event( ' ',0,0,0 );//输入空格
keybd_event( ' ',0,2,0);
Sleep(500);
keybd_event( 0x0D,0,0,0 );//点击回车  确定输入
keybd_event( 0x0D,0,2,0);
Sleep(500);
keybd_event( 0x0D,0,0,0 );//点击回车  搜索
keybd_event( 0x0D,0,2,0);
}

void click(){
Sleep(2000);
SetCursorPos(170,240);//等待结果  移动鼠标
Sleep(40);
mouse_event(MOUSEEVENTF_LEFTDOWN,0,0,0,0);
Sleep(20);
mouse_event(MOUSEEVENTF_LEFTUP,0,0,0,0);//点击鼠标
}
void close(){
Sleep(4000);
//system("taskkill /f /im QQBrowser.exe");//关闭进程
}
