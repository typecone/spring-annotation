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
		   // ȡ������ע�뵽IOC������key ������
	       String[]   names = acac.getBeanDefinitionNames();
	       for (String string : names) {
			System.out.println(string);
		   }
	       // ȡ��IOC�����еĶ���
	       Person person = acac.getBean(Person.class);
	       System.out.println(person);
	  
	}
	@Test
	public void testInclude() {
		AnnotationConfigApplicationContext acac = new 	AnnotationConfigApplicationContext(MainConfigInclude.class);
		   // ȡ������ע�뵽IOC������key ������
	       String[]   names = acac.getBeanDefinitionNames();
	       for (String string : names) {
			System.out.println(string);
		   }
	       // ȡ��IOC�����еĶ���
	       Person person = acac.getBean(Person.class);
	       System.out.println(person);
	  
	}

}
