
/**
韩顺平java lesson  1-2

**/
public class HelloWorld{
	public static void main(String[] argv){
	//install jdk set path javac HelloWold.java java HelloWold
	System.out.println("hello world");//no space no upper no "1"
	//------------------------------------------------------------------------------------
	//define ini assignment
	int a = 10; 
	int b = 20;
	System.out.println(a+b);//var and op
	//------------------------------------------------------------------------------------
	/**
	The range of Byte
	1	2	3	4	5	6	7	8

	0	0	0	0	0	0	0	0 	0
	1	0	0	0	0	0	0	0 	-128 (本来是-0)
	1	1	1	1	1	1	1	1	127 2^7-1


	**/
	float f= 1.0f;//or this will need double  3.4 defalut is double
	System.out.println(f);
	//char
	char c1='你';//2 byte
	c1='a'+1; //'b'  有没有自动转换 字面值1的默认类型？
	//'a'+10000000; will be error be careful 
	System.out.println(c1);	
	//byte short int long float double low to high
	int fti  = (int )1.2;
	System.out.println(fti);
	}
}