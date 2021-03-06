package com.kh.spring.di.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.spring.di.model.xml.Person;

/**
 * Servlet implementation class DependencyXML
 */
@WebServlet("/xmlDI.do")
public class DependencyXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyXML() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 객체 의존성 : 객체를 생성할 때 new 를 통해 생성하는 것 뿐아니라 메소드를 사용하든, 어떤 방법으로든 객체의 정보를 전달 받는 것
		 * 
		 * 1. 생성자를 통한 의존성 주입 방법
		 * 	Person p = new Person("김선호","차차차");
		 * 2. setter를 통한 의존성 주입 방법
		 * 	p.setName("김선호");
		 * 3. 다른 메소드를 통한 의존성 주입 방법
		 * 	Connection con = getConnection();
		 * */
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/di-xml-context.xml");
		//getBean은 bean으로 등록되어야만 사용가능 
		Person p1 = (Person)cntx.getBean("person1");
		System.out.println("p1"+p1);
		p1.getMyFood().eat("푸라닭");
		
		Person p2 = (Person)cntx.getBean("person2");
		System.out.println("p2"+p2);
		p2.getMyFood().eat("굽네");
		
		//싱글톤으로 p1과 p3는 같은 사람이다.
		Person p3 = (Person)cntx.getBean("person1");
		System.out.println("p3"+p3);
		p3.getMyFood().eat("푸라닭");
		
		Person p4 = (Person)cntx.getBean("person2");
		System.out.println("p4"+p4);
		p4.getMyFood().eat("굽네");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
