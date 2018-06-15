package com.sydney.sample.feature.memory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sydney.sample.feature.customer.entity.Customer;
import com.sydney.sample.feature.memory.entity.Imagination;

public class MemoryTest {

	@Test
	public void testOutOfMemory() {
		
		List<Imagination> imaginations = new ArrayList<>();
		
		while(true) {
			imaginations.add(new Imagination());
		}
		
		
		
	}

}
