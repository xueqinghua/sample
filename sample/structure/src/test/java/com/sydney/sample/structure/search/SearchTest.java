package com.sydney.sample.structure.search;


import java.util.TreeSet;

import org.junit.Test;

public class SearchTest {

	@Test
	public void testBinarySearch() {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,19,21,22,35,36,37,63,90};
		
		int low = 0,high = arr.length-1;
		
		int searchWord = 37;
		
		int index = -1;
		
		
		while(low<high) {
			int middle = (low+high)/2;
			
			if(arr[middle]==searchWord) {
				index = middle;
				break;
			}
			
			if(arr[middle]>searchWord) {
				high = middle-1;
				continue;	
			}
			
			if(arr[middle]<searchWord) {
				low = middle+1;
				continue;	
			}

		}
		
		System.out.println("index:"+index+",value:"+(index>-1?arr[index]:index));	
	}
	
	@Test
	public void test() {
		
		System.out.println(3/2);
		
	}
	
	
	private void adjustHeap(int[] arr,int parent,int length) {
		
		int temp = arr[parent];
		int child = parent*2+1;
		
		while(child<length) {
			
			if(child+1<length&&arr[child]<arr[child+1]) {
				child++;
			}
			
			if(arr[child]<=arr[parent]) {
				break;
			}
			
			
			arr[parent] = arr[child];
			
			
			parent = child;
			child = parent*2+1;
			
			arr[parent] = temp;
		}
		
		arr[parent] = temp;
	}
	
	private void printPart(int[] list,int begin,int end) {
		for(int i=0;i<begin;i++) {
			System.out.println("\t");
		}
		
		for(int i=begin;i<=end;i++) {
			System.out.println(list[i]+"\t");
		}
		
		System.out.println();
	}
	
	@Test
	public void heapSort() {
		
		int[] arr = {3,2,10,90,20,30,99,12,89,32,100,200,1000,21,999,199,0,20};
		
		for(int i=arr.length/2;i>=0;i--) {
			adjustHeap(arr, i, arr.length);
		}
		
		
		
		
		
		for(int i=arr.length-1;i>0;i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			adjustHeap(arr, 0, i);
			System.out.format("第%d趟:\t",arr.length-i);
			
			printPart(arr, 0, arr.length-1);
			
		}
	}
	
	
	private void testParameter(long time,String ...keys) {
		System.out.println(time);
		for(String key:keys) {
			System.out.println(key);
		}
	}
	
	@Test
	public void testInvoke() {
		testParameter(10,"16","12");
	}
	
	
	
	
}
