package com.qa.springboot.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {
	
	@Test
	public void show(){
		List<String> list= new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("----------------------");
		list.remove(2);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
