package com.sydney.sample.design.pattern.shop.purchasable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PurchaseInvocationHandler implements InvocationHandler {
	
	
	private Object target;
	
	
	public PurchaseInvocationHandler(Object target) {
		this.target = target;
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("choose the commodity which you like");
		Object result =  method.invoke(target, args);
		System.out.println("pay the bill");
		return result;
	}

}
