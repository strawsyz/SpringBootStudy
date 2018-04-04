package com.wisely.highlight_spring4.ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct
	public void init(){
		System.out.println("jsr250-init-mehthod");
	}

	public JSR250WayService() {
		super();
		System.out.println("��ʼ�����캯��-JSR250WayService");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("jsr250-destroy-method");
	}
}
