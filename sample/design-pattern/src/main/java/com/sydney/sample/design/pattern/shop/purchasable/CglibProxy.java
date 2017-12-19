package com.sydney.sample.design.pattern.shop.purchasable;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("choose commodity which you like");
		
		Object result = methodProxy.invokeSuper(object, args);
		
		System.out.println("pay the bill");
		
		return null;
	}

}
