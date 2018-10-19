package com.zwj.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zwj.dto.User;
import com.zwj.dto.UserQueryCondition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api("swaggerDemoController相关的api")
public class UserController {
 
	
	
	//@RequestMapping(value ="/user1", method = RequestMethod.GET)
    @GetMapping 
    @JsonView(User.userdetail.class)
	public  List<User>  query(@RequestParam(name="username",required = false ,defaultValue="lisi") String nicname){
		System.out.println(nicname);
		List<User> users = new ArrayList<>();
		users.add(new User("xiaoming","123456"));
		users.add(new User("wangwu","123456"));
		users.add(new User("lisi","123456"));
		return users;
	}
    
	//@RequestParam(name="username",required = false ,defaultValue="lisi") String nicname
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @GetMapping(value ="/user2")
	public  List<User>  queryCondition(UserQueryCondition userQueryCondition,@PageableDefault(size=2,page=3,sort="usename,asc") Pageable pageable){
		System.out.println(userQueryCondition);
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users = new ArrayList<>();
		users.add(new User("xiaoming","123456"));
		users.add(new User("wangwu","123456"));
		users.add(new User("lisi","123456"));
		return users;
	}
	
	
	 @GetMapping(value ="/user/{id}")
	public  List<User>  queryCondition(@PathVariable String id){
		System.out.println(id);
		List<User> users = new ArrayList<>();
		users.add(new User("lisi","123456"));
		return users;
	}
}
