package com.wisely.highlight_springmvc4.web.ch4_3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisely.highlight_springmvc4.domain.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {
	
	
	@RequestMapping(produces= "text/plain;charset=UTF-8")
	public @ResponseBody String  index (HttpServletRequest request ){
		return "url:" + request.getRequestURL()+" can access";
	}
	
	@RequestMapping(value="/pathvar/{str}",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str , HttpServletRequest request){
		return  "url" + request.getRequestURL()+" can access,str: "+str;
	}
	
	@RequestMapping(value="/requestParam",produces="text/palin;charset=UTF-8")
	public @ResponseBody String demoRequestParam(Long id,HttpServletRequest request){
		return "url" + request.getRequestURL()+" can access,id: "+id;
	}
	
	@RequestMapping(value="/object",produces="application/json;charset=UTF-8")//打开这个页面，会下载一个json文件 文件名为xx.json xx是url最后一个斜杠后门见的字符们
	public @ResponseBody String passObj(DemoObj obj,HttpServletRequest request){
		return "url" + request.getRequestURL()+" can access,obj id: "+obj.getId()+" obj name:"+obj.getName();
	}
	
	@RequestMapping(value={"/name1","/name2"},produces="text/palin;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request){
		return "url:" + request.getRequestURL()+" can access";
	}
	
	
}
