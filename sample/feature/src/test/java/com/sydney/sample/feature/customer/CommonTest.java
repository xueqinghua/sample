package com.sydney.sample.feature.customer;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Calendar;

import org.junit.Test;


public class CommonTest {

	@Test
	public void testEvaluation() {
		int a = 100;
		int b = 200;
		
		a = a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("a:"+a+",b:"+b);
	}
	
	@Test
	public void testexclusiveOREvaluation() {
		int a = 100;
		int b = 200;
		
		a = a^b;
		b=a^b;
		a=a^b;
		
		System.out.println("a:"+a+",b:"+b);
		
	}
	
	
	@Test
	public void testMethodHandle() throws Throwable {
		
		
		long start = System.currentTimeMillis();
		
		
		for(int i=0;i<1000000;i++) {
			
			MethodType methodType = MethodType.methodType(Void.TYPE, String.class);
			
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			
			
			MethodHandle methodHandle = lookup.findVirtual(this.getClass(), "out", methodType);

			methodHandle.invoke(this,"aaaaaaaaaaaa");
		}
		
		
		System.out.println(System.currentTimeMillis()-start);
		
		
	}
	
	@Test
	public void TestMethod() throws Exception {
		
		long start = System.currentTimeMillis();
		
		for(int i=0;i<1000000;i++) {
			
			Method method = CommonTest.class.getDeclaredMethod("out",String.class);
			//String.class.getd
			String text = (String) method.invoke(this,"aaaaaaaaaaaa");
		}

		System.out.println(System.currentTimeMillis()-start);
		
	}
	
	
	public  void out(String out) {
		//System.out.println(out);
	}
	
}
