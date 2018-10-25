package com.zwj.service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zwj.dao.BookDao;



@Service
public class BookService {
	
	//@Qualifier("bookDao")
	//@Autowired(required=false)
	//@Resource(name="bookDao2")
	/*@Inject*/
	@Autowired(required=false)
	private BookDao bookDao;
	
	public void print(){
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
	
	
	

}
