package com.kh.spring.di.model.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	//클래스를 스프링 설정 클래스로 지정하고 스프링 빈으로 등록을 하겠다.
public class BeanFactory {
	
	@Bean	//메소드가 생성한 객체를 스프링이 관리하는 빈으로 등록
	public Person createPerson() {
		Person p1 = new Person();
		p1.setName("유재석");
		
		Food myfood = new Chicken();
		p1.setMyFood(myfood);
		return p1;
	}

	@Bean
	public Person createPerson2() {
		Food myfood = new Pizza();
		return new Person("이효리", myfood);
	}
}
