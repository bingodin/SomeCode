package test;


import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
public class CompilerAndRefect {
	public static void main(String[] args) throws Exception {
		testCompiler();

		
		
	}
	public static void testCompiler() throws Exception {
		String currentDir = System.getProperty("user.dir");
		// ��Դ��д���ļ���
		String src = ""
				+ "public class TestCompiler {"
				+ "	public void disply() {"
				+ "	System.out.println(\"Hello\");"
				+ "}}";
		String filename = currentDir + "/TestCompiler.java";
		File file = new File(filename);
		FileWriter fw = new FileWriter(file);
		fw.write(src);
		fw.flush();
		fw.close();
		// ʹ��JavaCompiler ����java�ļ�
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = jc.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(filename);
		CompilationTask cTask = jc.getTask(null, fileManager, null, null, null, fileObjects);
		cTask.call();
		fileManager.close();
		// ʹ��URLClassLoader����class���ڴ�
		URL[] urls = new URL[] { new URL("file:/" + currentDir + "/") };
		URLClassLoader cLoader = new URLClassLoader(urls);
		Class<?> c = cLoader.loadClass("TestCompiler");
		cLoader.close();
		// ����class����ʵ��������ִ�з���
		Object obj = c.newInstance();
		Method method = c.getMethod("disply");
		method.invoke(obj);
	}
}