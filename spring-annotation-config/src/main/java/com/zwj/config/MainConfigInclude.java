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
						// �Զ�����˹���
						@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
				  //�ر�Ĭ�ϣ�Ĭ���Ǽ������е�@controller/service/repository/component
				},useDefaultFilters = false)	
		}
		)
@Configuration  //����Spring����һ��������
public class MainConfigInclude {
	
	//��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
