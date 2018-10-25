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

//配置类==配置文件


/*@ComponentScans(
		value = {
				@ComponentScan(value="com.atguigu",includeFilters = {
						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
						@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
				},useDefaultFilters = false)	
		}
		)*/
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
@ComponentScans(
		value = {
				@ComponentScan(value="com.zwj",excludeFilters= {
					//指定某一个注解@controller/@repository/@compnement/@service ，不加入到IOC容器
					@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
					// 指定具体某一个类，不注入到IOC容器里
					@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class})
				})
		}
		)
@Configuration  //告诉Spring这是一个配置类
public class MainConfigExclude {
	
	//给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
