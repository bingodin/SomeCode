package test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileTree {

	public static void main(String[] args) {

		printFileTreeMyStyel("F:/workspace/test", null);
		// printFileTree("f:/dirTest",null);

	}

	public static void printFileTree(String dirName, String start) {
		if (start == null) {
			System.out.println(dirName);
			start = "";
		}
		File dir = new File(dirName);
		File[] listFiles = dir.listFiles();
		Arrays.sort(listFiles, new ComparableFile());
		int l = listFiles.length;
		for (int i = 0; i < l; i++) {
			String nextstart="";
			if(start.equals("")){
			 	nextstart ="©¦  ";
			}
			else{
				nextstart=start+"       ";
			}
			File file = listFiles[i];
			if(file.isFile()){
				
					System.out.println(nextstart + file.getName());	

			
			}
			else{
				String dirStart = "";
				if (i < l - 1) {
					dirStart = start + "©À©¤";
				} else {
					dirStart = start + "©¸©¤";
					nextstart = start + "       ";
				}
				
		
				System.out.println(dirStart + file.getName());
				printFileTree(file.getPath(), nextstart );
			}
		}

	}
	
	
	public static void printFileTreeMyStyel(String dirName, String start) {
		if (start == null) {
			System.out.println(dirName);
			start = "";
		}
		
		//
		File dir = new File(dirName);
		File[] listFiles = dir.listFiles();
		Arrays.sort(listFiles, new ComparableFile());
		int l = listFiles.length;
		for (int i = 0; i < l; i++) {
			String dirStart;
			if (i < l - 1) {
				dirStart = start + "©À©¤";
			} else {
				dirStart = start + "©¸©¤";    
				

			}
			File file = listFiles[i];
			if(file.isFile()){
					System.out.println(dirStart + file.getName());	}
			else{System.out.println(dirStart + file.getName());
			if(start.equals("")){
				printFileTree(file.getPath(), "©À " );
			}
			else{
				printFileTree(file.getPath(), start );
			}
			}
		}

	}
}

class ComparableFile implements Comparator<File> {

	@Override
	public int compare(File o1, File o2) {
		// TODO Auto-generated method stub
		if (o1.isDirectory() != o2.isAbsolute()) {
			return o1.isFile() ? -1 : 1;
		}
		return 0;
	}
	
	
	
	
	

}
