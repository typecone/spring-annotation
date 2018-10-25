package com.zwj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.zwj.bean.Person;
import com.zwj.service.BookService;

import org.springframework.context.annotation.ComponentScan.Filter;


import org.springframework.context.annotation.ComponentScans;

@ComponentScans(
		value = {
				@ComponentScan(value="com.zwj",includeFilters = {
						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
						// 自定义过滤规则
						@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
				  //关闭默认，默认是加载所有的@controller/service/repository/component
				},useDefaultFilters = false)	
		}
		)
@Configuration  //告诉Spring这是一个配置类
public class MainConfigInclude {
	
	//给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
