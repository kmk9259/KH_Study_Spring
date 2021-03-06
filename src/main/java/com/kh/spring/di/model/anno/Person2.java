package com.kh.spring.di.model.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person2 {
	@Value("유야호")
	private String name;
	
	//@Autowired만 적으면 spring이 뭘 가져다 쓰라는지 모름 방법1. 주입시킬때 pizza라고 이름 쓰기 2. 우선순위를 주기(@Primary)
	@Autowired		
	@Qualifier("pizza")
	private Food myFood;
	public Person2() {
		// TODO Auto-generated constructor stub
	}
	public Person2(String name, Food myFood) {
		super();
		this.name = name;
		this.myFood = myFood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Food getMyFood() {
		return myFood;
	}
	public void setMyFood(Food myFood) {
		this.myFood = myFood;
	}
	@Override
	public String toString() {
		return name+" ~~ "+myFood;
	}
	

}
