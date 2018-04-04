package com.wisely.highlight_spring4.ch1.di;
//di±Ì ædependency injection-DI
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.SayHello("haha"));
		context.close();
	}
	
}
