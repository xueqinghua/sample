package com.sydney.sample.feature.customer;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.sydney.sample.feature.customer.entity.Customer;

public class ClassLoadTest {

	@Test
	public void test() throws Exception {
		
		try {
			ClassLoader classLoader = new ClassLoader() {

				@Override
				public Class<?> loadClass(String name) throws ClassNotFoundException{
					
					
					String fileName = name.replaceAll("\\.","\\\\")+".class";
					
					
					InputStream inputStream = null;
					try {
						String directory = new File(".").getCanonicalPath()+"\\target\\classes\\";
						
						inputStream = new FileInputStream(directory+fileName);
					
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

					
					if (inputStream==null) {
						return super.loadClass(fileName);
					}
					
					byte[] bytes;
					try {
						bytes = new byte[inputStream.available()];
						inputStream.read(bytes);
						return defineClass(name, bytes, 0, bytes.length);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return super.loadClass(name);
				}
			};
			
			Object object = classLoader.loadClass("com.sydney.sample.feature.customer.entity.Customer").newInstance();
			
			
			System.out.println(object.getClass());
			System.out.println(object instanceof Customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
