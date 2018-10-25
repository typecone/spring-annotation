package com.zwj.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionAddressingConstants;
import com.zwj.bean.Person;
import com.zwj.config.MainConfigExclude;
import com.zwj.config.MainConfigInclude;


public class IocTest {

	@Test
	public void testExclude() {
		AnnotationConfigApplicationContext acac = new 	AnnotationConfigApplicationContext(MainConfigExclude.class);
		   // 取出所有注入到IOC容器的key 的名字
	       String[]   names = acac.getBeanDefinitionNames();
	       for (String string : names) {
			System.out.println(string);
		   }
	       // 取出IOC容器中的对象
	       Person person = acac.getBean(Person.class);
	       System.out.println(person);
	  
	}
	@Test
	public void testInclude() {
		AnnotationConfigApplicationContext acac = new 	AnnotationConfigApplicationContext(MainConfigInclude.class);
		   // 取出所有注入到IOC容器的key 的名字
	       String[]   names = acac.getBeanDefinitionNames();
	       for (String string : names) {
			System.out.println(string);
		   }
	       // 取出IOC容器中的对象
	       Person person = acac.getBean(Person.class);
	       System.out.println(person);
	  
	}

}
