package com.wisely.highlight_spring4.ch2.prepost;

public class BeanWayService {
	public void init(){
		System.out.println("@Bean-init-mehthod");
	}

	public BeanWayService() {
		super();
		System.out.println("��ʼ�����캯��-BeanWayService");
	}
	
	public void destroy(){
		System.out.println("@Bean-destroy-method");
	}

}
