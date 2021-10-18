package com.kh.spring.di.model.anno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component("chicken")	//id 설정과 같음-> 낙타 표기법
public class Chicken implements Food {

	@Override
	public void eat(String foodName) {
		System.out.println("집에서 "+foodName+"치킨을 먹는 중!" );
	}

}
