package com.wisely.highlight_springmvc4;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;
import com.wisely.highlight_springmvc4.messageconverter.MyMessageConverter;

//Spring MVC配置
@Configuration
@EnableWebMvc
@EnableScheduling//开始计划任务的支持
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter{

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/index");//指向index.jsp
		registry.addViewController("/toUpload").setViewName("/upload");//指向upload.jsp
		registry.addViewController("/converter").setViewName("/converter");//指向converter.jsp
		registry.addViewController("/see").setViewName("/see");//指向see.jsp
		registry.addViewController("/async").setViewName("/async");//指向async.jsp
	}

	//配置自定义的HttpMessageConverter的Bean
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
	}
//返回自定义的HttpMessageConverter
	@Bean
	public MyMessageConverter converter(){
		return new MyMessageConverter();
	}
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("assets/**").addResourceLocations("classpath:/assets/");
	}
	
	@Bean//自定义的用来显示处理时间的过滤器
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}

	@Override//相当于配置过滤器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}

	@Override//重写configurePathMatch，使得"."后面的参数不被忽略
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		multipartResolver.setMaxUploadSize(1000000);
		
		return  multipartResolver;
	}
	
}
