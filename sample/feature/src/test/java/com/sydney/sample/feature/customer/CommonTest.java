package com.sydney.sample.feature.customer;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.security.AlgorithmConstraints;
import java.util.List;

import org.junit.Test;

import com.sydney.sample.feature.customer.entity.Customer;
import com.sydney.sample.feature.customer.entity.Person;

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
		
		
		MethodType methodType = MethodType.methodType(String.class, int.class, int.class);
		
		MethodHandles.Lookup lookup = MethodHandles.lookup();
		
		MethodHandle methodHandle = lookup.findVirtual(String.class, "substring", methodType);
		
		
		System.out.println(methodHandle.invoke("this is a test",1,3));
		
		
	}
	
}
