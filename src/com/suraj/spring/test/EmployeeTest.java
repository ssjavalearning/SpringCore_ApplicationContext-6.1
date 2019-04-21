package com.suraj.spring.test;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suraj.spring.beans.Employee;

public class EmployeeTest {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext context = null;
		try {
			// if spring.xml file is in classpath location then use ClassPathXmlApplicationContext.
			context = new ClassPathXmlApplicationContext("spring.xml");
			Employee employee = context.getBean("employee", Employee.class);
			System.out.println(employee.getEmpId()+"\t"+employee.getEmpName());
		} catch (BeansException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				((AbstractApplicationContext) context).close();
			}
		}
	}
}
