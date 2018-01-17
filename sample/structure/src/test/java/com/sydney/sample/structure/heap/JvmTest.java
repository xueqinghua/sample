package com.sydney.sample.structure.heap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class JvmTest {
	
	
	
	static {
		if(true) {
			while(true) {
				
			}
		}
	}

	@Test
	public void testHeapOOM() {
		
		try {
			List<Object> list = new ArrayList<>();
			while (true) {
				list.add(new ArrayList<>(10));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGC() throws Exception {
		byte[] objectA = new byte[3*1024*1024];
		byte[] objectB = new byte[3*1024*1024];
		byte[] objectC = new byte[3*1024*1024];
		byte[] objectD = new byte[1*1024*1024];
		
		
		Thread.sleep(50000);
		
	}

}
