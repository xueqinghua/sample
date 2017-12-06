package com.sydney.sample.dynamic.datasource.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sydney.sample.dynamic.datasource.Starter;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Starter.class)
public class BaseTest {

	@Test
	public void test() {
		System.out.println("------------");
	}

}
