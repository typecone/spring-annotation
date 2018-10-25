package com.zwj.template;

public abstract class BankTemplateMethod {
      
	public  void  takeNumber() {
		System.out.println("取号");
	}
	
	public abstract void transact();
	
	public void  ecaluate() {
		System.out.println("反馈评分");
	}
	
	
	public final void process() {
		takeNumber();
		transact();
		ecaluate();
	}
}
