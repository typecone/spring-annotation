package com.zwj.dto;

public class UserQueryCondition {
   private String  username;
   private String  passowrd;
   private Integer   age;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassowrd() {
	return passowrd;
}
public void setPassowrd(String passowrd) {
	this.passowrd = passowrd;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
@Override
public String toString() {
	return "UserQueryCondition [username=" + username + ", passowrd=" + passowrd + ", age=" + age + "]";
}
   
}
