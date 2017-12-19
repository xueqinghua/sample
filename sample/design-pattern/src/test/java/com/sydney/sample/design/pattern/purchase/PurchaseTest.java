package com.sydney.sample.design.pattern.purchase;

import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.sydney.sample.design.pattern.shop.purchasable.CglibProxy;
import com.sydney.sample.design.pattern.shop.purchasable.Computer;
import com.sydney.sample.design.pattern.shop.purchasable.Purchasable;
import com.sydney.sample.design.pattern.shop.purchasable.PurchaseInvocationHandler;

import net.sf.cglib.proxy.Enhancer;

public class PurchaseTest {

	@Test
	public void testInvocationHandler() {
		
		
		
		Computer computer = new Computer();
		
		PurchaseInvocationHandler purchaseInvocationHandler = new PurchaseInvocationHandler(computer);
		
		Purchasable proxy =  (Purchasable) Proxy.newProxyInstance(Computer.class.getClassLoader(),computer.getClass().getInterfaces(),purchaseInvocationHandler);
		
		proxy.purchase("computer");
		
		
		
	}
	
	@Test
	public void testCglib() {
		CglibProxy cglibProxy = new CglibProxy();
		
		
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Computer.class);
		enhancer.setCallback(cglibProxy);
		
		Computer proxy = (Computer) enhancer.create();
		
		proxy.purchase("computer");
	}

}
