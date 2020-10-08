package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.spring.ex01.PersonService;

public class PersonTest2 {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		
		com.spring.ex02.PersonService person1 = (com.spring.ex02.PersonService) factory.getBean("personService1");
		person1.sayHello();
		
		System.out.println();

		com.spring.ex02.PersonService person2 = (com.spring.ex02.PersonService) factory.getBean("personService2");
		person2.sayHello();
	}
}
