package com.sydney.sample.feature.function.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class StreamTest {

	@Test
	public void testCollectionStream() {
		List<String> list = Arrays.asList("b","d","a","e","e","f","g","e","l","o","u");
		
		
		
		System.out.println(list.stream().findFirst().get());
		list.stream().filter(s -> s.compareTo("e")>0).map(String::toUpperCase).sorted().forEach(System.out::println);

	}
	
	@Test
	public void testStream() {
		IntStream.range(0, 100).forEach(System.out::println);
	}

}
