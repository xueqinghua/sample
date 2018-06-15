package com.sydney.sample.feature.common.util;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.CountDownLatch;

import javax.print.attribute.standard.RequestingUserName;

import org.junit.Test;

public class PackageNameTest {
	
	public static int count = 0;

	@Test
	public void test() {
		//File file = new File("D:\\resources\\github\\abel533_guns\\guns\\src");
		
		
		File file = new File("D:\\resources\\github\\abel533_guns\\guns\\src");

		renamePackage(file);
		
		System.out.println("count:"+count);
		
		
	}
	
	
	public void renamePackage(File file) {
		if (file.isDirectory()) {
			
			FilenameFilter filenameFilter = new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					
					
					
					File file = new File(dir,name);
					
					boolean matched = name.endsWith(".xml")||file.isDirectory();
					
					//System.out.println(file.getAbsolutePath()+",match:"+matched);
					// TODO Auto-generated method stub
					return matched;
				}
			};

			for(File fileElement:file.listFiles(filenameFilter)) {
				renamePackage(fileElement);
			}
		}else {
			count++;
			try {
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
				
				
				StringBuffer stringBuffer = new StringBuffer("");
				
				
				
				bufferedReader.lines().forEach((String line)->stringBuffer.append(line+"\n"));
				
				
				System.out.println(stringBuffer);
				
				
				File outFile = new File(file.getAbsolutePath());
				
				
				FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
				
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
				
				bufferedWriter.write(stringBuffer.toString().replaceAll("com.stylefeng.guns","cn.wywk.vip"));
				bufferedWriter.flush();
				bufferedWriter.close();
				outputStreamWriter.close();
				fileOutputStream.close();
				
				//System.out.println(file.getAbsolutePath());
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
			
			
		}
	}

}
