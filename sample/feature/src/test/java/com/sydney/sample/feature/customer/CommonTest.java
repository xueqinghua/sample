package com.sydney.sample.feature.customer;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.junit.Test;


public class CommonTest {

	
	
	@Test
	public void testMethodHandle() throws Throwable {
		
		
		long start = System.currentTimeMillis();
		
		
		for(int i=0;i<1000000;i++) {
			
			MethodType methodType = MethodType.methodType(Void.TYPE, String.class);
			
			MethodHandles.Lookup lookup = MethodHandles.lookup();
			
			
			MethodHandle methodHandle = lookup.findVirtual(this.getClass(), "out", methodType);

			methodHandle.invoke(new CommonTest(),"aaaaaaaaaaaa");
		}
		
		
		System.out.println(System.currentTimeMillis()-start);
		
		
	}
	
	@Test
	public void TestMethod() throws Exception {
		
		long start = System.currentTimeMillis();
		
		for(int i=0;i<1000000;i++) {
			
			Method method = CommonTest.class.getDeclaredMethod("out",String.class);
			//String.class.getd
			String text = (String) method.invoke(new CommonTest(),"aaaaaaaaaaaa");
		}

		System.out.println(System.currentTimeMillis()-start);
		
	}
	
	
	public  void out(String out) {
		//System.out.println(out);
	}
	
	@Test
	public void testCalendar() {
		Calendar start = Calendar.getInstance();
		start.set(2018, 2, 1, 0, 0, 0);
		System.out.println(Long.toHexString((start.getTime().getTime()/1000)));
		
		Calendar end = Calendar.getInstance();
		end.set(2018, 2,23, 0, 0, 0);
		System.out.println(Long.toHexString((end.getTime().getTime()/1000)));
	}
	
	@Test
	public void testAbs() {
		System.out.println(Math.abs(-199));
	}
	
	@Test
	public void testSplit() {
		String[] macs = "D8-D3-85-B5-04-C1,D8-D3-85-B5-04-C0".split(",");
		System.out.println(macs.length);
	}
	
	
	@Test
	public void testMath() {
		
		System.out.println(System.currentTimeMillis());
	}
	
}
