package com.sydney.sample.design.pattern.shop.purchasable;

public class Computer implements Purchasable {

	@Override
	public void purchase(String name) {
		
		System.out.println("purchase computer with money");
		
	}

}
