//#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
void open();//�������
void close();//�ر������
void input(char *c);//��������
void click();//������

main()
{
//������Ҫ������ ���� ����
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
ShellExecute(0,"open","www.baidu.com",0,0,1);//�첽��
Sleep(1500);//�ȴ���
}
void input(char *c){
Sleep(1000);
char temc='n';
while(*c){
temc=*c++;
//printf("%c",temc);
keybd_event( temc,0,0,0 );
keybd_event( temc,0,2,0);
Sleep(20);//�����ַ�  �ȴ�����
}
Sleep(500);
keybd_event( ' ',0,0,0 );//����ո�
keybd_event( ' ',0,2,0);
Sleep(500);
keybd_event( 0x0D,0,0,0 );//����س�  ȷ������
keybd_event( 0x0D,0,2,0);
Sleep(500);
keybd_event( 0x0D,0,0,0 );//����س�  ����
keybd_event( 0x0D,0,2,0);
}

void click(){
Sleep(2000);
SetCursorPos(170,240);//�ȴ����  �ƶ����
Sleep(40);
mouse_event(MOUSEEVENTF_LEFTDOWN,0,0,0,0);
Sleep(20);
mouse_event(MOUSEEVENTF_LEFTUP,0,0,0,0);//������
}
void close(){
Sleep(4000);
//system("taskkill /f /im QQBrowser.exe");//�رս���
}
