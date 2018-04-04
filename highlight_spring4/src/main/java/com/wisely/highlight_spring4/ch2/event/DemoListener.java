package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

	@Override
	public void onApplicationEvent(DemoEvent event) {

		String msg = event.getMsg();
		System.out.println("��DemoListener�յ���demo-publisher��������Ϣ :"+msg);
		
	}

	
}
