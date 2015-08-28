

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//java Xmlappend 1.xml >2.xml
public class Xmlappend {
public static void main(String[] args) {
	File file = new File(args[0]);
	BufferedReader reader = null;
	try {

		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		while ((tempString = reader.readLine()) != null) {
				// È¥µô¿ÕÐÐ
				if(tempString.length()>0)
				System.out.println("sb.append(\""+tempString+"\");");
			
			
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}