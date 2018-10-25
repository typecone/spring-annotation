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

//������==�����ļ�


/*@ComponentScans(
		value = {
				@ComponentScan(value="com.atguigu",includeFilters = {
						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
						@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
				},useDefaultFilters = false)	
		}
		)*/
//@ComponentScan  value:ָ��Ҫɨ��İ�
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ����ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������
@ComponentScans(
		value = {
				@ComponentScan(value="com.zwj",excludeFilters= {
					//ָ��ĳһ��ע��@controller/@repository/@compnement/@service �������뵽IOC����
					@Filter(type=FilterType.ANNOTATION,classes= {Controller.class}),
					// ָ������ĳһ���࣬��ע�뵽IOC������
					@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class})
				})
		}
		)
@Configuration  //����Spring����һ��������
public class MainConfigExclude {
	
	//��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}